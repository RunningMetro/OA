package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import model.Mail;
import model.User;
import service.IUserService;
import util.Constants;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService ser;
	
	@RequestMapping("/tologin.do")
	public String tologin(){
		return "login";
	}
	//登录判断
	@RequestMapping("/login.do")
	@ResponseBody
	public String doLogin(User user,HttpSession session) throws Exception{
		User findUser = ser.findByUsername(user);
		if(findUser !=null){
			if(findUser.getPassword().equals(user.getPassword())){
				//允许登录
				session.setAttribute("sessionUser", findUser);
				return Constants.LOGIN_SUCCESS;
			}
		}
		return Constants.LOGIN_FAIL;
	}
	//登录用户首页
	@RequestMapping("/index.do")
	public String toIndex() throws Exception{
		return "index";
	}
	@RequestMapping("/indexAdmin.do")
	public String toIndexAdmin(){
		return "indexAdmin";
	}
	//用户登出
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("sessionUser");
		//session.invalidate();
		return "redirect:/user/tologin.do";
	}
	//编辑数据(个人信息页面)
	@RequestMapping("/edit.do")
	public String edit(User user){
		return "edit";
	}
	//修改数据(个人信息页面)
	@RequestMapping("/change.do")
	public String change(User user,HttpSession session) throws Exception{
		ser.modify(user);
		session.setAttribute("sessionUser", user);
		return "redirect:/user/index.do";
	}
	//跳转到个人账户页面
	@RequestMapping("/toAccount.do")
	public String toAccount(HttpSession session){
		return "account";
	}
	//编辑个人账户页面
	@RequestMapping("/editAccount.do")
	public String editAccount(User user){
		return "editAccount";
	}
	//修改个人账户页面
	@RequestMapping("/changeAccount.do")
	public String changeAccount(User user,HttpSession session) throws Exception{
		ser.modifyAccount(user);
		session.setAttribute("sessionUser", user);
		return "redirect:/user/toAccount.do";
	}
	//获得所有用户(邮箱)
	@RequestMapping("/getAll.do")
	public String getAll(HttpSession session) throws Exception{
		List<User> findAll = ser.findAll();
		session.setAttribute("alluser", findAll);
		return "redirect:/mail/toWriteEmail.do";
	}
	//获得所有的管理员
	@RequestMapping("/getAllAdmin.do")
	public String getAllAdmin(HttpSession session) throws Exception{
		List<User> allAdmin = ser.findAllAdmin();
		session.setAttribute("allAdmin", allAdmin);
		return "redirect:/rest/restRequire.do";
	}
	//获得所有用户(管理员)
	@RequestMapping("/toAllAccount.do")
	public String getAllUser(HttpServletRequest request) throws Exception{
		List<User> all = ser.findAll();
		request.setAttribute("all", all);
		return "allaccount";
	}
	//添加用户页面
	@RequestMapping("/toadduser.do")
	public String toadduser(){
		return "adduser";
	}
	//添加用户
	@RequestMapping("/adduser.do")
	public String adduser(User user,HttpServletRequest request) throws Exception{
		ser.save(user);
		List<User> all = ser.findAll();
		request.setAttribute("all", all);
		return "allaccount";
	}
	//验证用户名是否已被注册
	@RequestMapping("/checkname.do")
	public void checkname(String username,HttpServletResponse response) throws IOException{
		PrintWriter pw = response.getWriter();
		User user = ser.findByName(username);
		if(user!=null){
			pw.print(false);
		}else{
			pw.print(true);
		}
	}
	//获得除了当前用户以外的用户
	@RequestMapping("/getAllExcept.do")
	public String getAllExcept(Model model,HttpSession session) throws Exception{
		User user = (User) session.getAttribute("sessionUser");
		System.out.println(user);
		List<User> findAll = ser.findAllExcept(user.getId());
		model.addAttribute("alluser", findAll);
		return "forward:/mail/toWriteEmail.do";
	}
	//分页插件测试
	@RequestMapping("/ceshi.do")
	public String test(@RequestParam(required = false, defaultValue = "1") Integer startPage,
            @RequestParam(required = false, defaultValue = "5") Integer PageSize,Model model){
		PageHelper.startPage(startPage,PageSize);
		List<User> list = new ArrayList<>();
		list = ser.findAllUser();
		PageInfo<User> pi = new PageInfo<>(list);
		model.addAttribute("list",list);
		return "ceshi";
	}
	}

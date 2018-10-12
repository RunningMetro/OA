package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import model.Mail;
import model.Pagination;
import model.User;
import service.IMailService;
import service.IUserService;

@Controller
@RequestMapping("/mail")
public class MailController {
	@Autowired
	private IMailService ser;
	@Autowired
	private IUserService user;
	//文件上传
	@RequestMapping("/upload.do")
	public String upload(Mail mail,MultipartFile img,HttpServletRequest request,Model model) throws IllegalStateException, IOException{
		if(img.getSize()>9437184){
			model.addAttribute("mess", "↑↑不能超过9m↑↑");
			model.addAttribute("mail", mail);
			return "forward:/user/getAllExcept.do";
		}else if(img.getSize()==0){
			model.addAttribute("mess", "↑↑文件上传不能为空↑↑");
			model.addAttribute("mail", mail);
			return "forward:/user/getAllExcept.do";
		}else{
			String path = request.getServletContext().getRealPath("/WEB-INF/files/");
			String uuid = UUID.randomUUID().toString().replace("-", "");
			int i = img.getOriginalFilename().lastIndexOf(".");
			String last = img.getOriginalFilename().substring(i,img.getOriginalFilename().length());
			File file = new File(path+"\\"+uuid+last);
			mail.setAttachment(path+"\\"+uuid+last);
			mail.setIsread(1);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			mail.setCreateTime(sdf.format(date));
			mail.setIsDelete(0);
			mail.setRealname(img.getOriginalFilename());
			img.transferTo(file);
			ser.saveMail(mail);
			return "redirect:/mail/toWriteEmail.do?send=1";
		}	
	}
	//收件箱首页
	@RequestMapping("/getAll.do")
	public String getAll(Integer nowPage,HttpSession session,Model model){
		User user = (User) session.getAttribute("sessionUser");
		int maxpage=3;
		int firstpage=1;
		if(nowPage!=null){			
			firstpage=nowPage;
		}
		//分页
		Pagination pagination = ser.findPagination(user, firstpage, maxpage);
		List<Mail> list = pagination.getList();
		List<Mail> newAll = new ArrayList<>();
		for (Mail mail : list) {
			if(mail.getContent().length()>5){
				String newContext = mail.getContent().substring(0, 5);
				newContext+="...";
				mail.setContent(newContext);
			}
			if(mail.getIsDelete()==0){
				newAll.add(mail);
			}
		}
		System.out.println(pagination.getCurrentPage());
		model.addAttribute("allmail",newAll);
		model.addAttribute("fenye",pagination);
		return "receiveEmail";
		//没分页代码
		/*List<Mail> selectAll = ser.selectAll(user);
		List<Mail> newAll = new ArrayList<>();
		for (Mail mail : selectAll) {
			if(mail.getContent().length()>5){
				String newContext = mail.getContent().substring(0, 5);
				newContext+="...";
				mail.setContent(newContext);
			}
			if(mail.getIsDelete()==0){
				newAll.add(mail);
			}
		}
		request.setAttribute("allmail", newAll);
		return "receiveEmail";*/
	}
	//垃圾箱首页
	@RequestMapping("/getAllDelete.do")
	public String getAllDelete(HttpSession session,HttpServletRequest request){
		User user = (User) session.getAttribute("sessionUser");
		List<Mail> selectAll = ser.selectAll(user);
		List<Mail> newAll = new ArrayList<>();
		for (Mail mail : selectAll) {
			if(mail.getContent().length()>5){
				String newContext = mail.getContent().substring(0, 5);
				newContext+="...";
				mail.setContent(newContext);
			}
			if(mail.getIsDelete()==1){
				newAll.add(mail);
			}
		}
		request.setAttribute("allmail", newAll);
		return "deleteEmail";
	}
	//收件箱单个邮件
	@RequestMapping("/todetailsEmail.do")
	public String todetailsEmail(String mailId,HttpServletRequest request) throws Exception{
		Mail mail = ser.selectById(mailId);
		mail.setIsread(0);
		ser.modifyMail(mail);
		User user2 = user.findById(mail.getToID().toString());
		request.setAttribute("user", user2);
		request.setAttribute("mail", mail);
		return "detailsEmail";
	}
	//已发邮件箱单个邮件
		@RequestMapping("/toSendeddetailsEmail.do")
		public String toSendeddetailsEmail(String mailId,HttpServletRequest request) throws Exception{
			Mail mail = ser.selectById(mailId);
			ser.modifyMail(mail);
			User user2 = user.findById(mail.getToID().toString());
			request.setAttribute("user", user2);
			request.setAttribute("mail", mail);
			return "detailsEmail";
		}
	//垃圾箱单个邮件
		@RequestMapping("/todetailsEmail2.do")
		public String todetailsEmail2(String mailId,HttpServletRequest request) throws Exception{
			Mail mail = ser.selectById(mailId);
			mail.setIsread(0);
			ser.modifyMail(mail);
			User user2 = user.findById(mail.getToID().toString());
			request.setAttribute("user", user2);
			request.setAttribute("mail", mail);
			return "detailsEmail2";
		}
	//下载附件
	@RequestMapping("/download.do")
	public ResponseEntity<byte[]> doDownload(String id) throws IOException{
		Mail mail = ser.selectById(id);
		String location=mail.getAttachment();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachement;filename="+URLEncoder.encode(mail.getRealname(), "utf-8"));
		HttpStatus statusCode = HttpStatus.OK;
		FileInputStream is = new FileInputStream(location);
		byte[] bs = new byte[is.available()];
		is.read(bs);
		is.close();
		ResponseEntity<byte[]> entity = new ResponseEntity<>(bs,headers,statusCode);
		return entity;
	}
	//删除邮件(通往垃圾邮件)
	@RequestMapping("/delete.do")
	public String delete(String id){
		ser.removeById(id);
		return "redirect:/mail/getAll.do";
	}
	//删除邮件(垃圾邮件不显示)
	@RequestMapping("remove.do")
	public String remove(String id){
		ser.deleteById(id);
		return "redirect:/mail/getAllDelete.do";
	}
	//还原邮件
	@RequestMapping("return.do")
	public String returns(String id){
		ser.backEmail(id);
		return "redirect:/mail/getAllDelete.do";
	}
	//跳转到写邮件页面
	@RequestMapping("/toWriteEmail.do")
	public String toWriteEmail(String send,Model model){
		System.out.println(send);
		if(send==null){
			return "writeEmail";			
		}else if("1".equals(send)){
			model.addAttribute("sended", 1);
			return "writeEmail";
		}
		return null;
	}
	//跳转到已发邮件
	@RequestMapping("/toSendedEmail.do")
	public String toSendedEmail(HttpSession session,Model model,@RequestParam(required=false,defaultValue="1")Integer currPage,
			@RequestParam(required=false,defaultValue="5")Integer pageSize){
		User user = (User) session.getAttribute("sessionUser");
		//List<Mail> list = ser.findSendedById(user.getId()+"");
		PageHelper.startPage(currPage,pageSize);
		List<Mail> list = ser.findSendedByChajian(user.getId());
		PageInfo<Mail> pi = new PageInfo<>(list);
		model.addAttribute("pi",pi);
//		model.addAttribute("sendmail",list);
//		model.addAttribute("allpage",pi.getTotal());
		return "sendedEmail";
	}
}

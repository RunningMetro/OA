package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Rest;
import model.User;
import service.IRestService;
import service.IUserService;

@Controller
@RequestMapping("/rest")
public class RestController {
	@Autowired
	private IRestService ser;
	@Autowired
	private IUserService user;
	//��ҳ
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpSession session,HttpServletRequest request){
		User user = (User) session.getAttribute("sessionUser");
		List<Rest> findAllRest = ser.findAllRest();
		List<Rest> findRest = ser.findRest(user.getId()+"");
		request.setAttribute("allRest", findAllRest);
		request.setAttribute("findRest", findRest);
		return "restIndex";
	}
	//�����ݼ�
	@RequestMapping("/restRequire.do")
	public String restRequire(){
		return "restRequire";
	}
	//�ύ�ݼ�
	@RequestMapping("/wantrest.do")
	public String wantrest(Rest rest){
		ser.saveRest(rest);
		return "redirect:/rest/toIndex.do";
	}
	//���ָ�����ݼ�
	@RequestMapping("/todetailsRest.do")
	public String todetailsRest(String id,HttpServletRequest request) throws Exception{
		Rest rest = ser.findRestById(id);
		request.setAttribute("rest", rest);
		User applyUser = user.findById(rest.getApplyID()+"");
		User approveUser = user.findById(rest.getApproveID()+"");
		request.setAttribute("applyUser", applyUser);
		request.setAttribute("approveUser", approveUser);
		return "detailsRest";
	}
	//���ͨ��
	@RequestMapping("/requiresuccess.do")
	public String requiresuccess(String id){
		ser.passRest(id);
		return "redirect:/rest/toIndex.do";
	}
	//��˾ܾ�
	@RequestMapping("/requirefail.do")
	public String requirefail(String id){
		ser.failedRest(id);
		return "redirect:/rest/toIndex.do";
	}
}

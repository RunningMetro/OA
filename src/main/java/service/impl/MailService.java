package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.MailMapper;
import model.Mail;
import model.Pagination;
import model.User;
import service.IMailService;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
public class MailService implements IMailService{
	@Autowired
	private MailMapper mapper;
	@Override
	public void saveMail(Mail mail) {
		mapper.insertMail(mail);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Mail> selectAll(User user) {
		return mapper.selectAll(user);
	}
	@Override
	@Transactional(readOnly=true)
	public Mail selectById(String mailId) {
		return mapper.selectById(mailId);
	}
	@Override
	public void modifyMail(Mail mail) {
		mapper.updateMail(mail);
	}
	@Override
	public void removeById(String id) {
		mapper.deleteById(id);
	}
	@Override
	public void deleteById(String id) {
		mapper.removeById(id);
	}
	@Override
	public void backEmail(String id) {
		mapper.returnEmail(id);
	}
	@Override
	public List<Mail> findSendedById(String id) {
		return mapper.selectSendedById(id);
	}
	//当前页currentPage;
	//每页显示的个数pageCount; 
	//所有的页数allPage;
	//当前页数量的集合list;
	//所有的个数allCount;
	@Override
	public Pagination findPagination(User user,Integer firstpage, Integer maxpage) {
		Pagination pagination = new Pagination();
		//总个数
		Integer selectAllCount = mapper.selectAllCount(user);
		pagination.setAllCount(selectAllCount);
		//当前页
		pagination.setCurrentPage(firstpage);
		//每页显示的个数
		pagination.setPageCount(maxpage);
		//所有的页数
		Integer allCount = (int) Math.ceil(selectAllCount*1.0/maxpage);
		pagination.setAllPage(allCount);
		//当前页数量的集合list;
		int start=(firstpage-1)*3;
		List<Mail> list = mapper.selectAllList(start, maxpage,user);
		pagination.setList(list);
		System.out.println(pagination);
		return pagination;
	}
	@Override
	public List<Mail> findSendedByChajian(Integer id) {
		return mapper.selectSendedByChajian(id);
	}
	


}

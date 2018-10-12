package service;

import java.util.List;

import model.Mail;
import model.Pagination;
import model.User;

public interface IMailService {
	//添加新邮件	
	public void saveMail(Mail mail);
	//查询所有邮件	
	public List<Mail> selectAll(User user);
	//根据邮件ID获得单个邮件
	public Mail selectById(String mailId);
	//更新邮件
	public void modifyMail(Mail mail);
	//删除邮件(通往垃圾邮箱)
	public void removeById(String id);
	//删除邮件(等于完全删除)
	public void deleteById(String id);
	//还原邮件
	public void backEmail(String id);
	//已发邮件
	public List<Mail> findSendedById(String id);
	//分页
	public Pagination findPagination(User user,Integer firstpage,Integer maxpage);
	//已发邮件的集合(分页插件用)
	public List<Mail> findSendedByChajian(Integer id);
}

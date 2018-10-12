package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.Mail;
import model.User;

public interface MailMapper {
	//添加新邮件
	public void insertMail(Mail mail);
	//获得所有邮件
	public List<Mail> selectAll(User user);
	//根据邮件ID获得单个邮件
	public Mail selectById(String mailId);
	//更新邮件
	public void updateMail(Mail mail);
	//删除邮件(通往垃圾邮箱)
	public void deleteById(String id);
	//删除邮件(相当于完全删除)
	public void removeById(String id);
	//还原邮件
	public void returnEmail(String id);
	//已发邮件
	public List<Mail> selectSendedById(String id);
	//所有的个数allCount(分页用)
	public Integer selectAllCount(User user);
	//所有邮件的集合(分页用)
	public List<Mail> selectAllList(@Param("firstpage")Integer firstpage,@Param("maxpage")Integer maxpage,@Param("user")User user);
	//已发邮件的集合(分页插件用)
	public List<Mail> selectSendedByChajian(Integer id);
}

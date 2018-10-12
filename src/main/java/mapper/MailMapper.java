package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.Mail;
import model.User;

public interface MailMapper {
	//������ʼ�
	public void insertMail(Mail mail);
	//��������ʼ�
	public List<Mail> selectAll(User user);
	//�����ʼ�ID��õ����ʼ�
	public Mail selectById(String mailId);
	//�����ʼ�
	public void updateMail(Mail mail);
	//ɾ���ʼ�(ͨ����������)
	public void deleteById(String id);
	//ɾ���ʼ�(�൱����ȫɾ��)
	public void removeById(String id);
	//��ԭ�ʼ�
	public void returnEmail(String id);
	//�ѷ��ʼ�
	public List<Mail> selectSendedById(String id);
	//���еĸ���allCount(��ҳ��)
	public Integer selectAllCount(User user);
	//�����ʼ��ļ���(��ҳ��)
	public List<Mail> selectAllList(@Param("firstpage")Integer firstpage,@Param("maxpage")Integer maxpage,@Param("user")User user);
	//�ѷ��ʼ��ļ���(��ҳ�����)
	public List<Mail> selectSendedByChajian(Integer id);
}

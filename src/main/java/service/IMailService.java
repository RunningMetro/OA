package service;

import java.util.List;

import model.Mail;
import model.Pagination;
import model.User;

public interface IMailService {
	//������ʼ�	
	public void saveMail(Mail mail);
	//��ѯ�����ʼ�	
	public List<Mail> selectAll(User user);
	//�����ʼ�ID��õ����ʼ�
	public Mail selectById(String mailId);
	//�����ʼ�
	public void modifyMail(Mail mail);
	//ɾ���ʼ�(ͨ����������)
	public void removeById(String id);
	//ɾ���ʼ�(������ȫɾ��)
	public void deleteById(String id);
	//��ԭ�ʼ�
	public void backEmail(String id);
	//�ѷ��ʼ�
	public List<Mail> findSendedById(String id);
	//��ҳ
	public Pagination findPagination(User user,Integer firstpage,Integer maxpage);
	//�ѷ��ʼ��ļ���(��ҳ�����)
	public List<Mail> findSendedByChajian(Integer id);
}

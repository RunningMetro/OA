package service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.User;

public interface IUserService {

	public void save(User user) throws Exception;
	
	public void remove(User user) throws Exception;
	//�޸��û���Ϣ
	public void modify(User user) throws Exception;
	//�޸��˻���Ϣ
	public void modifyAccount(User user) throws Exception;
	//��������û�
	public List<User> findAll() throws Exception;
	//������й���Ա
	public List<User> findAllAdmin() throws Exception;
	
	public User findById(String id) throws Exception;
	
	public User findByUsername(User user) throws Exception;
	//�ж��Ƿ����ͬ������
	public User findByName(String name);
	//��ó��˵�ǰ�û�����������û�
	public List<User> findAllExcept(int id) throws Exception;
	//��ҳ�������
	public List<User> findAllUser();
}

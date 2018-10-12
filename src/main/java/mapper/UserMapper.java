package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.User;

public interface UserMapper {

	public void insert(User user) throws Exception;
	
	public void delete(User user) throws Exception;
	//�޸��û���Ϣ
	public void update(User user) throws Exception;
	//�޸��˻���Ϣ
	public void updateAccount(User user) throws Exception;
	//��������û�
	public List<User> selectAll() throws Exception;
	//�ж��Ƿ����ͬ������
	public User selectByName(String name);
	
	public User selectById(String id) throws Exception;
	//��ѯ�û�
	public User selectByUsername(User user) throws Exception;
	//������еĹ���Ա
	public List<User> selectAllAdmin() throws Exception;
	//��ó��˵�ǰ�û�����������û�
	public List<User> selectAllExcept(int id) throws Exception;
	//��ҳ�������
	@Select("select * from tb_user")
	public List<User> findAllUser();
}

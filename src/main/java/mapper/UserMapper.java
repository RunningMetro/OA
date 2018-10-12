package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.User;

public interface UserMapper {

	public void insert(User user) throws Exception;
	
	public void delete(User user) throws Exception;
	//修改用户信息
	public void update(User user) throws Exception;
	//修改账户信息
	public void updateAccount(User user) throws Exception;
	//获得所有用户
	public List<User> selectAll() throws Exception;
	//判断是否存在同名对象
	public User selectByName(String name);
	
	public User selectById(String id) throws Exception;
	//查询用户
	public User selectByUsername(User user) throws Exception;
	//获得所有的管理员
	public List<User> selectAllAdmin() throws Exception;
	//获得除了当前用户以外的所有用户
	public List<User> selectAllExcept(int id) throws Exception;
	//分页插件测试
	@Select("select * from tb_user")
	public List<User> findAllUser();
}

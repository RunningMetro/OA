package service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.User;

public interface IUserService {

	public void save(User user) throws Exception;
	
	public void remove(User user) throws Exception;
	//修改用户信息
	public void modify(User user) throws Exception;
	//修改账户信息
	public void modifyAccount(User user) throws Exception;
	//获得所有用户
	public List<User> findAll() throws Exception;
	//获得所有管理员
	public List<User> findAllAdmin() throws Exception;
	
	public User findById(String id) throws Exception;
	
	public User findByUsername(User user) throws Exception;
	//判断是否存在同名对象
	public User findByName(String name);
	//获得除了当前用户以外的所有用户
	public List<User> findAllExcept(int id) throws Exception;
	//分页插件测试
	public List<User> findAllUser();
}

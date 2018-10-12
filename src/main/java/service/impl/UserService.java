package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.UserMapper;
import model.User;
import service.IUserService;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public void save(User user) throws Exception {
		mapper.insert(user);
	}

	@Override
	public void remove(User user) throws Exception {
		mapper.delete(user);
	}
	//修改用户信息
	@Override
	public void modify(User user) throws Exception {
		mapper.update(user);
	}
	//修改账户信息
	@Override
	public void modifyAccount(User user) throws Exception {
		mapper.updateAccount(user);
	}
	//获得所有用户
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() throws Exception {
		return mapper.selectAll();
	}
	@Override
	@Transactional(readOnly=true)
	public User findByUsername(User user) throws Exception {
		return mapper.selectByUsername(user);
	}
	@Override
	@Transactional(readOnly=true)
	public User findById(String id) throws Exception {
		return mapper.selectById(id);
	}
	@Override
	@Transactional(readOnly=true)
	public List<User> findAllAdmin() throws Exception {
		return mapper.selectAllAdmin();
	}

	@Override
	public User findByName(String name) {
		return mapper.selectByName(name);
	}

	@Override
	public List<User> findAllExcept(int id) throws Exception {
		return mapper.selectAllExcept(id);
	}
	//分页插件测试
	@Override
	public List<User> findAllUser() {
		return mapper.findAllUser();
	}

}

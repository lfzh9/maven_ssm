package lfzh.service.impl;

import java.util.List;

import lfzh.dao.IUserDao;
import lfzh.exception.SSMException;
import lfzh.model.User;
import lfzh.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.loadByUsername(username);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}

	@Override
	public User loadById(int id) {
		// TODO Auto-generated method stub
		return userDao.loadById(id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public int loadByDeptId(int deptId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User login(User user) throws SSMException{
		// 1 根据用户名查询用户对象
		User oldUser = userDao.loadByUsername(user.getUsername());
//		// 2 如果没有查询到说明用户不存在
//		if (oldUser == null) {
//			throw new SSMException("用户名不存在");
//		}
//		// 3 如果查询到就比较密码
//		if (!oldUser.getPassword().equals(user.getPassword())) {
//			throw new SSMException("密码不正确");
//		}
		return oldUser;
	}

}

package lfzh.dao.impl;

import java.util.List;

import lfzh.dao.IUserDao;
import lfzh.model.User;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends SqlSessionDaoSupport implements IUserDao {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	};

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IUserDao.class).loadByUsername(username);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IUserDao.class).list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IUserDao.class).delete(id);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IUserDao.class).add(user);
	}

	@Override
	public User loadById(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IUserDao.class).loadById(id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IUserDao.class).update(user);
	}

	@Override
	public int loadByDeptId(int deptId) {
		// TODO Auto-generated method stub
		return 0;
	}

}

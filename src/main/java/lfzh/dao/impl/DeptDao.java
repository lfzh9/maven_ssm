package lfzh.dao.impl;

import java.util.List;

import lfzh.dao.IDeptDao;
import lfzh.model.Dept;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao extends SqlSessionDaoSupport implements IDeptDao {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	};


	@Override
	public void add(Dept dept) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IDeptDao.class).add(dept);
	}

	@Override
	public Dept loadByName(String name) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IDeptDao.class).loadByName(name);
	}

	@Override
	public Dept loadById(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IDeptDao.class).loadById(id);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IDeptDao.class).update(dept);
	}


	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return getSqlSession().getMapper(IDeptDao.class).list();
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		getSqlSession().getMapper(IDeptDao.class).delete(id);
	}

}

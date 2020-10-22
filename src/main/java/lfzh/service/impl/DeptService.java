package lfzh.service.impl;

import java.util.List;

import lfzh.dao.IDeptDao;
import lfzh.model.Dept;
import lfzh.service.IDeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeptService implements IDeptService {
	@Autowired
	private IDeptDao deptDao;
	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		deptDao.delete(id);
	}

	@Override
	public void add(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.add(dept);
	}

	@Override
	public Dept loadByName(String name) {
		// TODO Auto-generated method stub
		return deptDao.loadByName(name);
	}

	@Override
	public Dept loadById(int id) {
		// TODO Auto-generated method stub
		return deptDao.loadById(id);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update(dept);;
	}

}

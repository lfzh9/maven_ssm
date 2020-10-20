package lfzh.service.impl;

import java.util.List;

import lfzh.dao.IBranchDao;
import lfzh.model.Branch;
import lfzh.service.IBranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService implements IBranchService {
	@Autowired
	private IBranchDao branchDao;
	
	@Override
	public List<Branch> list() {
		return branchDao.list();
	}
}

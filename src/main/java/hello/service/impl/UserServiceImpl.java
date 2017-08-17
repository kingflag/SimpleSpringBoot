package hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.dao.UserDao;
import hello.domain.User;
import hello.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDao userDao;

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryall() {
		List<User> users = userDao.queryall();
		return users;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String change() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addsome() {
		Boolean result = userDao.addsome();
		return result;
	}

}

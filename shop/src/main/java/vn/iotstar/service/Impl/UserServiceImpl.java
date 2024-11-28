package vn.iotstar.service.Impl;

import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.User;
import vn.iotstar.service.IUserService;

public class UserServiceImpl implements IUserService{

	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package vn.iotstar.services.Impl;

import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.User;

import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService{

	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User login(String slug, String hashed_password) {
		User user = this.findBySlug(slug);
		if (user != null && hashed_password.equals(user.getHashed_password())) {
			return user;
		}
		return null;
	}
	@Override
	public User findBySlug(String slug) {
		
		return userDao.findBySlug(slug);
	}

}

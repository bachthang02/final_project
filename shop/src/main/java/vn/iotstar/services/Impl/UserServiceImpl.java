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
	@Override
	public boolean register(String firstname, String lastname, String email, String phone, String salt,
			String hashed_password) {
		if (userDao.checkExistEmail(email)) {
			return false;
		}
		if (userDao.checkExistPhone(phone)) {
			return false;
		}
		userDao.insertregister(new User(firstname, lastname, email, phone, salt, hashed_password,1));
		return true;
	}
	
	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}
	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}
	@Override
	public void activeEmail(User user) {
		userDao.activeEmail(user);
		
	}
	@Override
	public User findByPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.findByPhone(phone);
	}

}

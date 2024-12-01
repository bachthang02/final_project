package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.User;

public interface IUserDao {

	List<User> findAll();

	User findBySlug(String slug);
	
	User findByPhone(String phone);
	
	

	void insertregister(User user);
	

	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
	
	void activeEmail(User user);
	
	
	
}

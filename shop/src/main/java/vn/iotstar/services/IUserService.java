package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.User;



public interface IUserService {

	List<User> findAll();
	
	User login(String slug, String hashed_password);
	
	User findBySlug(String slug);
	
	
}

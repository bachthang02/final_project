package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.User;


public interface IUserService {

	List<User> findAll();

	User login(String slug, String hashed_password);

	User findBySlug(String slug);

	boolean register(String firstname,String lastname, String email, String phone, String salt, String hashed_password );

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);
}

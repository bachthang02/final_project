package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.User;



public interface IUserDao {

	List<User> findAll();
}

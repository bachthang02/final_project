package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.User;


public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				list.add(new User(rs.getInt("_id"),
						rs.getString("firstname"), 
						rs.getString("slug"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("hashed_password"),
						rs.getInt("roleid")));
		
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;}
	public static void main(String[] args) {
		try {

			UserDaoImpl userDao = new UserDaoImpl();
			System.out.print(userDao.findBySlug("thangvo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User findBySlug(String slug) {
		String sql = "SELECT * FROM users WHERE slug = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, slug);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.set_Id(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setSlug(rs.getString("slug"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.setRoleid(rs.getInt("roleid"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public void insertregister(User user) {
		String sql = "Insert INTO Users (firstname ,lastname, email, phone, salt, hashed_password, roleid) Values(?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getSalt());
			ps.setInt(7, user.getRoleid());
			ps.setString(6, user.getHashed_password());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("User inserted successfully.");
			} else {
				System.out.println("No rows inserted.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "Select * From Users where email =?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String sql = "Select * From Users where phone =?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public void activeEmail(User user) {
		String sql = "UPDATE [Users] SET isEmailActive=? , salt=? WHERE email =?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getIsEmailActive());
			ps.setString(2, user.getSalt());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

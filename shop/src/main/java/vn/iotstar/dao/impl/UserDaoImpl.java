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
						rs.getString("email"),
						rs.getString("phone"),
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
			System.out.print(userDao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

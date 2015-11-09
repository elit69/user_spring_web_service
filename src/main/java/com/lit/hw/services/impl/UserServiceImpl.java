package com.lit.hw.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.lit.hw.entities.User;
import com.lit.hw.services.UserService;

public class UserServiceImpl implements UserService{	
	private DataSource dataSource;

	public UserServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public ArrayList<User> list() {
		String sql = "select * from tbuser order by id;";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			ArrayList<User> listUser = new ArrayList<User>();
			while (rs.next()) {
				User s = new User();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setEmail(rs.getString("email"));
				s.setBirthdate(rs.getDate("birthdate"));
				s.setRegisterdate(rs.getDate("registerdate"));
				s.setImage(rs.getString("image"));
				listUser.add(s);
			}
			return listUser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean add(User usr) {
		String sql = "INSERT INTO tbuser(username,password,email,birthdate,registerdate,image) "
				+ "VALUES (?,?,?,?,?,?);";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, usr.getUsername());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getEmail());
			ps.setDate(4, usr.getBirthdate());
			ps.setDate(5, usr.getRegisterdate());
			ps.setString(6, usr.getImage());
			System.out.println(ps.toString());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(User usr) {
		String sql = "update tbuser set " 	+ "username = ?, "
						+ "password = ?, " 	+ "email= ?, "
						+ "birthdate = ?, " + "registerdate= ?, "
						+ "image= ? " 		+ "where id = ?";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, usr.getUsername());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getEmail());
			ps.setDate(4, usr.getBirthdate());
			ps.setDate(5, usr.getRegisterdate());
			ps.setString(6, usr.getImage());
			ps.setInt(7, usr.getId());
			System.out.println(ps.toString());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int usrId) {
		String sql = "delete from tbuser where id = ?";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, usrId);
			System.out.println(ps.toString());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User show(int stuId) {
		String sql = "select * from tbuser where id = ?";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, stuId);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			if (rs.next()) {
				User s = new User();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setEmail(rs.getString("email"));
				s.setBirthdate(rs.getDate("birthdate"));
				s.setRegisterdate(rs.getDate("registerdate"));
				s.setImage(rs.getString("image"));
				return s;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> search(String keyword, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}

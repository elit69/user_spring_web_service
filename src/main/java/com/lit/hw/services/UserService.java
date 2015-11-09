package com.lit.hw.services;

import java.util.ArrayList;

import com.lit.hw.entities.User;

public interface UserService {
	public ArrayList<User> list();
	public boolean add(User usr);
	public boolean update(User usr);
	public boolean delete(int usrId);
	public User show(int usrId);
	public ArrayList<User> search(String keyword, String type);
}

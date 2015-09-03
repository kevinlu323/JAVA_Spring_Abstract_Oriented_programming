package com.linkui.service;

import com.linkui.dao.UserDAO;
import com.linkui.model.User;

public class UserService {
	//Inverse of Control, this will be loaded by Spring
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void add(User u){
		this.userDAO.save(u);
	}
}

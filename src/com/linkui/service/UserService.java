package com.linkui.service;

import com.linkui.dao.UserDAO;
import com.linkui.dao.impl.UserDAOImpl;
import com.linkui.model.User;

public class UserService {
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

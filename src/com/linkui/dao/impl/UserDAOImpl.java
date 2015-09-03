package com.linkui.dao.impl;

import com.linkui.dao.UserDAO;
import com.linkui.model.User;

public class UserDAOImpl implements UserDAO{
	public void save(User u){
		System.out.println("A user is saved.");
	}
}

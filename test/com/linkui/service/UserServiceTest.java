package com.linkui.service;

import org.junit.Test;

import com.linkui.model.User;
import com.linkui.spring.BeanFactory;
import com.linkui.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		BeanFactory factory = new ClassPathXmlApplicationContext();

		UserService service = (UserService) factory.getBean("userService");
		/*
		 * UserDAO userDAO = (UserDAO) factory.getBean("u");
		 * service.setUserDAO(userDAO);
		 */
		User u = new User();
		service.add(u);
	}

}

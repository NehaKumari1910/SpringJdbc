package com.jda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.dao.IUserDao;
import com.jda.model.UserModel;

public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	public boolean registerUser(UserModel user) {
		if (userDao.registerUser(user) > 0) {
			return true;
		}
		return false;
	}

	public UserModel loginUser(UserModel user) {
		UserModel userModel=userDao.loginUser(user.getEmail());
		if(userModel!=null)
		{
			if(userModel.getPassword().equals(user.getPassword()))
					return userModel	;
			return null;
		}
		return null;
	}

}

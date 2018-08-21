package com.jda.services;

import com.jda.model.UserModel;

public interface IUserService {
	public boolean registerUser(UserModel user);
	public UserModel loginUser(UserModel user);
	public boolean forgotPassword(String email,String url);
	public boolean update(String header,UserModel userModel);

}

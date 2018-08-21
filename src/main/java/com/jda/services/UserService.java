package com.jda.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.jda.dao.IUserDao;
import com.jda.model.UserModel;
import com.jda.utility.MailService;

public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MailService mailService;

	public boolean registerUser(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (userDao.registerUser(user) > 0) {
			return true;
		}
		return false;
	}

	public UserModel loginUser(UserModel user) {
		UserModel userModel=userDao.loginUser(user.getEmail());
		if(userModel!=null)
		{
			if(passwordEncoder.matches(user.getPassword(),userModel.getPassword()))
			{
					return userModel	;
			}
			return null;
		}
		return null;
	}
	public boolean forgotPassword(String email,String url)
	{
		UserModel user=userDao.loginUser(email);
		if(user!=null)
		{
			UUID uuid = UUID.randomUUID();
			String uid=uuid.toString();
			
			if(userDao.saveUUID(email,uid)>0){
				String link = url.substring(0,url.lastIndexOf("/"))+"/resetpasswordform?uuid="+uuid;
				mailService.sendSimpleMessage(link);
				return true;

			}
			return false;
		}
		return false;
			
	}
	public boolean update(String header,UserModel user)
	{
	header=header.substring(header.lastIndexOf("=")+1,header.length());
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	if(userDao.update(user.getPassword(),header)>0)
		return true;
	return false;
		
	}

}

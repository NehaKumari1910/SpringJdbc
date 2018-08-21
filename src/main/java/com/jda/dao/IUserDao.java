package com.jda.dao;

import com.jda.model.UserModel;

public interface IUserDao {
     public int registerUser(UserModel user);
     public UserModel loginUser(String email);
     public int saveUUID(String email,String uuid);
     public int update(String password,String uuid);
}

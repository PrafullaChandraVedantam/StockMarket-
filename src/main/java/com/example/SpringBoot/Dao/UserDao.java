package com.example.SpringBoot.Dao;

import com.example.SpringBoot.Model.User;

public interface UserDao {

	 public boolean registerUser(User user) throws  Exception;
	 public int loginUser(User user)throws Exception;
}

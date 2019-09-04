package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Model.User;

public interface UserController {

	public boolean registerUser(User user) throws Exception;
	public int loginUser(User user)throws Exception;
}

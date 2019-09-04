package com.example.SpringBoot.Service;

import com.example.SpringBoot.Model.User;

public interface UserService {

	public boolean registerUser(User user) throws Exception;
	public int loginUser(User user) throws Exception;
}

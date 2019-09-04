package com.example.SpringBoot.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.UserDao;
import com.example.SpringBoot.Model.User;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public boolean registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.registerUser(user);
	}
	@Override
	public int loginUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.loginUser(user);
	}

}

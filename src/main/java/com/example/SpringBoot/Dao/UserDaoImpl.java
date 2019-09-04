package com.example.SpringBoot.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.Model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Override
	public boolean registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul?useSSL=false",
				"root", "pass@word1");
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into user (username,password,usertype,email,mobile_no,confirmed) values(?,?,?,?,?,?)");
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getUsertype());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setLong(5, user.getMobileNo());
		preparedStatement.setString(6, user.getConfirmed());
		preparedStatement.executeUpdate();

		return true;
	}

	@Override
	public int loginUser(User user) throws Exception {
		String username=user.getUsername();
		String password=user.getPassword();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul?useSSL=false",
				"root", "pass@word1");
		PreparedStatement preparedStatement = connection.prepareStatement(
				"select * from user where username='" + username + "'and password='" + password + "'");
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next() == false)

			return 0;
		else

			return 1;

	}


}

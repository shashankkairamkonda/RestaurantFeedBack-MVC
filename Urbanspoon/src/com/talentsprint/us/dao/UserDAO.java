package com.talentsprint.us.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.User;

public class UserDAO {

	public int insert(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection
					.prepareStatement("insert into user (first_name,last_name,password,email_id,phone_number) values(?,?,?,?,?)");

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getEmailId());
			preparedStatement.setLong(5, user.getPhoneNumber());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public User getuser(String email) {
		User user = new User();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from user where email_id=?");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setUser_id(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setEmailId(resultSet.getString(4));
				user.setPhoneNumber(resultSet.getLong(5));
				user.setPassword(resultSet.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {

					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}
}

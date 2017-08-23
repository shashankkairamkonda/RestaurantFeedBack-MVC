package com.talentsprint.us.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Cuisine;

public class CuisineDAO {

	public List<Cuisine> getCuisine() {
		List<Cuisine> arrayList1 = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from cuisine");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cuisine cuisine = new Cuisine();
				cuisine.setCuisineId(resultSet.getInt(1));
				cuisine.setDescription(resultSet.getString(4));
				cuisine.setName(resultSet.getString(2));
				cuisine.setCountry(resultSet.getString(3));
				
				arrayList1.add(cuisine);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList1;

	}
	
	public int insert(Cuisine cuisine) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("insert into cuisine (name,country,description) values (?,?,?) ");
			preparedStatement.setString(1, cuisine.getName());
			preparedStatement.setString(2, cuisine.getCountry());
			preparedStatement.setString(3, cuisine.getDescription());
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	

}

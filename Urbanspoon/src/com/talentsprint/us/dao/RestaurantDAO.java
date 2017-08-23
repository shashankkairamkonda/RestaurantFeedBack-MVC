package com.talentsprint.us.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Recipe;
import com.talentsprint.us.model.Restaurant;

public class RestaurantDAO {
	public int insert(Restaurant restaurant) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement(
					"insert into restaurant (registration_name,password,registration_id) values(?,?,?)");

			preparedStatement.setString(1, restaurant.getRegistrationName());
			preparedStatement.setString(2, restaurant.getPassword());
			preparedStatement.setString(3, restaurant.getRegistartionId());
			
			
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
	
	public Restaurant getRestaurantName(int x) {
		Restaurant restaurant = new Restaurant();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement(" select * from restaurant where restaurant_id "
					+ "=(select restaurant_id from branch where branch_id=(select branch_id from serve where recipe_id=?))");
			preparedStatement.setInt(1, x);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				restaurant.setRegistartionId(resultSet.getString(4));
				restaurant.setRegistrationName(resultSet.getString(2));
				
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
		return restaurant;

	}
	public List<Restaurant> getRestaurant() {
		List<Restaurant> arrayList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from restaurant");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantId(resultSet.getInt(1));
				restaurant.setRegistrationName(resultSet.getString(2));
				
				arrayList.add(restaurant);
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
		return arrayList;

	}

	
	
	public List<Restaurant> getRestaurantname(String city) {
		List<Restaurant> arrayList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select registration_name, restaurant_id from restaurant where restaurant_id in "
					+ "(select restaurant_id from branch where city=?) ");
			preparedStatement.setString(1, city);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRegistrationName(resultSet.getString(1));
				restaurant.setRestaurantId(resultSet.getInt(2));
				
				arrayList.add(restaurant);
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
		return arrayList;

	}

	
	

	public Restaurant getRestaurant(String userName) {
		Restaurant restaurant = new Restaurant();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from restaurant where registration_name=?");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				restaurant.setRestaurantId(resultSet.getInt(1));	
				restaurant.setRegistrationName(resultSet.getString(2));
				restaurant.setPassword(resultSet.getString(3));
				restaurant.setRegistartionId(resultSet.getString(4));
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

		return restaurant;
	}


	public int getRestaurantId(String userName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Restaurant restaurant = new Restaurant();
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from restaurant where registration_name=?");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
	
			int x =resultSet.getInt(1);
			return x;
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

		return 0;

	}




	public Restaurant checkRestaurant(String email) {
		Restaurant restaurant = new Restaurant();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from user where email_id=?");
			preparedStatement.setString(1, email );
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				restaurant.setRegistrationName(resultSet.getString(2));
				restaurant.setPassword(resultSet.getString(3));
				restaurant.setRegistartionId(resultSet.getString(4));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}

		return restaurant;
	}

	public static int updateRestaurant(int restaurantid , String password, String registartionId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("update restaurant set password=? , registration_id=? where restaurant_id=?");
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, registartionId);
			preparedStatement.setInt(3, restaurantid);
			return preparedStatement.executeUpdate();
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}
}
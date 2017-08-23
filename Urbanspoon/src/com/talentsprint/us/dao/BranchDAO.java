package com.talentsprint.us.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Branch;

public class BranchDAO {

	public int insert(Branch branch) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement(
					"insert into branch (location,city,state,postal_code,country,email_id,phone_number,restaurant_id,image_path) values(?,?,?,?,?,?,?,?,?)");

			System.out.println(branch.toString());
			preparedStatement.setString(1, branch.getLocation());
			preparedStatement.setString(2, branch.getCity());
			preparedStatement.setString(3, branch.getState());
			preparedStatement.setString(4, branch.getPostalCode());
			preparedStatement.setString(5, branch.getCountry());
			preparedStatement.setString(6, branch.getEmailId());
			preparedStatement.setLong(7, branch.getPhoneNumber());
			preparedStatement.setInt(8,branch.getRestaurntId());
			preparedStatement.setString(9, branch.getImagePath());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public  List<Branch> getBid(int y) {
		List<Branch> arrylist = new ArrayList<>(); 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from branch where restaurant_id=(select restaurant_id from restaurant where restaurant_id=?)");
			preparedStatement.setInt(1, y);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Branch branch = new Branch();
				branch.setBranchId(resultSet.getInt(1));
				branch.setLocation(resultSet.getString(2));
				arrylist.add(branch);
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
		return arrylist;

	}

	public Branch getBranchName(int parseInt) {
		Branch branch = new Branch();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from branch where branch_id =(select branch_id from serve where recipe_id=?)");
			preparedStatement.setInt(1, parseInt);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				branch.setLocation(resultSet.getString(2));
				branch.setCity(resultSet.getString(3));
				branch.setState(resultSet.getString(4));
				branch.setCountry(resultSet.getString(6));
				branch.setEmailId(resultSet.getString(7));
				branch.setPhoneNumber(resultSet.getInt(8));

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
		return branch;

	}

	public List<Branch> getBranchs(int parseInt) {
		List<Branch> arrylist = new ArrayList<>(); 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from branch where restaurant_id=?");
			preparedStatement.setInt(1, parseInt);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Branch branch = new Branch();
				branch.setBranchId(resultSet.getInt(1));
				branch.setLocation(resultSet.getString(2));
				branch.setCity(resultSet.getString(3));
				branch.setState(resultSet.getString(4));
				branch.setPostalCode(resultSet.getString(5));
				branch.setCountry(resultSet.getString(6));
				branch.setEmailId(resultSet.getString(7));
				branch.setPhoneNumber(resultSet.getLong(8));
				branch.setImagePath(resultSet.getString(10));
				arrylist.add(branch);
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
		return arrylist;

	}



	public static int deleteBranch(int parseInt) {
		Connection connnection = null;
		PreparedStatement preparestatement =null;
		try {
			connnection = DAOUtility.getConncetion();
			preparestatement = connnection.prepareStatement("delete from branch where branch_id=?");
			preparestatement.setInt(1, parseInt);
			return preparestatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}	
}



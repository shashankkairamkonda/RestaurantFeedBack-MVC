package com.talentsprint.us.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Serve;

public class ServeDAO {
	public Serve getBranchID(int recipeid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Serve serve = new Serve();
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection
					.prepareStatement("select * from serve where recipe_id=?");

			preparedStatement.setInt(1, recipeid);
			resultset= preparedStatement.executeQuery();
			if(resultset.next()){
			serve.setBranchId(resultset.getInt(2));
			}

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
		return serve;
	}
	
	

	public int insert(Serve serve) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection
					.prepareStatement("insert into serve (price,branch_id,recipe_id) values(?,?,?)");

			System.out.println("serv.recid"+serve.getRecipeId());
			System.out.println("serv.branchid"+serve.getBranchId());
			preparedStatement.setDouble(1, serve.getPrice());
			preparedStatement.setInt(2, serve.getBranchId());
			preparedStatement.setInt(3, serve.getRecipeId());
			
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
}

package com.talentsprint.us.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Recipe;

public class RecipeDAO {
	
	
	
	public int save(Recipe recipe) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DAOUtility.getConncetion();
		try {
			

			preparedStatement = connection.prepareStatement(
					"insert into recipe(name,cuisine_id,description,image_path,is_veg) values (?,?,?,?,?)");

			preparedStatement.setString(1, recipe.getName());
			preparedStatement.setInt(2, recipe.getCuisineId());
			preparedStatement.setString(3, recipe.getDescription());
			preparedStatement.setString(4, recipe.getImagePath());
			if(recipe.getIsVeg()){
				preparedStatement.setString(5, "0");	
				
			}else {
				preparedStatement.setString(5, "1");
			}
			
			
			
			System.out.println(recipe.toString());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		}
		return 0;

		
		
	}

	public List<Recipe> getRecipes() {
		List<Recipe> arrayList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from recipe");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeId(resultSet.getInt(1));
				recipe.setName(resultSet.getString(2));
				recipe.setCuisineId(resultSet.getInt(3));
				recipe.setDescription(resultSet.getString(4));
				recipe.setImagePath(resultSet.getString(5));
				recipe.setHome(false);
				if(resultSet.getInt(6) == 0){
					recipe.setVeg(true);
				}else{
					recipe.setVeg(false);
				}
				arrayList.add(recipe);
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
	

	public List<Recipe> getRecipesbyname(String name) {
		List<Recipe> arrayList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from recipe  where name=?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeId(resultSet.getInt(1));
				recipe.setName(resultSet.getString(2));
				recipe.setCuisineId(resultSet.getInt(3));
				recipe.setDescription(resultSet.getString(4));
				recipe.setImagePath(resultSet.getString(5));
				recipe.setHome(false);
				if(resultSet.getInt(6) == 0){
					recipe.setVeg(true);
				}else{
					recipe.setVeg(false);
				}
				arrayList.add(recipe);
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
	

	
	public List<Recipe> getRecipesbycity(String city) {
		List<Recipe> arrayList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from recipe where recipe_id in"
					+ "(select recipe_id from serve where branch_id in"
					+ "(select branch_id from branch where city=?))");
			preparedStatement.setString(1, city);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeId(resultSet.getInt(1));
				recipe.setName(resultSet.getString(2));
				recipe.setCuisineId(resultSet.getInt(3));
				recipe.setDescription(resultSet.getString(4));
				recipe.setImagePath(resultSet.getString(5));
				recipe.setHome(false);
				if(resultSet.getInt(6) == 0){
					recipe.setVeg(true);
				}else{
					recipe.setVeg(false);
				}
				arrayList.add(recipe);
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
	

	
	
	
	public Recipe getRid(String name) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Recipe rec = new Recipe();
		try {
			connection = DAOUtility.getConncetion();
			preparedStatement = connection.prepareStatement("select * from recipe where name = ?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				rec.setRecipeId(resultSet.getInt(1));
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
		return rec;

	}
	
	
	
	public int delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DAOUtility.getConncetion();
		try {
			preparedStatement = connection.prepareStatement("delete from recipe where id=? ");

			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
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
		}
		return 0;
	}

	public List<Recipe> getrecipelist(int parseInt) {
		Connection connection = null;
		ResultSet resultset = null;
		PreparedStatement preparedstatment = null;
		List<Recipe> recipelist = new ArrayList<>();
		try {
			connection = DAOUtility.getConncetion();
			preparedstatment = connection.prepareStatement("select * from recipe where recipe_id in (select recipe_id from serve where branch_id=?)");
			preparedstatment.setInt(1, parseInt);
			resultset = preparedstatment.executeQuery();
			while (resultset.next()) {
				Recipe recipe = new  Recipe();
				recipe.setRecipeId(resultset.getInt(1));
				recipe.setName(resultset.getString(2));
				recipe.setDescription(resultset.getString(4));
				recipe.setImagePath(resultset.getString(5));
				if(resultset.getInt(6) == 1) {
					recipe.setVeg(true);
				}else {
					recipe.setVeg(false);
				}
				recipelist.add(recipe);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return recipelist;
	}

	
}

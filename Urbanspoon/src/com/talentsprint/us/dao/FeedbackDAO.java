package com.talentsprint.us.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Feedback;

public class FeedbackDAO {
	public static int saveRatings(Feedback feedback) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DAOUtility.getConncetion();

		try {
			preparedStatement = connection.prepareStatement(
					"insert into feedback_recipe (comments,feedback_date,branch_id,recipe_id,user_id,rating) values(?,?,?,?,?,?);");
			preparedStatement.setString(1, feedback.getComments());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date dob = null;
			dob = sdf.parse(feedback.getFeedbackDate());
			java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
			
			
			
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setInt(3, feedback.getBranchId());
			preparedStatement.setInt(4, feedback.getRecipeId());
			preparedStatement.setInt(5, feedback.getUserId());
			preparedStatement.setInt(6, feedback.getRating());

			return preparedStatement.executeUpdate();

		} catch (SQLException | ParseException e) {
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

	public static int delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DAOUtility.getConncetion();
		try {
			preparedStatement = connection.prepareStatement("delete from  rating  where id=? ");

			preparedStatement.setInt(1, id);

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

	public List<Feedback> getFeedBack(int parseInt) {
		List<Feedback> feedbacklist = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			
			
			connection = DAOUtility.getConncetion();
			preparedstatement = connection.prepareStatement("select * from feedback_recipe where recipe_id=?");
			preparedstatement.setInt(1, parseInt);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Feedback feedback = new Feedback();
				feedback.setComments(resultset.getString(2));
				/*Date date = resultset.getDate(5);
				DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				feedback.setFeedbackDate(df.format(date));*/
				feedback.setRating(resultset.getInt(7));
				feedbacklist.add(feedback);
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (resultset != null) {
				resultset.close();
			}
			if (preparedstatement != null)
				preparedstatement.close();
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return feedbacklist;

	
	
}
}
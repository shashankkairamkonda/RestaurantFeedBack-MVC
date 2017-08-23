package com.talentsprint.us.model;

import java.util.Date;

public class Feedback {
	private int feedbackId;
	private String comments;
	private String feedbackDate;
	private int branchId;
	private int recipeId;
	private int userId;
	private int rating;
	

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", comments=" + comments
				+ ", feedbackDate=" + feedbackDate + ", branchId=" + branchId
				+ ", recipeId=" + recipeId + ", userId=" + userId + ", rating="
				+ rating + "]";
	}

	

}

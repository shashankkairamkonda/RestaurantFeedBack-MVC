package com.talentsprint.us.model;

import java.util.List;

public class Recipe {

	private int recipeId;
	private String name;
	private String description;
	private int cuisineId;
	private boolean isVeg;
	public boolean home;
	private String imagePath;
	private List<Feedback> feedbackList = null;

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public boolean getIsVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", name=" + name
				+ ", description=" + description + ", cuisineId=" + cuisineId
				+ ", isVeg=" + isVeg + ", imagePath=" + imagePath
				+ ", feedbackList=" + feedbackList + "]";
	}

}

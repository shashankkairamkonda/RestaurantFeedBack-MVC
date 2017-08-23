package com.talentsprint.us.model;

public class Serve {

	private double price;
	private int userId;
	private int recipeId;
	private int branchId;
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	@Override
	public String toString() {
		return "Serve [price=" + price + ", branchId=" + branchId + ", userId="
				+ userId + ", recipeId=" + recipeId + "]";
	}

	
}

package com.talentsprint.us.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.talentsprint.us.dao.BranchDAO;
import com.talentsprint.us.dao.CuisineDAO;
import com.talentsprint.us.dao.RecipeDAO;
import com.talentsprint.us.dao.RestaurantDAO;
import com.talentsprint.us.dao.ServeDAO;
import com.talentsprint.us.model.Branch;
import com.talentsprint.us.model.Cuisine;
import com.talentsprint.us.model.Recipe;
import com.talentsprint.us.model.Restaurant;
import com.talentsprint.us.model.Serve;

/**
 * Servlet implementation class RestaurantController
 */
@WebServlet("/RestaurantController")
public class RestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("getCuisine")) {

			List<Cuisine> cuisineList = new CuisineDAO().getCuisine();

			HttpSession httpsess = request.getSession();
			List<Branch> branch =  new BranchDAO().getBid((int) httpsess.getAttribute("loggedUser"));
			request.setAttribute("branchlist", branch);
			request.setAttribute("cuisineList", cuisineList);
			request.getRequestDispatcher("addRecipe.jsp").forward(request, response);
		}
		else if (action.equals("getCuisineName")) {

			List<Cuisine> cuisineList = new CuisineDAO().getCuisine();

			request.setAttribute("cuisineList", cuisineList);
			request.getRequestDispatcher("addCuisine.jsp").forward(request, response);
		} else if (action.equals("viewBranchs")) {
			List<Branch> arraylistbranch = new BranchDAO().getBranchs(Integer.parseInt(request.getParameter("restaurantid")));
			request.setAttribute("branchlist", arraylistbranch);
			request.getRequestDispatcher("viewBranches.jsp").forward(request, response);
		}else if (action.equals("deleteBranch")) {
			if(BranchDAO.deleteBranch(Integer.parseInt(request.getParameter("branchid"))) != 0)
			{
				request.setAttribute("msg", "Branch deleted succesfully");
				request.getRequestDispatcher("restaurantHome.jsp").forward(request, response);
			}
		}else if (action.equals("recipelist")) {
			List<Recipe> arrarylist = new RecipeDAO().getrecipelist(Integer.parseInt(request.getParameter("branchid")));
			request.setAttribute("recipelist", arrarylist);
			request.getRequestDispatcher("viewRecipe.jsp").forward(request, response);
			
		}
		


	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			DiskFileItemFactory dis = new DiskFileItemFactory();
			ServletFileUpload sfd = new ServletFileUpload(dis);

			try {
				List<FileItem> list = sfd.parseRequest(request);
				Recipe recipe = new Recipe();
				Serve serve = new Serve();
				Branch branch = new Branch();
				int count = 0;
				int recipe1 = 0;
				int serve1 = 0;
				for (FileItem fileItem : list) {
					if (fileItem.getFieldName().equals("action")
							&& fileItem.getString().equals("addrecipe")) {

						count = 1;
					} else if ((fileItem.getFieldName().equals("action") && fileItem
							.getString().equals("addbranch"))) {
						count = 2;

					}
					if (count == 1) {
						//System.out.println("ADdrecipe");

						if (!fileItem.isFormField()) {
							String imagePath = "E:\\mysql\\workspace\\"
									+ getServletContext().getContextPath()
									+ "\\WebContent\\images\\recipes"
									+ fileItem.getName();
							fileItem.write(new File(imagePath));
							recipe.setImagePath(fileItem.getName());
						} else {

							if (fileItem.getFieldName().equals("name")) {
								recipe.setName((fileItem.getString()).toLowerCase());
							} else if (fileItem.getFieldName().equals(
									"description")) {
								recipe.setDescription((fileItem.getString()));
							} else if (fileItem.getFieldName().equals(
									"cuisineid")) {
								recipe.setCuisineId(Integer.parseInt((fileItem
										.getString())));
							} else if (fileItem.getFieldName().equals("isveg")) {
								recipe.setVeg(Boolean.valueOf(((fileItem.getString()))));
							}

							else if (fileItem.getFieldName().equals("price")) {
								serve.setPrice(Integer.parseInt(fileItem
										.getString()));
							}else if (fileItem.getFieldName().equals("branchid")) {
								branch.setBranchId(Integer.parseInt(fileItem.getString()));
							}

						}

					}if (count == 2) {

						if (!fileItem.isFormField()) {
							String imagePath = "E:\\mysql\\workspace\\"
									+ getServletContext().getContextPath()
									+ "\\WebContent\\images\\branches"
									+ fileItem.getName();
							fileItem.write(new File(imagePath));
							branch.setImagePath(fileItem.getName());
						} else {

							if (fileItem.getFieldName().equals("location")) {
								branch.setLocation(fileItem.getString());
							} else if (fileItem.getFieldName().equals("city")) {
								branch.setCity(fileItem.getString());
							} else if (fileItem.getFieldName().equals("state")) {
								branch.setState((fileItem.getString()));
							} else if (fileItem.getFieldName().equals("postalCode")) {
								branch.setPostalCode((fileItem.getString()));
							} else if (fileItem.getFieldName().equals("country")) {
								branch.setCountry((fileItem.getString()));
							} else if (fileItem.getFieldName().equals("EmailId")) {
								branch.setEmailId((fileItem.getString()));
							} else if (fileItem.getFieldName().equals("phonenumber")) {
								branch.setPhoneNumber((Long.parseLong(fileItem.getString())));
							}else if (fileItem.getFieldName().equals("branchid")) {
								branch.setBranchId(Integer.parseInt(fileItem.getString()));
							}

						}

					}



				}
				if (count == 1) {



					recipe1 = new RecipeDAO().save(recipe);


					serve.setBranchId(branch.getBranchId());

					Recipe rec = new RecipeDAO().getRid(recipe.getName());
					serve.setRecipeId(rec.getRecipeId());

					serve1 = new ServeDAO().insert(serve);



					if (recipe1 != 0 && serve1 != 0) {
						request.setAttribute("msg", "Recipe added successfully");
						request.getRequestDispatcher("restaurantHome.jsp").forward(request, response);


					}

				}
				if (count == 2) {
					HttpSession httpSession = request.getSession();
					branch.setRestaurntId(((int) httpSession.getAttribute("loggedUser")));

					int status = new BranchDAO().insert(branch);
					if (status > 0) {
						request.setAttribute("msg", "Branch added successfully");
						request.getRequestDispatcher("restaurantHome.jsp").forward(request, response);
					} else {
						response.sendRedirect("restaurantHome.jsp");

					}


				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else {
			String action = request.getParameter("action");
			if (action.equals("cuisine")) {
				String name = request.getParameter("name");
				String country = request.getParameter("country");
				String description = request.getParameter("description");
				int cuisinestatus = 0;
				Cuisine cuisine = new Cuisine();
				cuisine.setName(name);
				cuisine.setCountry(country);
				cuisine.setDescription(description);

				cuisinestatus = new CuisineDAO().insert(cuisine);
				if (cuisinestatus != 0) {
					response.sendRedirect("restaurantHome.jsp");
				}
			} else if (action.equals("updateprofile")) {
				String password = request.getParameter("password");
				String registartionId = request.getParameter("registartionId");

				if( RestaurantDAO.updateRestaurant(Integer.parseInt(request.getParameter("restaurantid")) ,password , registartionId) !=0 ) {
					request.setAttribute("msg", "Your details updated successfully");
					response.sendRedirect("restaurantHome.jsp");
				}


			} else if(action.equals("search")) {
				List<Restaurant> arraylist = new RestaurantDAO().getRestaurantname(request.getParameter("city"));
				List<Recipe> recipesList1 = new RecipeDAO().getRecipesbycity(request.getParameter("city"));
				for (Restaurant restaurant : arraylist) {
					if((request.getParameter("search").toLowerCase()).equals(restaurant.getRegistrationName())) 
					{
						List<Branch> arraylistbranch = new BranchDAO().getBranchs(restaurant.getRestaurantId());
						request.setAttribute("branchlist", arraylistbranch);
						request.getRequestDispatcher("viewBranches.jsp").forward(request, response);
					}else {
						for (Recipe recipe : recipesList1) {
							if((request.getParameter("search").toLowerCase()).equals(recipe.getName())) {
								System.out.println("meatsss"+recipe.getName());
								
								List<Recipe> recipesList = new RecipeDAO().getRecipesbyname(recipe.getName());
								System.out.println(recipesList);
								request.setAttribute("recipesList", recipesList);
								request.getRequestDispatcher("restaurantfood.jsp").forward(request, response);
							}
						}		
					}
				}
				
			}

		}

	}
}
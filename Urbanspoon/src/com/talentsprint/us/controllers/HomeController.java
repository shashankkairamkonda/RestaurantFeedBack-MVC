package com.talentsprint.us.controllers;

import java.io.File;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.talentsprint.us.dao.BranchDAO;
import com.talentsprint.us.dao.FeedbackDAO;
import com.talentsprint.us.dao.RecipeDAO;
import com.talentsprint.us.dao.RestaurantDAO;
import com.talentsprint.us.dao.ServeDAO;
import com.talentsprint.us.dao.UserDAO;
import com.talentsprint.us.model.Branch;
import com.talentsprint.us.model.Feedback;
import com.talentsprint.us.model.Recipe;
import com.talentsprint.us.model.Restaurant;
import com.talentsprint.us.model.Serve;
import com.talentsprint.us.model.User;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (null == action) {

			response.sendRedirect("home.jsp");


		} else if (action.equals("restauranthome")) {
			List<Restaurant> restaurantlist = new RestaurantDAO().getRestaurant();
			request.setAttribute("restaurantlist", restaurantlist);
			request.getRequestDispatcher("restaurantuser.jsp").forward(request, response);

		}else if(action.equals("restaurantfood")){
			List<Recipe> recipesList = new RecipeDAO().getRecipes();
			request.setAttribute("recipesList", recipesList);
			request.getRequestDispatcher("restaurantfood.jsp").forward(request, response);
		}

		else if(action.equals("sendrid")){
			Branch branch = new BranchDAO().getBranchName(Integer.parseInt((request.getParameter("value"))));
			Restaurant restaurant = new RestaurantDAO().getRestaurantName(Integer.parseInt((request.getParameter("value"))));
			request.setAttribute("branch", branch);
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("recipeid", request.getParameter("value"));
			request.getRequestDispatcher("feedback.jsp").forward(request, response);
		}else if(action.equals("viewfeedback")){
			List<Feedback> feedbacklist = new FeedbackDAO().getFeedBack(Integer.parseInt(request.getParameter("recipeid")));
			request.setAttribute("feedbacklist", feedbacklist);
			request.getRequestDispatcher("viewfeedbacks.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			DiskFileItemFactory dis = new DiskFileItemFactory();
			ServletFileUpload sfd = new ServletFileUpload(dis);

			try {
				List<FileItem> list = sfd.parseRequest(request);
				Restaurant restaurant = new Restaurant();
				Branch branch = new Branch();

				String repassword = "";
				String password = "";
				int restaurantId = 0;
				for (FileItem fileItem : list) {
					if (!fileItem.isFormField()) {
						String imagePath = "E:\\mysql\\workspace\\"
								+ getServletContext().getContextPath()
								+ "\\WebContent\\images\\branches"
								+ fileItem.getName();
						fileItem.write(new File(imagePath));
						branch.setImagePath(fileItem.getName());
					} else {
						if (fileItem.getFieldName().equals("name")) {
							restaurant.setRegistrationName((fileItem.getString()).toLowerCase());

						} else if (fileItem.getFieldName().equals("password")) {
							restaurant.setPassword(fileItem.getString());
							password = fileItem.getString();
						} else if (fileItem.getFieldName().equals("registrationId")) {
							restaurant.setRegistartionId((fileItem.getString()));


						} else if (fileItem.getFieldName().equals("location")) {
							branch.setLocation((fileItem.getString()));
						} else if (fileItem.getFieldName().equals("city")) {
							branch.setCity((fileItem.getString()));
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
						}else if (fileItem.getFieldName().equals("repassword")) {
							repassword = (fileItem.getString());
						}

					}

				}

				if(password.equals(repassword)) {

					RestaurantDAO restaurantDAO = new RestaurantDAO();
					restaurantId = restaurantDAO.insert(restaurant);
					if(restaurantId != 0){
						restaurantId = restaurantDAO.getRestaurantId(restaurant.getRegistrationName());
						branch.setRestaurntId(restaurantId);
						int status = new BranchDAO().insert(branch);
						if (status > 0) {
							request.setAttribute("userName", restaurant.getRegistrationName());
							request.getRequestDispatcher("login.jsp").forward(request, response);
						} else {
							response.sendRedirect("registration.jsp");
						}
					}else{
					}
				}
				else {
					request.setAttribute("error", "Dude please enter same password");
					request.getRequestDispatcher("register,jsp").forward(request, response);
				}
			}
			catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String action = request.getParameter("action");
			if (action.equals("user_registration")) {
				String firstName = request.getParameter("FirstName");
				String lastName = request.getParameter("LastName");
				String email = request.getParameter("EmailId");
				String password = request.getParameter("password");
				long phoneNumber = Long.parseLong(request.getParameter("phonenumber"));

				User user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmailId(email);
				user.setPassword(password);
				user.setPhoneNumber(phoneNumber);
				UserDAO userDAO = new UserDAO();
				if (userDAO.insert(user) > 0) {
					request.setAttribute("userName", email);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {

				}

			}else if (action.equals("restaurant_registration")) {





			}


			else if (action.equals("login")) {

				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				String loginAs = request.getParameter("loginAs");

				if(userName != null && password != null && loginAs != null)
				{
					if (loginAs.equals("userLogin")) {


						User user = new UserDAO().getuser(userName);
						if (user.getPassword()!=null && user.getPassword().equals(password)) {
							List<Recipe> recipesList = new RecipeDAO().getRecipes();
							request.setAttribute("recipesList", recipesList);

							HttpSession httpSession = request.getSession();



							httpSession.setAttribute("loggedUser", user.getUser_id());

							request.getRequestDispatcher("home.jsp").forward(request, response);
						}
						else {
							request.setAttribute("error", "Dude check your values");
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
					} 
					else if (loginAs.equals("restaurantLogin")) {


						Restaurant restaurant = new RestaurantDAO().getRestaurant(userName);


						if (restaurant.getPassword()!= null && restaurant.getPassword().equals(password)) {

							HttpSession httpSession = request.getSession();
							httpSession.setAttribute("restaurant", restaurant);
							httpSession.setAttribute("RloggedUser", restaurant.getRestaurantId());
							httpSession.setAttribute("loggedUser", restaurant.getRestaurantId());
							httpSession.setAttribute("Rid", restaurant.getRegistartionId());
							request.getRequestDispatcher("restaurantHome.jsp").forward(request, response);


						} else {
							request.setAttribute("error", "Dude check your values");
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
					}
				}else{
					request.setAttribute("error", "Dude check your values");
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}
			}else if(action.equals("feedback")){
				String comments = request.getParameter("comments");
				String date = request.getParameter("date");
				int rating = Integer.parseInt(request.getParameter("rateing"));

				HttpSession httpsession = request.getSession();
				int userid =(int)httpsession.getAttribute("loggedUser");
				int recipeid = Integer.parseInt(request.getParameter("recipeid"));
				Serve serve = new ServeDAO().getBranchID((recipeid));
				int branchid = (serve.getBranchId()); 

				Feedback feedback = new Feedback();
				feedback.setBranchId(branchid);
				feedback.setComments(comments);
				feedback.setFeedbackDate(date);
				feedback.setRating(rating);
				feedback.setRecipeId(recipeid);
				feedback.setUserId(userid);
				int status = FeedbackDAO.saveRatings(feedback);
				if(status != 0){
					response.sendRedirect("home.jsp");
				}else{
					response.sendRedirect("notthere");
				}
			}else if (action.equals("userReset")) {
/*				System.out.println("userreset");
				String email= request.getParameter("EmailId");
				User user = new UserDAO().getuser(email);
				try{
					if(user != null ) {

						System.out.println("Resetset Holds");
						PasswordMail mail = new PasswordMail();
						System.out.println("Password is"+user.getPassword());
						boolean status=mail.Sendmail(email, user.getPassword());
						if(status) {
							request.setAttribute("error", "we shared your password through mail");
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
					}
				}
				catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
			else if (action.equals("restaurantReset")) {
				String restaurantname = request.getParameter("name");

			}


		}


	}

}

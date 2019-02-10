package com.saaspass.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saaspass.Validator.Check;
import com.saaspass.TokenGeneration.AppToken;
import com.saaspass.cons.Constants;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
         
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String otp= request.getParameter("password");

		try {
			String url = String.format("%s/applications/%s/otpchecks?username=%s&otp=%s&token=%s",
                                                    Constants.API_URL, Constants.APP_KEY, 
                                                    username, otp, AppToken.getAppToken());
			if (Check.isValid(url) == 1) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("/list-todos.do");
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}
	} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
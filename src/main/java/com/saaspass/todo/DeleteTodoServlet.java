package com.saaspass.todo;

import com.saaspass.TokenGeneration.ComToken;
import com.saaspass.Validator.Check;
import com.saaspass.cons.Constants;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {

	private TodoService todoService = new TodoService();
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("todo");
		try {
			String url = String.format("%s/%s/removeaccount?username=%s&token=%s", 
                                                    Constants.API_URL, Constants.COM_KEY,
                                                    username, ComToken.getComToken());
			if(Check.isValid(url) == 1){
				todoService.deleteTodo(new Todo(request.getParameter("todo"), request
						.getParameter("category")));
				response.sendRedirect("/list-todos.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
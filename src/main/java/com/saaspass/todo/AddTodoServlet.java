package com.saaspass.todo;

import com.saaspass.TokenGeneration.ComToken;
import com.saaspass.Validator.Check;
import com.saaspass.cons.Constants;
import com.saaspass.logout.LogoutServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	private TodoService todoService = new TodoService();
	private LogoutServlet out = new LogoutServlet();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		String comKey = "1idjmdwqrey89ecpkw";
		String groupID = null;
		try {
			String url = String.format("%s/%s/addaccount?username=%s&accountowner=%s&grouplist=%s&token=%s",
                                Constants.API_URL, Constants.COM_KEY, newTodo, category, groupID, ComToken.getComToken());
			if(Check.isValid(url) == 1){
			    todoService.addTodo((new Todo(newTodo,category)));
			    response.sendRedirect("/list-todos.do");
			}
			else{
				request.setAttribute("errorMessage", "Invalid Credentials!");
				request.getRequestDispatcher("/WEB-INF/views/list-todos.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
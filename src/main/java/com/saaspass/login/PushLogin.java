
package com.saaspass.login;

import static com.saaspass.TokenGeneration.AppToken.getAppToken;
import com.saaspass.Validator.Check;
import com.saaspass.cons.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author borai
 */
@WebServlet("/push.do")
public class PushLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
	String sessionID= request.getParameter("sessionID");
            

	String spUrl = "%s/applications/%s/push?username=%s&session=%s&token=%s";
		
	try {
		String APP_TOKEN = getAppToken();
		String url = String.format(spUrl,
					  Constants.API_URL,
					  Constants.APP_KEY,
					  user,
					  sessionID,
					  APP_TOKEN);
                Integer is = Check.isValid(url);
                
		if(Check.isValid(url) == 1){
			response.sendRedirect("/list-todos.do");
                        System.out.println("LoginSuccess should redirect!");

		}else{
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		PrintWriter out= response.getWriter();
                System.out.println(is);
		out.println("<font color=red>Either user name or password is wrong.</font>");
		rd.include(request, response);
	}


	} catch (Exception ex) {
		Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    
 

}

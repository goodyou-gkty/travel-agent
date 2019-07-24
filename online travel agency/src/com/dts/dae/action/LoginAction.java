package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;

public class LoginAction extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "LoginForm.jsp?status=Invalid username and password";
		try
		{HttpSession session=request.getSession();
			Profile rb = new Profile();
			String username = request.getParameter("username");
			rb.setLoginID(username);
			String pass=request.getParameter("password");
			rb.setPassword(pass);
             
			String role = new SecurityDAO().loginCheck(rb);

			if (role.equals("admin"))
			{
				target = "adminhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			else if (role.equals("user"))
			{
				
					target = "Uhome.jsp?status=Welcome " + username;
				
					target = "Uhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			else
				target = "LoginForm.jsp?status=Invalid username and password";
		}
		catch (Exception e)
		{
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}

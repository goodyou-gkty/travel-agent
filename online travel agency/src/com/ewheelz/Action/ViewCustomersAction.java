package com.ewheelz.Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.CoreList;
import com.dts.dae.dao.ProfileDAO;

public class ViewCustomersAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   
	        String target="";
	        CoreList empInfo=null;

		  try{
			  String path1=request.getRealPath("/userimages");
			 
			  empInfo= new ProfileDAO().getCustomers(path1);
			 
			  System.out.println("in View CustomersAction class vcb ..........."+empInfo);
			  if(empInfo!=null)
			  {
				  request.setAttribute("FacultyInfo", empInfo);
				  request.setAttribute("status", "Here is the Customers Info");
				  target="./ViewCustomers.jsp";
				 }
			  else {
				  request.setAttribute("status", "No customers R Available");
				  target="./ViewCustomers.jsp";
				  }
			  }
		  catch (NullPointerException e) {
			  request.setAttribute("status", "Plz try later");
			  target="./ViewCustomers.jsp";
			e.printStackTrace();
			
		}
		 RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.forward(request,response);
			}

}

package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.PickupDAO;
import com.ewheelz.FormBean.PickupFormBean;

public class CanclePickupAction extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		
		doPost(request,response);
		
		
	}
	
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String path="";
	try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("data readed");
		int pid=Integer.parseInt(request.getParameter("id"));
		PickupFormBean rb=new PickupFormBean();
                rb.setpid(pid);
				 int count1=new PickupDAO().deletePickup(rb);
			System.out.println(count1);
			if(count1>0){
				path="./pickupinfo.jsp?status=CANCILATION OF PICKUP POINT IS SUCCESSFUL";
			}
			else{
				path="pickupinfo.jsp?status= CANCILATION OF PICKUP POINT IS FAILED";
		 }
		
			
	}
	catch (Exception e) {
	e.printStackTrace();
	path="pickupinfo.jsp?status= INVALID ENTRIES";
	}
	RequestDispatcher rd1=request.getRequestDispatcher(path);
	rd1.forward(request,response);
	}
}

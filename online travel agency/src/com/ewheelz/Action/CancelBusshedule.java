package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ewheelz.Dao.SheduleDAO;
import com.ewheelz.FormBean.SheduleFormBean;

public class CancelBusshedule extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		
		doPost(request,response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

	try{
	 String path="";
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	int bid=Integer.parseInt(request.getParameter("id"));
	System.out.println("rootid--------"+bid);
	out.println("data readed");
	SheduleFormBean sb=new SheduleFormBean();
	sb.setBid(bid);
	 int count1=new SheduleDAO(). deleteShedule(sb);
		System.out.println(count1);
		if(count1>0){
			path="./Sheduleinfo.jsp?status=CANCILATION OF ROUTE IS SUCCESSFUL";
		}
		else{
			response.sendRedirect("Sheduleinfo.jsp?status= CANCILATION OF BUS FAILED");
	 }
	
		RequestDispatcher rd1=request.getRequestDispatcher(path);
		rd1.forward(request,response);
}
        catch (Exception e) {
           e.printStackTrace();
        response.sendRedirect("Sheduleinfo.jsp?status= INVALID ENTRIES");
   }
 }
}

package com.ewheelz.Action;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.RouteDAo;
import com.ewheelz.FormBean.RootFormBean;




public class CancleRootAction extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
	
	doPost(request,response);
	
	
}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String path="";
	try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int rid=Integer.parseInt(request.getParameter("id"));
		System.out.println("rootid--------"+rid);
		out.println("data readed");
		RootFormBean rb=new RootFormBean();
		rb.setId(rid);
				 int count1=new RouteDAo().deleteRoute(rb);
			System.out.println(count1);
			if(count1>0){
				path="./routeinfo.jsp?status=CANCILATION OF ROUTE IS SUCCESSFUL";
			}
			else{
				path="routeinfo.jsp?status= CANCILATION OF ROUTE FAILED";
		 }
		
			
	}
	catch (Exception e) {
	e.printStackTrace();
	path="routeinfo.jsp?status= INVALID ENTRIES";
	}
	RequestDispatcher rd1=request.getRequestDispatcher(path);
	rd1.forward(request,response);
}
}

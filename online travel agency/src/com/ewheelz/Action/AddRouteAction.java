package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.RouteDAo;
import com.ewheelz.FormBean.RootFormBean;

public class AddRouteAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	 {
		
		String path="";
		try{
		 
		 Calendar calendar=Calendar.getInstance();
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		String rfrom=request.getParameter("from");
		System.out.println("rfrom-------"+rfrom);
		String rto=request.getParameter("to");
		System.out.println("rto-------"+rto);
		String rdate=request.getParameter("dob");
		System.out.println("date is------------"+rdate);
		String rvia=request.getParameter("via");
		System.out.println("rvia-------"+rvia);
		out.println("data readed");
		
		Date date=new Date();
		System.out.println("current date"+date);
		calendar.set(date.getYear(), date.getMonth(), date.getDate());
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");           
		Date today = df.parse(rdate); 
		Calendar c1=Calendar.getInstance();		
		System.out.println("userdate issss"+today);
		c1.set(today.getYear(), today.getMonth(), today.getDate());
		
		
		
		if((calendar.before(c1))|| (c1.equals(calendar))){
		
		
		
		
		
		RootFormBean rb=new RootFormBean();
		rb.setFrom(rfrom);
		rb.setTo(rto);
		rb.setDate(rdate);
		rb.setVia(rvia);
		int count=new RouteDAo().addRoute(rb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./routeinfo.jsp?status=ADDTION OF ROUTE IS SUCCESSFUL";
			//path="./route.jsp?status=ADDTION OF ROUTE IS SUCCESSFUL";
		}
		else{
			path="./routeinfo.jsp?status=ADDITION OF ROUTE FAILED";
	 }
		
	 
		}
		else {
			path="Error.jsp?status= PLEASE SELECT CURRENT OR AFTER DATE";
		}
			
			
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	response.sendRedirect("routeinfo.jsp?status=INVALID ENTRIES");
	}

	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
}
	
	
}

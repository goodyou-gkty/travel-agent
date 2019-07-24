package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.RouteDAo;
import com.ewheelz.FormBean.RootFormBean;

public class UpdateRoute extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			doPost(request, response);
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	
		String path="";
		try{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		int rid=Integer.parseInt(request.getParameter("rid"));
		String from=request.getParameter("rfrom");
		String to=request.getParameter("rto");
		
		String rdate=request.getParameter("rdate");
		System.out.println("in servlet class"+rdate);
		//Date date=new Date(rdate);
		//System.out.println("in date obj"+date);
		String via=request.getParameter("rvia");
		out.println("data readed");
		RootFormBean rb=new RootFormBean();
		rb.setId(rid);
		rb.setFrom(from);
		rb.setTo(to);
		rb.setDate(rdate);
		rb.setVia(via);
		int count=new RouteDAo().updateRoute(rb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./routeinfo.jsp?status=UPDATIONOF ROUTE IS SUCCESSFUL";
			//path="./route.jsp?status=ADDTION OF ROUTE IS SUCCESSFUL";
		}
		else{
			path="./routeinfo.jsp?status=UPDATION OF ROUTE FAILED";
	 }
		
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	path="routeinfo.jsp?status=INVALID ENTRIES";
	}

	 
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	}


}

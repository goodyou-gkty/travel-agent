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

public class BusShedule extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
	try{
		 String path="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		int rid=Integer.parseInt(request.getParameter("rid"));
		int bid=Integer.parseInt(request.getParameter("bid"));
		int sno=Integer.parseInt(request.getParameter("sno"));
		int bfair=Integer.parseInt(request.getParameter("fair"));
		
		String sdate=request.getParameter("date");
		String time=request.getParameter("time");
		
		SheduleFormBean sb=new SheduleFormBean();
		sb.setBid(bid);
		sb.setRid(rid);
		sb.setSc(sno);
		sb.setBfair(bfair);
		sb.setSdate(sdate);
		sb.setTime(time);
		
		int count1=new SheduleDAO().addBusShedule(sb);
		System.out.println(count1);
		if(count1>0){
			path="./Sheduleinfo.jsp?status= ADDITION OF DATA INTO BUSSHEDULE IS SUCCESSFUL";
		}
		else{
			response.sendRedirect("Sheduleinfo.jsp?status= ADDITION OF DATA INTO BUSSHEDULE IS FAILED");
	 }
	
		RequestDispatcher rd1=request.getRequestDispatcher(path);
		rd1.forward(request,response);
		
		}
	catch (Exception e) {
		System.out.println("Exception raised"+e);
		response.sendRedirect("Sheduleinfo.jsp?status= ENTER PROPER DATA");
		
	}
	}
}

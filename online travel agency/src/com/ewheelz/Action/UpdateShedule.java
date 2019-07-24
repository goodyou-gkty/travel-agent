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



public class UpdateShedule extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doPost(request,response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		 String path="";
		
		try{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		int bid=Integer.parseInt(request.getParameter("bid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
		int seatno=Integer.parseInt(request.getParameter("seatno"));
		int bfair=Integer.parseInt(request.getParameter("fair"));
		out.println("data readed");
		SheduleFormBean pb=new SheduleFormBean();
		pb.setBid(bid);
		pb.setRid(rid);
		pb.setSc(seatno);
		pb.setBfair(bfair);
		int count=new SheduleDAO().updateShedule(pb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./Sheduleinfo.jsp?status=UPDATION OF PICKUP POINT IS SUCCESSFUL";
		}
		else{
			path="Sheduleinfo.jsp?status=UPDATION OF PICKUP POINT IS  FAILED";
	 }
		
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	path="Sheduleinfo.jsp?status=INVALID ENTRIES";
	}

	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	}
}
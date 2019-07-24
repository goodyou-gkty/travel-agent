package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.SeatDAO;
import com.ewheelz.FormBean.SeatFormBean;

public class SeatStorage extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
		String path="";
		try{
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		int seatno=Integer.parseInt(request.getParameter("seatno"));
		System.out.println("seatnoooo"+seatno);
		int rid=Integer.parseInt(request.getParameter("rid"));
		System.out.println("in seatstorage Action class routeid is;;;;;;;;"+rid);
		int bsno=Integer.parseInt(request.getParameter("busid"));
		System.out.println("busservicenoiss"+bsno);
		String date=request.getParameter("dob");
		System.out.println("date is"+date);
		String seatstatus=request.getParameter("seatstatus");
		System.out.println("status"+seatstatus);
		SeatFormBean sb=new SeatFormBean();
		System.out.println("beannnnnnn"+sb);
		sb.setSeatId(seatno);
		sb.setBid(bsno);
		sb.setDate(date);
		sb.setStatus(seatstatus);
		sb.setRid(rid);
		int count=new SeatDAO().conformSeat(sb);
		System.out.println("data set into bean");
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./Myseat.jsp?status=SEAT INFORMATION IS ADDED SUCCESSFULLY";
		}
		else{
			path="Myseat.jsp?status=STORING OF SEAT INFORMATION IS FAILED";
	 }
		
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	
	path="Myseat.jsp?status=INVALID ENTRIES";
	
	}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
	}

}

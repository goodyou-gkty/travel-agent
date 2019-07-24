package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ewheelz.Dao.ReserveDAO;
import com.ewheelz.FormBean.ReservationFormBean;



public class ReservationAction extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
	
		
		doPost(request,response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
	try{
		 String path="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs=request.getSession();
		out.println("this login servlet page");
		String btype=(String)hs.getAttribute("uesrbus");
		System.out.println("bustype......"+btype);
		String ufrom=(String)hs.getAttribute("from");
		System.out.println("frommmmmmmm"+ufrom);
		String date=(String)hs.getAttribute("date");
		System.out.println("date issssssss"+date);
		String uto=(String)hs.getAttribute("to");
		System.out.println("to issssssss"+uto);
		
		int rseatno=Integer.parseInt(request.getParameter("seatno"));
		System.out.println("reserved seatno........"+rseatno);
		int nos=(Integer)hs.getAttribute("noseat");
	
		System.out.println("no of seats"+nos);
		String userid=(String)hs.getAttribute("user");
		System.out.println("username"+userid);
		int bsno=(Integer)hs.getAttribute("busid");
		ReservationFormBean rb=new ReservationFormBean();
	     System.out.println("reserv Beanobject is created");
	     rb.setUfrom(ufrom);
	     rb.setUto(uto);
	     rb.setBtype(btype);
	     rb.setSeatno(rseatno);
	     rb.setLoginid(userid);
	     rb.setUdate(date);
	     rb.setSeatno(rseatno);
	     rb.setBusid(bsno);
	     hs.setAttribute("user", userid);
	     int count=new ReserveDAO().addBusShedule(rb);
	     System.out.println("count iss"+count);
	     if(count>0){
				path="./Reservation.jsp?status=RESERVATION IS SUCCESSFUL and Collect u r Ticket at Nearest Reservation Counter ";
			}
			else{
				response.sendRedirect("Reservation.jsp?status=RESERVATION  IS  FAILED");
		 }
			RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
		 
		
	     
	     
		out.flush();
		out.close();
	}
	catch (Exception e) {
		System.out.println("Exception raised"+e);
		response.sendRedirect("Reservation.jsp?status=RESERVATION  IS  FAILED");
	}

}
}
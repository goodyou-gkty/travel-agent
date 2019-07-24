package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ewheelz.Dao.ReserveDAO;
import com.ewheelz.FormBean.ReservationFormBean;

public class GetSeatAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	 {
		String path="";
		try{
              
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int rid=Integer.parseInt(request.getParameter("resvid"));
		
	System.out.println("reservation id in servlet////////"+rid);
	ReservationFormBean rb1=new ReservationFormBean();
		rb1.setReservid(rid);
		Vector<ReservationFormBean> vresv=new ReserveDAO().getSeat(rb1);
	 System.out.println("vector obj is received in "+vresv);
	 System.out.println("vector obj size is"+vresv.size());
	 HttpSession hs=request.getSession();
		hs.setAttribute("vres", vresv);
		hs.setAttribute("reserveid", rid);
	 
		if(vresv!=null){
			System.out.println("in forward");
			path="Reservedseat.JSP?status=SELECT WHICH SEAT U WANT TO CANCEL ";
		}
		else{
			path="Cancelseat.JSP?status=SORRY THERE ARE NO  SEATS R RESERVED  BY U";
	 }
	
		
	}
		catch (Exception e) {
			e.printStackTrace();
			path="Reservedseat.JSP?status= PLEASE ENTER RESERVATION ID";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	 }
}

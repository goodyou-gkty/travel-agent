package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dts.core.util.DateWrapper;
import com.ewheelz.Dao.CheckDAO;
import com.ewheelz.FormBean.BusFormBean;
import com.ewheelz.FormBean.CheckFormBean;

public class CheckAvalability extends HttpServlet {

	public void doGett(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		doPost(request,response);
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    
		Vector<BusFormBean> vbus=null;
		String path="";
	try{
		   Calendar calendar=Calendar.getInstance();
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ufrom=request.getParameter("userfrom");
		String uto=request.getParameter("userto");   
		String udate=request.getParameter("dob"); 
		String ubus=request.getParameter("userbus");
		int no=Integer.parseInt(request.getParameter("seatno"));
		System.out.println("In Availability date is------------"+udate);
		System.out.println("rootfrom--------"+ufrom);
		
		System.out.println("bustype--------"+ubus);  
		out.println("data readed");
		Date date=new Date();
		System.out.println("current date"+date);
		calendar.set(date.getYear(), date.getMonth(), date.getDate());
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");           
		Date today = df.parse(udate); 
		Calendar c1=Calendar.getInstance();		
		System.out.println("userdate issss"+today);
		c1.set(today.getYear(), today.getMonth(), today.getDate());
		
		if(ufrom.equals(uto))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userhome.jsp?status=ROUTES R NOT AVAILABLE"); 
			requestDispatcher.forward(request, response);
		}
		else if((calendar.before(c1))|| (c1.equals(calendar))){
		
		
		CheckFormBean cb=new CheckFormBean();
		cb.setFrom(ufrom);
		cb.setTo(uto);
		cb.setDate(udate);
		cb.setBtype(ubus);
		
		
			
		 vbus=new CheckDAO().getBus(cb);
		HttpSession hs=request.getSession();
		hs.setAttribute("vbus", vbus);
		hs.setAttribute("date", udate);
		hs.setAttribute("from", ufrom);
		hs.setAttribute("to", uto);
		hs.setAttribute("noseat", no);
		hs.setAttribute("uesrbus", ubus);
			System.out.println( "vbussssssss"+vbus);
			System.out.println("in servlet "+vbus.size());
		
			if(vbus.size()!=0){
				
				   request.setAttribute("vbus", vbus);
				   request.setAttribute("rdate", udate);
				   
				   path="./Checkbus.jsp?status=SELECT BUS FROM THE FOLLOWING LIST";
			}
			else{
				path="./userhome.jsp?status= SORRY THERE ARE NO BUSES AVAILABLE IN THE ROUTE SPECIFIED BY U";
		        }
		
			
	}
		else {
			path="./userhome.jsp?status= PLEASE SELECT CURRENT OR AFTER DATE";
		}
	}
	catch (Exception e) {
	e.printStackTrace();
	path="./userhome.jsp?status= PLEASE ENTER PROPER DETAILS";
	}
	RequestDispatcher rd1=request.getRequestDispatcher(path);
	rd1.forward(request,response);
}
}

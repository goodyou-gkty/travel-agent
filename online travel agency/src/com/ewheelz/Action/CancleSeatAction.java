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



public class CancleSeatAction extends HttpServlet {

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
		int seatno=Integer.parseInt(request.getParameter("seatno"));
		System.out.println("incalcel servlet seatno="+seatno);
		HttpSession hs=request.getSession();
		int resvid=(Integer)hs.getAttribute("reserveid");
		System.out.println("in servlet resvis.........."+resvid);
		int busid=(Integer)hs.getAttribute("busid");
		System.out.println("in servlet busid,,,,,,,,,,,,,"+busid);
		ReservationFormBean rb=new ReservationFormBean();
		rb.setReservid(resvid);
		rb.setSeatno(seatno);
		rb.setBusid(busid);
		int count=new ReserveDAO().cancleSeat(rb);
		
		
		if(count>0){
		
		path="./Cancleseat.jsp?status=CANCILATION IS SUCCESSFUL ";
   		}
   		else{
   			path="./Cancleseat.jsp?status= SORRY THIS  SEAT IS NOT RESERVED  BY U";
   	 }
   		
		
		
	}
            catch(Exception e) {
    	     e.printStackTrace();
    	     path="Cancleseat.jsp?status= PLEASE ENTER RESERVATION ID";
	}     
            
            
            RequestDispatcher rd=request.getRequestDispatcher(path);
       		rd.forward(request,response);

}
}
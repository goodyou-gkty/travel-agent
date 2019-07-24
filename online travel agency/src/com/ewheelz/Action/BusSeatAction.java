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

import com.ewheelz.Dao.SeatDAO;
import com.ewheelz.FormBean.SeatFormBean;

public class BusSeatAction extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		
		doPost(request,response);
		
	}
	
	
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
		String path="";
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	
		//String bname=request.getParameter("busname");
		//String btype=request.getParameter("type");
		int bsno=Integer.parseInt(request.getParameter("bid"));
		String rdate=request.getParameter("rdate");
		System.out.println("in BusSeat Action rdate is................"+rdate);
		System.out.println("hyhy"+bsno);
		System.out.println("data readed");
		SeatFormBean sb=new SeatFormBean();
        System.out.println("seatbean object created");
		//sb.setBtype(btype);
		sb.setBid(bsno);
		sb.setDate(rdate);
		//sb.setBname(bname);
		
		Vector<SeatFormBean> vseat=new SeatDAO().getSeatNo(sb);
		System.out.println("in busseat"+vseat);
		HttpSession hs=request.getSession();
		request.setAttribute("seatvect", vseat);
		hs.setAttribute("busid", bsno);
		System.out.println(vseat);
		out.print("DAO object is created");
		if(vseat!=null){
			path="./Seatinfo.jsp?status=THESE R AVABLE BUS SEATS ";
		}
		else{
			path="Seatinfo.jsp?status=SLECTION SEATS R FAILED";
	 }
		
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception........... raised"+e);
	
	path="Seatinfo.jsp?status= PLZ SELECT ANY SEAT";
	
	}

	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
}

}

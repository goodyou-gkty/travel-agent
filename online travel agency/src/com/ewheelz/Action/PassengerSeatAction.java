package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.SeatDAO;
import com.ewheelz.FormBean.SeatFormBean;

public class PassengerSeatAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
		 String path="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String bname=request.getParameter("busname");
		String btype=request.getParameter("type");
		int bsno=Integer.parseInt(request.getParameter("bussno"));
		int seatno=Integer.parseInt("seatno");
		out.println("data readed");
		SeatFormBean sb=new SeatFormBean();
		sb.setBtype(btype);
		sb.setBid(bsno);
		sb.setBname(bname);
		sb.setSeatno(seatno);
		Vector<SeatFormBean> vseat=new SeatDAO().getSeatNo(sb);
	}
        catch (Exception e) {
			System.out.println("Exception raised"+e);
		}
		}
}

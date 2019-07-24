package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.BusDAO;
import com.ewheelz.FormBean.BusFormBean;

public class AddBusAction extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	
	{
		String path="";
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	
		String bname=request.getParameter("busname");
		String btype=request.getParameter("type");
		int bsno=Integer.parseInt(request.getParameter("seats"));
		out.println("data readed");
		BusFormBean bb=new BusFormBean();
		bb.setBtype(btype);
		bb.setSno(bsno);
		bb.setBname(bname);
		int count=new BusDAO().addBus(bb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./Businfo.jsp?status=BUS IS ADDED SUCCESSFULLY";
		}
		else{
			path="./Businfo.jsp?status=ADDITION OF BUS IS FAILED";
	 }
		
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	path="Businfo.jsp?status=INVALID ENTRIES";
	
	}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
}
}

package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.BusDAO;
import com.ewheelz.FormBean.BusFormBean;

public class CancleBusAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		
		doPost(request,response);
		
		
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String path="";
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int bid=Integer.parseInt(request.getParameter("id"));
		System.out.println("rootid--------"+bid);
		out.println("data readed");
		BusFormBean rb=new BusFormBean();
		rb.setBusId(bid);
		 int count1=new BusDAO().deleteBus(rb);
			System.out.println(count1);
			if(count1>0){
				path="./Businfo.jsp?status=CANCILATION OF ROUTE IS SUCCESSFUL";
			}
			else{
				path="Businfo.jsp?status= CANCILATION OF BUS FAILED";
		 }
		
			
	}
	catch (Exception e) {
	e.printStackTrace();
	path="Businfo.jsp?status= INVALID ENTRIES";
	}
	
	RequestDispatcher rd1=request.getRequestDispatcher(path);
	rd1.forward(request,response);
	}
}

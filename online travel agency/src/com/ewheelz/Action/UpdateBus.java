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



public class UpdateBus extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		{
			
			doPost(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	
		String path="";		
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		System.out.println("this is updatebua page");
		System.out.println("hellooooooooo");
		int bid=Integer.parseInt(request.getParameter("id"));
		System.out.println("heiiiiiiiiiiiiii");
		System.out.println("inservlet doget id--------"+bid);
		String btype=request.getParameter("btype");
		System.out.println("inservlet doget bus type"+btype);
		String bname=request.getParameter("bname");
		int sno=Integer.parseInt(request.getParameter("sno"));
		BusFormBean sb=new BusFormBean();
		sb.setBusId(bid);
		sb.setBname(bname);
		sb.setBtype(btype);
		sb.setSno(sno);
		
		int count1=new BusDAO().updateBus(sb);
		System.out.println(count1);
		if(count1>0){
			path="./Businfo.jsp?status=BUS DETAILS UPDATION IS SUCCESSFUL";
		}
		else{
			path="Businfo.jsp?status=BUS DETAILS UPDATION IS FAILED";
	 }
	
		
		
		}
	catch (Exception e) {
		System.out.println("Exception raised"+e);
		path="Businfo.jsp?status= ENTER PROPER DATA";
		
	}
	
	RequestDispatcher rd1=request.getRequestDispatcher(path);
	rd1.forward(request,response);
	}

}

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

import com.ewheelz.Dao.PickupDAO;
import com.ewheelz.FormBean.PickupFormBean;

public class PickupPointAction extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
         
		String path="";
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		int rid=Integer.parseInt(request.getParameter("rid"));
		int bid=Integer.parseInt(request.getParameter("bid"));
		String pname=request.getParameter("pname");
		out.println("data readed");
		PickupFormBean pb=new PickupFormBean();
		pb.setBid(bid);
		pb.setRid(rid);
		pb.setPname(pname);
		int count=new PickupDAO().addPickupPoint(pb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./pickupinfo.jsp?status=ADDTION OF PICKUP POINT IS SUCCESSFUL";
		}
		else{
			path="pickupinfo.jsp?status=ADDITION OF PICKUP POINT IS  FAILED";
	 }
		
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	path="pickupinfo.jsp?status=INVALID ENTRIES";
	}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);

}
}

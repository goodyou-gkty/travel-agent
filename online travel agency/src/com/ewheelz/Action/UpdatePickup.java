package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.PickupDAO;
import com.ewheelz.FormBean.PickupFormBean;

public class UpdatePickup extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		String path="";
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		int pid=Integer.parseInt(request.getParameter("pid"));
		int rid=Integer.parseInt(request.getParameter("routeid"));
		int bid=Integer.parseInt(request.getParameter("busid"));
		String pname=request.getParameter("pname");
		out.println("data readed");
		PickupFormBean pb=new PickupFormBean();
		pb.setpid(pid);
		pb.setBid(bid);
		pb.setRid(rid);
		pb.setPname(pname);
		int count=new PickupDAO().updateBus(pb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./pickupinfo.jsp?status=UPDATION OF PICKUP POINT IS SUCCESSFUL";
		}
		else{
			path="pickupinfo.jsp?status=UPDATION OF PICKUP POINT IS  FAILED";
	 }
		RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	path="pickupinfo.jsp?status=INVALID ENTRIES";
	}


}

}

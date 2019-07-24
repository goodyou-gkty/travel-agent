package com.ewheelz.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ewheelz.Dao.FairDAO;
import com.ewheelz.FormBean.FairFormBean;

public class UpdateFair extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path="";
		try{
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this login servlet page");
		int bid=Integer.parseInt(request.getParameter("busid"));
		int rid=Integer.parseInt(request.getParameter("routeid"));
		
		int famt=Integer.parseInt(request.getParameter("pname"));
		out.println("data readed");
		FairFormBean pb=new FairFormBean();
	
		pb.setBid(bid);
		pb.setRid(rid);
		pb.setFamt(famt);
		int count=new FairDAO().updateFair(pb);
		System.out.println(count);
		out.print("DAO object is created");
		if(count>0){
			path="./FairInfo.jsp?status=UPDATION OF BUS FAIR IS SUCCESSFUL";
		}
		else{
			path="FairInfo.jsp?status=UPDATION OF BUS FAIR IS  FAILED";
	 }
		RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
	 
	
	 }
	 catch (Exception e) {
	System.out.println("exception raised"+e);
	path="FairInfo.jsp?status=INVALID ENTRIES";
	}
	}

}

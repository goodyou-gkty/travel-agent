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

public class FairAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	
	{
		String path="";
	try{
	 
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("this login servlet page");
	int rid=Integer.parseInt(request.getParameter("rid"));
	System.out.println("in servlet routeid'''''''''"+rid);
	int bid=Integer.parseInt(request.getParameter("bid"));
	System.out.println("in servlet busid issss"+bid);
	int famt=Integer.parseInt(request.getParameter("pname"));
	System.out.println("in servlet fair"+famt);
	out.println("data readed");
	FairFormBean fb=new FairFormBean();
	fb.setBid(bid);
	fb.setRid(rid);
	fb.setFamt(famt);
	int count=new FairDAO().addFair(fb);
	System.out.println(count);
	out.print("DAO object is created");
	if(count>0){
		path="./Fair.jsp?status=ADDTION OF FAIR IS SUCCESSFUL";
	}
	else{
		path="Fair.jsp?status=ADDITION OF FAIR IS  FAILED";
 }
	
 

 }
 catch (Exception e) {
System.out.println("exception raised"+e);
path="Fair.jsp?status=INVALID ENTRIES";
}
 RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request,response);
	}

}

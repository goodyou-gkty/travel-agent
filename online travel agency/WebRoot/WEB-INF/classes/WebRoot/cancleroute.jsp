<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.RootFormBean"%>
<%@page import="com.ewheelz.Dao.RouteDAo"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="Header.jsp"></jsp:include> 
                        
  
  <h1> WELCOME TO CANCLE ROUTE PAGE</h1>
  <center>
  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>
  
  </center>
<center>
  <body bgcolor=""><BR><BR>
 <form action="./cancleroute" method="post">
 <h2>SELECT ROUTE WHICH U WANT TO CANCLE</h2>
 Select Here:<select name="id">
 <option>SELECT</option>
 <%
 Vector<RootFormBean> vbus=new RouteDAo().selectRouteId();
 Iterator it=vbus.listIterator();
 while(it.hasNext())
 {
RootFormBean rb=(RootFormBean)it.next();%>

<option value="<%=rb.getId()%>"><%=rb.getFrom()%><br><br><%=rb.getTo()%></option>

<% }
%>
</select>

<br/><br/><br/>
 Click Here To Cancle Root:<input type="submit" value="CANCLE ROUTE"/>
 </form>
<br/><br/>
    
<jsp:include page="Footer.jsp"></jsp:include>
</body></html>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.SheduleFormBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

  
  <body bgcolor="">
   <jsp:include page="Header.jsp"></jsp:include>
  <br/>
  <h2>ENTER U R UPDATIONS HERE </h2>
  <%
  SheduleFormBean sb=(SheduleFormBean)session.getAttribute(""+request.getParameter("id"));
   %>
  <form action="./UpdateShedule">
  BusId:<input type="text" name="bid" value="<%=sb.getBid() %>"/><br/><br/>
  RouteId:<input type="text" name="rid" value="<%=sb.getRid() %>"/><br/><br/>
  SeatCount:<input type="text" name="seatno" value="<%=sb.getSc() %>"/><br/><br/>
  BusFair:<input type="text" name="fair" value="<%=sb.getBfair() %>"/><br/><br/>
  <input type="submit" name="update" value="UPDATE"/>
   <br/>
   </form> <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>


</body></html>
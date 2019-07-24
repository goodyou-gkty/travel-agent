<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.FairFormBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

                        
  
  <center>
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
  <br/>
  <h4><i><font color="#40E0D0">ENTER U R UPDATIONS HERE</font></i></h4>
  <%
  FairFormBean pb=(FairFormBean)session.getAttribute(""+request.getParameter("id"));
  System.out.println("in jsp updatefairbeanis"+pb);
   %>
   <form action="./UpdateFair">
   <table border="1">
   <tr><td>BusId:<input type="text" name="busid" value="<%=pb.getBid() %>"/></td></tr>
   <tr><td>Routeid:<input type="text" name="routeid" value="<%=pb.getRid() %>"/></td></tr>
   <tr><td>Fair Amount:<input type="text" name="pname" value="<%=pb.getFamt() %>"/></td></tr><tr></tr><tr></tr>
   <tr><td><input type="submit" name="update" value="UPDATE"/></td></tr>
   </table>
   
   </form> <br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

</body></html>

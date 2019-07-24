<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.BusFormBean"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

  

 <body bgcolor="">
 <jsp:include page="Header.jsp"></jsp:include>
  <br/>
     
 <center><h4><i><font color="#9370D8">WELCOME TO UPDATE BUS PAGE</font></i></h4></center>
  <%
  BusFormBean bb=(BusFormBean)session.getAttribute(""+request.getParameter("id"));
   %>
   <form action="./busupdate" method="post">
   <center>
   <table border="1">
   <tr><td>
   BusName:<input type="text" name="id" value="<%=bb.getBusId() %>" readonly="readonly"></input></td></tr>
   
   <tr><td> BusName:<input type="text" name="bname" value="<%=bb.getBname() %>"></input></td></tr>
    <tr><td>BusType:<input type="text" name="btype" value="<%=bb.getBtype() %>"></input></td></tr>
   <tr><td>AvailableSeats:<input type="text" name="sno" value="<%=bb.getSno() %>"></input></td></tr><tr></tr>
   <tr><td><input type="submit" name="add" value="UpdateBUSDetails"></input></td></tr>
   </table>
   </center>
   </form>
   
   
    <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>


</body></html>
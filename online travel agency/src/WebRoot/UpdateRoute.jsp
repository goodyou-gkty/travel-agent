<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.RootFormBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  
  
  <body bgcolor="">
  
  <jsp:include page="Header.jsp"></jsp:include>
  <br/>
 <center>
 <h4> <i><font color="#C71585">MADE U R UPDATIONS HERE</font></i></h4>
  <%
  RootFormBean rb=(RootFormBean)session.getAttribute(""+request.getParameter("id"));
  System.out.println("in jsp rootbean obj is"+rb);
   %>
  
    <form action="./UpdateRoute">
    
    <table border="1">
    <tr><td>Routeid<input type="text" name="rid" value="<%=rb.getId() %>" readonly="readonly"/></td></tr>
    <tr><td>From:<input type="text" name="rfrom" value="<%=rb.getFrom() %>"/></td></tr>
    <tr><td>To:<input type="text" name="rto" value="<%=rb.getTo() %>"/></td></tr>
   <tr><td> Date:<input type="text" name="rdate" value="<%=rb.getDate().trim() %>" readonly="readonly"/></td></tr>
    <tr><td>Via:<input type="text" name="rvia" value="<%=rb.getVia() %>"/></td></tr><tr></tr><tr></tr>
    <tr><td><input type="submit" name="update" value="UPDATE"/></td></tr>
    
    </table>
   </form>
    
   </center>
   
   <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

</body></html>
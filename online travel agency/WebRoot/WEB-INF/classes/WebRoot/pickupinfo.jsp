<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.PickupFormBean"%>
<%@page import="com.ewheelz.Dao.PickupDAO"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

  <body bgcolor="">
  <jsp:include page="Header.jsp"></jsp:include>
  <br/>
  <center>
  <caption>PICKUP POINTS TABLE </caption>
   <%
    String role=(String)session.getAttribute("role");
    
    if(role.equalsIgnoreCase("admin")){
    
    %>
   <table align="center" border="1" >
   <tr><th bgcolor="#DDA0DD"><b>PICKUP ID</b></th><th bgcolor="#DDA0DD"><b>BUS ID</b></th><th bgcolor="#DDA0DD"><b>ROUTE ID</b></th><th bgcolor="#DDA0DD"><b>PICKUP POINT NAME</b></th><th bgcolor="#DDA0DD"><b>OPERATION</b></th>
    </tr>
    
   <%
 Vector<PickupFormBean> vbus=new PickupDAO().selectPickupId();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {%><tr>
 <%PickupFormBean pb=(PickupFormBean)it.next();
session.setAttribute(""+pb.getpid(),pb);
%>

<td><a href="UpdatePickup.jsp?id=<%=pb.getpid()%>"><%=pb.getpid()%></a></td>
<td><%=pb.getBid()%></td>
<td><%=pb.getRid()%></td>
<td><%=pb.getPname()%></td>
<td><a href="./canclepickup?id=<%=pb.getpid()%>">CANCEL</a></td> 
</tr>

<% }
%>

   <tr><td>
    <center>
    <a href="./Addpickup.jsp">ADD NEW PICKUP POINT</a>
    </center>
    </td></tr>
    </table>
     <%
    }
  else if(role.equalsIgnoreCase("user")){
    
    %>
   <table border="1">
    <tr><th bgcolor="#4682B4"><b>PICKUP ID</b></th><th bgcolor="#4682B4"><b>BUS ID</b></th><th bgcolor="#4682B4"><b>ROUTE ID</b></th><th bgcolor="#4682B4"><b>PICKUP POINT NAME</b></th>
  </tr>
  <%
   Vector<PickupFormBean> vbus=new PickupDAO().selectPickupId();
 Iterator it1=vbus.listIterator();
    while(it1.hasNext()){%><tr>
    
    <%PickupFormBean pb1=(PickupFormBean)it1.next();
    %>
    
    <td><%=pb1.getpid()%></td>
<td><%=pb1.getBid()%></td>
<td><%=pb1.getRid()%></td>
<td><%=pb1.getPname()%></td>

    <%}
    } %>
    
    </tr>
    </table>
     <br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
                     


</body></html>
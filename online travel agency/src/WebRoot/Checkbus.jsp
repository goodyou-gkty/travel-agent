<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.BusFormBean"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
                       
  
  <head><title>U R REQUESTED BUSES INFORMATION </title></head>
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
               <br/>
  <center>
  <form action="" method="post">
  <table border="1" cellpadding="10">
  <caption> AVAILABLE BUESE INFORMATION</caption>
  <tr><th><b>BusId</b></th><th><b> BusTYpe</b> </th><th><b> BusName</b> </th><th><b>BusFair</b></th><th><b>DispatchingTime</b></th><th><b>Action</b></th> 
  </tr>
  <%
 Vector<BusFormBean> vbus=(Vector<BusFormBean>)session.getAttribute("vbus");
 System.out.println(vbus.size());
 Iterator it=vbus.iterator();
 while(it.hasNext())
 {%><tr>
 <%BusFormBean bs=(BusFormBean)it.next();
 
 String btype=bs.getBtype();
 
 session.setAttribute("bustype",btype);
 
 String rdate=(String)request.getAttribute("rdate");
 
 System.out.println("date in jsp is........."+rdate);
 
  %> 
 <td><%=bs.getBusId()%></td> 
  <td><%=bs.getBtype() %></td>
   <td><%=bs.getBname() %> </td>
   <td><%=bs.getBfair() %></td>
   <td><%=bs.getTime() %></td>
   <td><a href="./BusSeat?bid=<%=bs.getBusId()%>&rdate=<%=rdate %>">CONTINUE</a></td>
 </tr>
 <%}%>

  </table>
  
  </form><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
                     


</body></html>
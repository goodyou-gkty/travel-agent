<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.SeatFormBean"%>
<%@page import="com.ewheelz.Dao.SeatDAO"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  
  <body bgcolor="">
   <jsp:include page="Header.jsp"></jsp:include>
  <br/>
  <form action=""></form>
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption><h3><i>SEATS STATUS INFROMATION </i></h3></caption>
   <tr><th bgcolor="#87CEFA"><b>SEAT NO</b></th><th bgcolor="#87CEFA"><b>BUS ID</b></th><th bgcolor="#87CEFA"><b>DOJ</b></th><th bgcolor="#87CEFA"><b>STATUS</b></th>
       </tr>
    <%
 Vector<SeatFormBean> vbus=new SeatDAO().getSeat();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {%><tr>
    <%SeatFormBean sb=(SeatFormBean)it.next();%>
    
    
<td><%=sb.getSeatId()%></td>
<td><%=sb.getBid()%></td>
<td><%=sb.getDate()%></td>
<td><%=sb.getStatus()%></td>
   </tr> 
    <%} %>
    <br/>
 </table>
  <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

                     


</body>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.ReservationFormBean"%>
<%@page import="com.ewheelz.Dao.ReserveDAO"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

  
  <body>
    
     <jsp:include page="Header.jsp"></jsp:include>
  <br/>
   <table align="center" border="1" bgcolor="" width="100%" cellpadding="10">
   <caption>RESERVATION INFORMATION OF EWHEELZ</caption>
   <tr><th bgcolor="#4682B4"><b>RESERVE ID</b></th><th bgcolor="#4682B4"><b>FROM</b></th><th bgcolor="#4682B4"><b>TO</b></th><th bgcolor="#4682B4"><b>JOURNY DATE</b></th><th bgcolor="#4682B4"><b>BUSTYPE</b></th><th bgcolor="#4682B4"><b>SERVICE NO</b></th><th bgcolor="#4682B4"><b>SEAT NO</b></th>
    </tr>
    <%
    String userid=(String)session.getAttribute("user");
    System.out.println("in jsp username"+userid);
 Vector<ReservationFormBean> vres=new ReserveDAO().selectReservation(userid);
 Iterator it=vres.listIterator();

 while(it.hasNext())
 {%><tr>
 <%ReservationFormBean rb=(ReservationFormBean)it.next();%>
<td><%=rb.getReservid()%></td>
<td><%=rb.getUfrom()%></td>
<td><%=rb.getUto()%></td>
<td><%=rb.getUdate()%></td>
<td><%=rb.getBtype()%></td>
<td><%=rb.getBusid()%></td>
<td><%=rb.getSeatno()%></td>
 
</tr>
    <%} %>
    
    </table>
    <BR><BR><BR>
    <center>
    <i> <h3>THAN Q FOR VISITING EWHEELZ</h3></i>
    <BR><BR>
    <i>VISIT AGAIN</i>
    </center>
  <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

</body></html>
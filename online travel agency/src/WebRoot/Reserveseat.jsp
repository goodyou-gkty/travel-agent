<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.ReservationFormBean"%>
<%@page import="com.ewheelz.Dao.ReserveDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

 
  <body>
  
    <jsp:include page="Header.jsp"></jsp:include>
  <br/>
   <h4><i><font>THIS IS U R RESERVATION INFORMATION</font></i></h4>
  <table align="center" border="1" bgcolor="" width="100%" cellpadding="10">
   <caption>RESERVATION INFORMATION OF EWHEELZ</caption>
   <tr><th bgcolor="#8FBC8F"><b>RESERVE ID</b></th><th bgcolor="#8FBC8F"><b>FROM</b></th><th bgcolor="#8FBC8F"><b>TO</b></th><th bgcolor="#8FBC8F"><b>JOURNY DATE</b></th><th bgcolor="#8FBC8F"><b>BUSTYPE</b></th><th bgcolor="#8FBC8F"><b>SERVICE NO</b></th><th bgcolor="#8FBC8F"><b>SEAT NO</b></th><th bgcolor="#8FBC8F"><b>ACTION</b></th>
    </tr>
    <form action="./">
    
    <%
   
    int rid=Integer.parseInt(request.getParameter("resvid"));
		
	System.out.println("reservation id in servlet////////"+rid);
		ReservationFormBean rb1=new ReservationFormBean();
		rb1.setReservid(rid);
		Vector<ReservationFormBean> vresv=new ReserveDAO().getSeat(rb1);
 //Vector<ReservationBean> vresv=(Vector<ReservationBean>)session.getAttribute("vres");
 System.out.println("vector obj is received to jsppppppppp"+vresv);
 System.out.println("vector obj size in jspppppppppppppp is"+vresv.size());
 Iterator it=vresv.listIterator();
 
 while(it.hasNext()){
 %><tr>
  <%ReservationFormBean rb=(ReservationFormBean)it.next(); 
  
  int busid=rb.getBusid();
  System.out.println("in jsp busid;;;;;;;;;;;;"+busid);
    session.setAttribute("busid",busid);
    int reservid=rb.getReservid();
    System.out.println("in jsp resrvis................."+reservid);
    session.setAttribute("reserveid",reservid);
  
  %>
  
<td><%=rb.getReservid()%></td>
<td><%=rb.getUfrom()%></td>
<td><%=rb.getUto()%></td>
<td><%=rb.getUdate()%></td>
<td><%=rb.getBtype()%></td>
<td><%=rb.getBusid()%></td>
<td><%=rb.getSeatno()%></td>
 <td><a href="./CancleSeat?seatno=<%=rb.getSeatno()%>">CANCEL</a></td>
</tr>
  
  
  </table>
 
    
    <% }%>
    
  <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>


</body></html>

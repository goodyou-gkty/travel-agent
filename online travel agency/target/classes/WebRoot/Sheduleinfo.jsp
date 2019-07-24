<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<%@page import="com.ewheelz.Dao.SheduleDAO"%>
<%@page import="com.ewheelz.FormBean.SheduleFormBean"%>

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
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <tr bgcolor="lightblue"><i>Bus Shedule Info</i></tr><br/>
   <caption>BUS SHEDULE INFORMATION </caption>
   <tr><th bgcolor="lightblue"><b>BUS SERVICE NO</b></th><th bgcolor="lightblue"><b>ROUTE ID</b></th><th bgcolor="lightblue"><b>NO OF SEATS</b></th><th bgcolor="lightblue"><b>Fair</b></th><th bgcolor="lightblue"><b>OPERATION</b></th>
    </tr>
   <%
 Vector<SheduleFormBean> vbus=new SheduleDAO().selectBusShedule();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {%><tr>
 <%SheduleFormBean sb=(SheduleFormBean)it.next();
session.setAttribute(""+sb.getBid(),sb);

%>
<td><a href="./sheduleupdate.jsp?id=<%=sb.getBid()%>"><%=sb.getBid()%></a></td>
<td><%=sb.getRid()%></td>
<td><%=sb.getSc()%></td>
<td><%=sb.getBfair()%></td>
<td><a href="./CancelBusshedule?id=<%=sb.getBid()%>">CANCEL</a></td> 
</tr>

<% }
%>

    <br></table><BR/>
    
    <center>
    <a href="./Shedule.jsp">ADD NEW SHEDULE</a>
    </center>
   <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>


</body></html>
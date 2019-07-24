<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.RootFormBean"%>
<%@page import="com.ewheelz.Dao.RouteDAo"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>


  
  <body bgcolor="">
   <jsp:include page="Header.jsp"></jsp:include>
  <br/>
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>ROUTE INFROMATION&nbsp;</caption>
   <%
    String role=(String)session.getAttribute("role");
    
    if(role.equalsIgnoreCase("admin")){
    
    %>
   <tr><th bgcolor="ashblue"><b>ROUTEID</b></th><th bgcolor="ashblue"><b>FROM</b></th><th bgcolor="ashblue"><b>TO</b></th><th bgcolor="ashblue"><b>DATE</b></th><th bgcolor="ashblue"><b>VIA</b></th><th bgcolor="ashblue"><b>OPERATION</b></th>
    </tr>
   
   <%
 Vector<RootFormBean> vbus=new RouteDAo().selectRouteId();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {%>
 <%RootFormBean rb=(RootFormBean)it.next();
session.setAttribute(""+rb.getId(),rb);

%>
<tr>
<td><a href="./UpdateRoute.jsp?id=<%=rb.getId()%>"><%=rb.getId()%></td>
<td><%=rb.getFrom()%></td>
<td><%=rb.getTo()%></td>
<td><%=rb.getDate()%></td>
<td><%=rb.getVia()%></td>
<td><a href="./cancleroute?id=<%=rb.getId()%>">CANCEL</a></td>
</tr>

<%}
    if(role.equalsIgnoreCase("admin")){
     %>
     <tr align="center">
   <center>  <br/>
    <a href="./route.jsp">ADD NEW ROUTE</a>
    </center>
    </tr>
<%} 
    }
  else if(role.equalsIgnoreCase("user")){
    
    %>
  
    <tr><th bgcolor="ashblue"><b>ROUTEID</b></th><th bgcolor="ashblue"><b>FROM</b></th><th bgcolor="ashblue"><b>TO</b></th><th bgcolor="ashblue"><b>VIA</b></th>
   <%
 Vector<RootFormBean> vbus=new RouteDAo().selectRouteId();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {
   RootFormBean rb1=(RootFormBean)it.next();
 %>
 <tr>
     <td><%=rb1.getId()%></td>
<td><%=rb1.getFrom()%></td>
<td><%=rb1.getTo()%></td>

<td><%=rb1.getVia()%></td>
<%}
}
 %>
</tr>
 
</table>
 
 
    
    

  <br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>




</body></html>
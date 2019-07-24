<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.BusFormBean"%>
<%@page import="com.ewheelz.Dao.BusDAO"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  
  <body bgcolor="">
  
   <jsp:include page="Header.jsp"></jsp:include> 
  <center>
 
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
    <caption>BUSES TABLE&nbsp;</caption>
    <%
    String role=(String)session.getAttribute("role");
    
    if(role.equalsIgnoreCase("admin")){
    
    %>
   <tr><th bgcolor="lightblue"><b>BUS SERVICE NO</b></th><th bgcolor="lightblue"><b>BUS TYPE</b></th><th bgcolor="lightblue"><b>SEAT CAPACITY</b></th><th bgcolor="lightblue"><b>BUS NAME</b></th><th bgcolor="lightblue"><b>OPERATION</b></th>
    </tr>
    
   
   <%
 Vector<BusFormBean> vbus=new BusDAO().selectBusId();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {%><tr>
<%BusFormBean bb=(BusFormBean)it.next();
session.setAttribute(""+bb.getBusId(),bb);

%>
   
 <td><a href="updatebus.jsp?id=<%=bb.getBusId()%>"><%=bb.getBusId()%></a></td>

<td><%=bb.getBtype()%></td>
<td><%=bb.getSno()%></td>
<td><%=bb.getBname()%></td>

<td><a href="./canclebus?id=<%=bb.getBusId()%>">CANCEL</a></td> 
</tr>



   <%}
   %>
   <tr><td>
    <a href="./AddBus.jsp">ADD NEW BUS</a>
    </td>
    </tr>
   
      <%
    }
  else if(role.equalsIgnoreCase("user")){
    
    %>
     <tr><th bgcolor="lightblue"><b>BUS SERVICE NO</b></th><th bgcolor="lightblue"><b>BUS TYPE</b></th><th bgcolor="lightblue"><b>SEAT CAPACITY</b></th><th bgcolor="lightblue"><b>BUS NAME</b></th>
  <%
  Vector<BusFormBean> vbus=new BusDAO().selectBusId();
 Iterator it=vbus.listIterator();

 while(it.hasNext())
 {%><tr>
<%BusFormBean bb1=(BusFormBean)it.next();
  %>  
    <td><%=bb1.getBusId()%></td>

<td><%=bb1.getBtype()%></td>
<td><%=bb1.getSno()%></td>
<td><%=bb1.getBname()%></td>
    <%}
    }
  %>
    </table>
    </center>
    
     <br/><br/>
  
   
<jsp:include page="Footer.jsp"></jsp:include>


</body></html>

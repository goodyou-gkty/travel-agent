<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.BusFormBean"%>
<%@page import="com.ewheelz.Dao.BusDAO"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<jsp:include page="Header.jsp"></jsp:include> 
                        
  
  <h1> WELCOME TO CANCLE BUS PAGE</h1>
  <center>
  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>
  
  </center>
<center>
  <body bgcolor="darkseagreen">

 <form action="./canclebus" method="post">
 <h2>SELECT BUSID TO WHICH U WANT TO CANCLE</h2>
 Select Here:<select name="id">
 <%
 Vector<BusFormBean> vbus=new BusDAO().selectBusId();
 Iterator it=vbus.listIterator();
 while(it.hasNext())
 {%>
<option><%BusFormBean bs=(BusFormBean)it.next();%></option>
<option value="<%=bs.getBusId()%>"><%=bs.getBname()%></option>

<% }
%>
</select>


 Click Here To Cancle Bus:<input type="submit" value="CANCLE BUS"></input>
 </form>
  <br/><br/>
  
   
<jsp:include page="Footer.jsp"></jsp:include>

</body></html>
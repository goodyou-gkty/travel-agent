<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.PickupFormBean"%>
<%@page import="com.ewheelz.Dao.PickupDAO"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<jsp:include page="Header.jsp"></jsp:include> 
                        
  
  <h1> WELCOME TO CANCLE PICKUP PAGE</h1>
  <center>
  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>
  
  </center>
<center>
  <body bgcolor="">

 <form action="./canclepickup" method="post">
 <h2>SELECT PICKUPID TO WHICH U WANT TO CANCLE</h2>
 Select Here:<select name="id">
 <%
 Vector<PickupFormBean> vbus=new PickupDAO().selectPickupId();
 Iterator it=vbus.listIterator();
 while(it.hasNext())
 {%>
<option><%PickupFormBean rb=(PickupFormBean)it.next();%></option>
<option value="<%=rb.getpid()%>"><%=rb.getPname()%> </option>

<% }
%>
</select>
<br/><br/>

 Click Here To Cancle Root:<input type="submit" value="CANCLE PICKUP POINT"></input>
 </form><br/><br/>
    
<jsp:include page="Footer.jsp"></jsp:include>
 

</body></html>
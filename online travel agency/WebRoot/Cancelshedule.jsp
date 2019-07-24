<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.SheduleFormBean"%>
<%@page import="com.ewheelz.Dao.SheduleDAO"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<body>
<jsp:include page="Header.jsp"></jsp:include> 
                        
  
  <h2> WELCOME TO BUSSHEDULE CANCLE BUS PAGE</h2>
  <center>
  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>
  
  </center>
<center>
  

 <form action="./CancelBusshedule" method="post">
 <h2>SELECT BUSID TO WHICH U WANT TO CANCLE</h2>
 Select Here:<select name="id">
 <%
 Vector<SheduleFormBean> vbus=new SheduleDAO().selectBusShedule();
 Iterator it=vbus.listIterator();
 while(it.hasNext())
 {%>
<option><%SheduleFormBean sb=(SheduleFormBean)it.next();%></option>
<option><%=sb.getBid()%></option>

<% }
%>
</select>

 Click Here To Cancle Bus:<input type="submit" value="CANCEl BUSSHEDULE" ></input>
 </form>
 <br/><br/><br/>


</body></html>

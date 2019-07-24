<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.RootFormBean"%>
<%@page import="com.ewheelz.Dao.RouteDAo"%>
<%@page import="com.ewheelz.Dao.BusDAO"%>
<%@page import="com.ewheelz.FormBean.BusFormBean"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>

</head>
 <body>         
 
 <jsp:include page="Header.jsp"></jsp:include><br/> 
 
 <center>
  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>
  <center>
                        
    <form action="./addpickup" method="post" name="pickup">
 
  <table border=2 cellspacing=3 color="red">
   
  <tr bgcolor="pink"><i><font color="">Add Pickup Point Here</font></i></tr>
   
   <tr><td><b><font color="#1E90FF">ROUTE NAME</font></b></td><td><select name="rid">
    <option>SELECT</option>
   <%
 Vector<RootFormBean> vroot=new RouteDAo().selectRouteId();
 Iterator it=vroot.listIterator();
 while(it.hasNext())
 {%>
<%RootFormBean rs=(RootFormBean)it.next();%>
<option value="<%=rs.getId()%>"><%=rs.getFrom()%>-To-<%=rs.getTo()%></option>

<% }
%>
   </select></td></tr><br/>
  <tr><td><b><font color="#1E90FF">BUS NAME</font></b></td><td><select name="bid">
  <option>SELECT</option>
 <%
 Vector<BusFormBean> vbus=new BusDAO().selectBusId();
 System.out.println("vector--------"+vbus);
 Iterator it1=vbus.listIterator();
 System.out.println("Itratortor--------"+it1);
 while(it1.hasNext())
 {%>
<%BusFormBean bs=(BusFormBean)it1.next();%>
 System.out.println("Itratortor--------"+it1);
<option value="<%=bs.getBusId()%>"><%=bs.getBname()%></option>

<% }
%>
<tr><td><b><font color="#1E90FF">Enter pickup point</font></b></td><td><input type=text" name="pname"/></td></tr>
<br/><br/>
   <tr><td><input type="submit" value="ADD PICKUP POINT"></input></td><td><input type="reset" value="clear"/></td></tr>
   
 
</table>
</form>

</center>

 <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("pickup");
  
 
  frmvalidator.addValidation("pname","req","Please enter Pointame");
  frmvalidator.addValidation("pname","alpha"," Pointame Alphabetic chars only");
  
  </script>
<br/>
<jsp:include page="Footer.jsp"></jsp:include> 


</body></html>
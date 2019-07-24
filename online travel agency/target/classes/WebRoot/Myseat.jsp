<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.BusFormBean"%>
<%@page import="com.ewheelz.Dao.BusDAO"%>
<%@page import="com.ewheelz.Dao.RouteDAo"%>
<%@page import="com.ewheelz.FormBean.RootFormBean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">

  <head>
  <script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
  <script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script>
  
  </head>
  
  
  <body bgcolor="">
  
  <jsp:include page="Header.jsp"></jsp:include>
  <br/>
 
 
 <form action="./SeatStorage" name="seat" method="post">
 <center>
 <table border=2 cellspacing=3 color="red">
 
 <tr bgcolor="#4682B4"><b><i>Shedule Buses Here</i></b></tr>
 <br/>
 
 <caption><b>Shedule Here</b></caption>
 
 <tr><td><b>EnterSeatNo</b></td><td><input type="text" name="seatno"></input></td></tr>

  
   <tr><td><b>RouteName<br /></b></td><td><select name="rid">
    <option>SELECT</option>
   <%
 Vector<RootFormBean> vroot=new RouteDAo().selectRouteId();
 Iterator it=vroot.listIterator();
 while(it.hasNext())
 {%>
<%RootFormBean rs=(RootFormBean)it.next();%>
<option value="<%=rs.getId()%>"><%=rs.getFrom()%>--To--<%=rs.getTo()%></option>

<% }
%>
   </select></td></tr>
   <tr><td><b>Select Bus</b></td><td><select name="busid">
    <option>SELECT</option>
 <%
 Vector<BusFormBean> vbus=new BusDAO().selectBusId();
 Iterator it1=vbus.iterator();

 while(it1.hasNext())
 {%>
<%BusFormBean sb=(BusFormBean)it1.next();%>
 

<option value="<%=sb.getBusId()%>"><%=sb.getBname()%></option>
 <%} %>
 </select></td></tr>
<tr>
    <td><pre><span class=Title><b>Date</b></span></pre></td>
    <td>
   <input type="text" name="dob" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.seat.dob', document.seat.dob.value);"> <img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
    <tr>

<tr><td><b>SELECT STATUS</b></td><td><select name="seatstatus">
    <option>SELECT</option>
<option>Active</option>
<option>InActive</option>
 
  </select></td></tr>
  <tr><td><input type="submit" name="submit" value="INSERT"></input></td></tr>
  
    </table>
    </center>
    </form>
    
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("seat");
  
 
  frmvalidator.addValidation("seatno","req","Please enter seatno");
  frmvalidator.addValidation("seatno","numeric");

   frmvalidator.addValidation("dob","req","Please enter DATE");
   
  
  
  </script>
    <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
                     


</body></html>
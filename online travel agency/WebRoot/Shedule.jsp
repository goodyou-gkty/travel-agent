<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.RootFormBean"%>
<%@page import="com.ewheelz.Dao.RouteDAo"%>
<%@page import="com.ewheelz.FormBean.BusFormBean"%>
<%@page import="com.ewheelz.Dao.BusDAO"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script>
</head>
  
  <body bgcolor="">
   <jsp:include page="Header.jsp"></jsp:include>
  <br/>
  <form action="./shedulebus" method="post" name="shedule">
   <center>
   <h4><i>WELCOME TO BUS SHEDULE PAGE</i></h4>
  
  <center>
  <table border=2 cellspacing=3>
   
   <tr><td><b>ROUTE NAME</b></td><td><select name="rid">
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
   </select></td></tr><tr></tr>
  <tr><td><b>BUS NAME</b></td><td><select name="bid">
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

<tr><td><b>SEAT COUNT</b></td><td><select name="sno">
<option>--SELECT--</option>
<%
 Vector<BusFormBean> vseat=new BusDAO().selectBusId();
 System.out.println("vector--------"+vbus);
 Iterator it2=vseat.listIterator();
 System.out.println("Itratortor--------"+it2);
 while(it2.hasNext())
 {%>
 <%BusFormBean bs=(BusFormBean)it2.next();%>
 System.out.println("Itratortor--------"+it2);
<option><%=bs.getSno()%></option>

<% }
%>




</td></tr>
<tr>
		<td>
	
	<b>Date</b>
	
	</td>
	<td>
<input type="text" name="date" value="" size="20" readonly="readonly" />
<a href="javascript:show_calendar('document.shedule.date', document.shedule.date.value);">
<img src="images/cal.gif" alt="a" width="18" height="18" border="0" /></a>
	</td>
	</tr>
<tr><td><b>Enter BusFair</b></td><td><input type="text" name="fair"/></td></tr>
<tr><td><b>DispatchingTime </b></td><td><input type="text" name="time"/></td></tr>

   <tr><td><input type="submit" value="SUBMIT"/></td> <td><input type="reset" value="clear"/></td></tr>
   
 
</table>
</center>
  
  
  </form>
  
  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("shedule");
  
  frmvalidator.addValidation("date","req","Please enter Date");
  frmvalidator.addValidation("fair","req","Please enter fair");
  frmvalidator.addValidation("fair","numeric");
  
  </script>
   <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>


</body></html>
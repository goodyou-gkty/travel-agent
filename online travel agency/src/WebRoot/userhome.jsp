
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.RootFormBean"%>
<%@page import="com.ewheelz.Dao.RouteDAo"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script>
</head>

	<jsp:include page="Header.jsp"></jsp:include>
               <br/>

	                                       

											<body bgcolor="">
											
												<h3>
												<center><i><font color="#4682B4">WELCOME TO RESERVATION PAGE</font></i></center>
												</h3>
													<center>
												<form action="./availability" name="register" method="post">
								
                 <table border="1">
   
   <tr><td><b>From</b></td><td><select name="userfrom">
    <option>SELECT</option>
		<%
		Vector<RootFormBean> vroot = new RouteDAo().selectRouteId();
      Iterator it = vroot.listIterator();
			while (it.hasNext()) 
			{RootFormBean rb = (RootFormBean) it.next();
			%>											
		
		<option><%=rb.getFrom()%></option>

	<%
	 }
	%>
	</select>
									
	</td></tr>
  <tr><td><b>To</b></td><td><select name="userto">
  <option>SELECT</option>											
  <%
 Vector<RootFormBean> vroot1 = new RouteDAo().selectRouteId();
	Iterator it2 = vroot1.listIterator();
	while (it2.hasNext())
	 {RootFormBean rb = (RootFormBean) it2.next();
	%>
	
	<option><%=rb.getTo()%></option>												
														
		<%
		}
		%>
	</select>																				
		<tr>
		<td>
	
	<b>Date</b>
	
	</td>
	<td>
<input type="text" name="dob" value="" size="20" readonly="readonly" />
<a href="javascript:show_calendar('document.register.dob', document.register.dob.value);">
<img src="images/cal.gif" alt="a" width="18" height="18" border="0" /></a>
	</td>
	</tr>

  <tr><td><b>BusType</b></td><td><select name="userbus">
  <option>SELECT</option>
<option>Any</option>
<option>ac</option>
<option>nonac</option>
<option>semiSleeper</option>
</select>
<br /><br />
<tr><td><b>No of Seats</b></td><td><select name="seatno">
  <option>SELECT</option>
  <option>1
											</option>
											<option>
												2
											</option>
											<option>
												3
											</option>
											<option>
												4
											</option>
											<option>
												5
											</option>
										</select>
									</td>

									
									<%
										String loginname = request.getParameter("username");
										session.setAttribute("uname", loginname);
									%>
									<tr>
										<td align="center">
											<input type="submit" value="CHECK FOR AVAILABILITY"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
											<input type="reset" value="clear"/>
										</td>
									</tr>
									
									
									
							</table>
							</form> <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
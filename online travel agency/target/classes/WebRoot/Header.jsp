<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  
  <body>
   <table align="center">
			<tr>
				<td colspan="1" width="1200" height="180" valign="top"><img src="<%=request.getContextPath()+"/images/bsb.jpg" %>" align="top" height="200" width="1200"/></td>
			</tr>
			<tr>
		
			
				<td colspan="1" width="1200" height="30"><center><u><font size="6" color="#457667"><b><i>Online Travel Service System</i></b></font></u></center></td>
			</tr>
			<tr>
				<td colspan="1" width="1200" height="1" ><img src="<%=request.getContextPath()+"/images/footer3.jpg.jpg"%>" height="12" width="1200"/></td>
			</tr>
		</table>
		  <table width="1000">
		
		<%if(session.getAttribute("role")!=null){
   				if (session.getAttribute("role").equals("admin"))
		
					{%>
					<jsp:include page="adminmenu.jsp"/>
							
					<%}
					else if (session.getAttribute("role").equals("user"))
					{%>
					
					<jsp:include page="Customeroptions.jsp"/>			
					<%}
				else {%>
						<jsp:include page="menubeforelogin.jsp"/>
					<%}
			}		
				else {%>
						<jsp:include page="menubeforelogin.jsp"/>
					<%}%>
		</table>
		<br/><br/>
		 <center>
		<% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>
		
		</center>
  </body>
</html>

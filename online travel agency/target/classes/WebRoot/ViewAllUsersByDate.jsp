<%@ page import ="com.dts.dae.dao.*,com.dts.dae.model.*" %>
<%@page import="java.util.Enumeration,com.dts.core.util.CoreHash"%>
<%@page import="com.dts.core.util.DateWrapper"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

                        
	<head>

		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
</style>
	</head>
	<body>
	<jsp:include page="Header.jsp"></jsp:include>
  <br/>

  <%String sdate=DateWrapper.parseDate(request.getParameter("fromdate"));
		   String edate=DateWrapper.parseDate(request.getParameter("todate")); %>
  <tr><strong><span class="style16"> Report Details From <%=sdate %> to <%=edate %><br/>
            <br/>
  </span></strong></tr>
  <tr>
    
    <td bgcolor="#E0FEFD"><div align="center" class="style16">LoginID</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">FirstName</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">LastName</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">Email</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">DOB</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">RegisterDate</div></td>
  </tr>
  <%int sno=1;
		   
		   CoreHash aCoreHash=new ProfileDAO().getReportFromTo(sdate,edate);
		   System.out.println(sdate+""+edate);
		   Enumeration e=aCoreHash.keys();
		   while(e.hasMoreElements())
		   {
		   Integer i=(Integer)e.nextElement();
		   Profile aProfile=(Profile)aCoreHash.get(i);
		   
		   %>
  
 <tr>
    
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getLoginID() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getFirstName() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getLastName() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getEmail() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getBirthDate() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getRegDate() %></div></td>
  </tr>
  <%} %>
  
  

  <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

</body></html>
  
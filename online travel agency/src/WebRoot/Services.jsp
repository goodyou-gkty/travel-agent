<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Services.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
<jsp:include page="Header.jsp"></jsp:include>
		
		<h3><font color="#1274c9"> Here is the services Provided By the      <font color="ashblu" size=""><b><i>Decentralization of    </i></b></font><font color="green" size=""><b><i>Travel Agency</i></b></font>  </font>
		</h3>
		<h4><font color="#1274c9">1.Maintaining All Routes Details of Ewheelz</font><br>
		    <font color="#1274c9">2.Maintaining All BusesInfo of Ewheelz</font><br/>
		    <font color="#1274c9">3.We can provide a services in a better way</font><br/>
		        
		    <font color="#1274c9">4.Providing a Facility to Reservea tickets in a Secured Manner</font><br/>
		     <font color="#1274c9">5.Providing a facility to cancel the tickets in Secure Manner</font>
		     ........................
		</h4>
		 <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>

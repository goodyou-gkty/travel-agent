<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
                        
	<head>
	
	<script type="text/javascript">
	function validator(){
	
	document.getElementById("pass").innerHTML="";
	document.getElementById("change").innerHTML="";
	
	if(document.getElementById("newpass").value==""){
        
document.getElementById("pass").innerHTML="Plz Enter Password";
return false;
	}
	else if(document.getElementById("new").value==""){
        
document.getElementById("pass").innerHTML="Plz Enter New Password";
return false;
	}

	}
	
	</script>
	<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
	</head>
<body>   



<jsp:include page="Header.jsp"></jsp:include>
                   <br/>   
      <center><span class=Title><h3>Change Password Form </h3></span></center>
      
      
    <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><%=request.getParameter("status")%></strong>
                      <%}%>
      
		<form id="form3" name="newedesignation" method="post"
			action="./ChangePasswordAction" onsubmit="return validator();">
			<table border="0" align="center">
				<tr>
					<td><span class=Title>
					  Login Name
					</span></td>
					<td>
						<input type="text" name="username" value="<%=session.getAttribute("user") %>" readonly />					</td>
				</tr>
				<tr>
					<td><span class=Title>
					  Old Password
					</span></td>
					<td>
						<input type="password" name="oldpassword" id="newpass"/><div id="pass"></div>					</td>
				</tr>
				<tr>
					<td><span class=Title>
					  New Password
					</span></td>
					<td>
						<input type="password" name="newpassword"   id="new" />	<div id="change"></div>				</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center"><strong>
						  <input type="submit" name="Submit" value="Change" />
						</strong></div>				  </td>
				</tr>
			</table>
		</form>
		<br/> <jsp:include page="Footer.jsp"></jsp:include>
</body></html>
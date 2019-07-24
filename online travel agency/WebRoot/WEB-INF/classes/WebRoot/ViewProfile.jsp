<%@ page import ="com.dts.dae.dao.*,com.dts.dae.model.*" %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>

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
        
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
	</head>
	<body>

<jsp:include page="Header.jsp"></jsp:include>
  <br/>
     
     <%
String name=(String)session.getAttribute("user");
String path=request.getRealPath("/userimages");
		Profile aprofile=new ProfileDAO().getProfile(name,path);

%>
     <br/>
     <p><br></p>
     <br/>
     <table width="403" height="116" bordercolor="#FEE8B6">
       <tr><strong><span class="Title1"><u>Personal  Details<br/>
                 <br/>
       </u></span></strong></tr>
       <tr>
         <td width="128" bgcolor="#FEE8B6"><strong><span class="style14 Title">FirstName</span></strong></td>
         <td width="366" bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getFirstname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>LastName</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getLastname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Dob</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getBdate()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Email</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getEmail()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Fax</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getFax()%></strong></span></td>
       </tr>
     </table>
     <p></p>


<table border="1" align="center" bordercolor="#000000" bgcolor="#CCCCCC" width="719" height="20%">
  <br/>
  <br/>
  <tr><strong><span class="Title"><u> Address Details<br/>
            <br/>
  </u></span></strong></tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Address Type </div>      </td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">HouseNo</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Street</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">City</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">State</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Country</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">PhoneNo</div></td>
  </tr>
  <%if(aprofile.getHome()!=null){ %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Home</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getHno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getStreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getState()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getPhone()%></span></td>
  </tr>
  <%}if(aprofile.getOffice()!=null){  %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Office</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOhno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOstreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOcity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOstate()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOcountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOphone()%></span></td>
  </tr>
  <%}if(aprofile.getContact()!=null){  %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Personal</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getChno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCstreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCcity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCstate()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCcountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCphone()%></span></td>
  </tr>
  <%} %>
</table>
<br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
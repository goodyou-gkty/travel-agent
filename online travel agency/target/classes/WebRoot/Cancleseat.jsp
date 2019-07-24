<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

          <head>

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>

</head>              
 

  <body bgcolor="">
  
 <jsp:include page="Header.jsp"></jsp:include>
 
 <form action="./Reserveseat.jsp" name="cancelseat">
  
  <center>
  <h4><i><font color="orange">CANCLE TICKET HERE</font></i></h4><BR/>
  
  <table border="1">
  <tr><td>
  
  Enter u r ReservationId<input type="text" name="resvid"></input>
</td>
</tr>
<tr></tr><tr></tr><tr></tr>
 <tr><td>
  <input type="submit" name="submit" value="GETSEAT"></input></td>
  </tr>
  </table>
  </center>
  
  
  
  
  </form>
  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("cancelseat");
  
 
  frmvalidator.addValidation("resvid","req","Please enter ReserveId");
  frmvalidator.addValidation("resvid","numeric");
  </script>
  <br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
</body></html>
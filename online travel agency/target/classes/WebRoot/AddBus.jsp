
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>

</head>

<body>
<jsp:include page="Header.jsp"></jsp:include>
<center>
   
   
   <form action="./addbus" method="post" name="addbus">
   <table border="1">
   
   <tr bgcolor="lightgreen"> Add Bus Here </tr><br/><br/>
   <tr><td> Ent Bus Name:<input type="text" name="busname"/></td></tr>
  <tr><td> Enter bus Type:<input type="text" name="type"/></td></tr>
  <tr><td> Available Seats:<input type="text" name="seats"/></td></tr>
   <tr align="left"><td><input type="submit" name="add" value="ADD BUS"/></td>
   <td align="left"><input type="reset" name="add" value="Clear"/></td>
   </tr>
   
   </table>
   </form>
   
   <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("addbus");
  
 
  frmvalidator.addValidation("busname","req","Please enter busname");
  frmvalidator.addValidation("busname","alpha"," busname Alphabetic chars only");
  
   frmvalidator.addValidation("type","req","Please enter Type");
   frmvalidator.addValidation("type","alpha"," Type Alphabetic chars only");
 
   
   frmvalidator.addValidation("seats","req","Please enter seats");
   frmvalidator.addValidation("seats","numeric");
  
  </script>
   </center>
   <br/><br/>
  
   
<jsp:include page="Footer.jsp"></jsp:include>

</body></html>

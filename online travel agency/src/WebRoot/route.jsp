

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
  <center>
  <form action="./addroute" name="register" method="post">
  
  
    <table border=1>
    
    
    <caption>Route Table</caption>
    
    
    	
    	<tr bgcolor="ashblue"><font><i>Add Route Here</i></font>
    	
    	</tr>
    	<br/>
    	<tr><td align="left">From:</td><td align="left"><input type="text" name="from"></td></tr>
    	<tr><td align="left">To:</td><td align="left"><input type="text" name="to"></input></td></tr>
    	<tr>
    <td align="left"><span class=Title>Date</span></td>
    <td align="left">
   <input type="text" name="dob" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.register.dob', document.register.dob.value);"> <img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a>
   </td>
  </tr>
    <tr>
    	<tr>
    <td align="left"><span class=Title>RootVia:</span></td>
    <td align="left">
  <input type="text" name="via"></input>
   </td>
  </tr>
   <tr><td align="center"><input type="submit" name="add" value="ADD ROUTE"/></td></tr>
    	
    	
    	</table> 
    	</form>
    	
    	
    	<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
 
  frmvalidator.addValidation("from","req","Please enter  From");
  frmvalidator.addValidation("from","alpha"," From Alphabetic chars only");
  
   frmvalidator.addValidation("to","req","Please enter TO");
   frmvalidator.addValidation("to","alpha"," TO Alphabetic chars only");
   frmvalidator.addValidation("dob","req","Please enter DATE");
   
   frmvalidator.addValidation("via","req","Please enter via");
   frmvalidator.addValidation("via","alpha"," via Alphabetic chars only");
  
  </script>
    	</center>
    	
    	<br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>



</body></html>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  <head>

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>

</head>         
<body>

       <jsp:include page="Header.jsp"></jsp:include>
      
        <form action="./LoginAction" method=post name="login">
        <table  border="0" align="center"  bgcolor="" width="80%">
               <tr>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center">
                   <tr align="center"><strong><h3><center>Login Form</center></h3></strong>
 	           </tr>
                   <tr>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center">
                   <tr>
                     <td >Username</td>
                      <td ><input type="text" name="username"/>                      </td>
                      </tr>
                    
                   <tr>
                     <td>Password</td>
                      <td>
                        <input type="password" name="password"/>                      </td>
                      </tr>
                   <tr>
                     <td colspan="2">
                       <div align="center">
                         <input type="submit" name="Submit" value="Sign In"/>
                          &nbsp;
                          <input name="Input2" type="reset" value="Clear"/>
                         </div>                        </td>
                      </tr>
                 </table></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td valign="baseline">
                 <div align="center"><a href="./Recoverpassword.jsp">Forgot Password ! ?......</a></div></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td valign="baseline">
                 <div align="center"><a href="./Registerform.jsp">New_User.....</a></div></td>
                 <td>&nbsp;</td>
               </tr>
             </table></td>
           </tr>
           </table>
                    </form>
                    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");
  
 
  frmvalidator.addValidation("username","req","Please enter username");
  frmvalidator.addValidation("password","req","Please enter password");

  
  </script>
                    
                    <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
                   


</body></html>
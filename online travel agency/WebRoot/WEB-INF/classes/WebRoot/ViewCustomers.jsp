
<%@ page import="java.util.*" %>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="com.dts.dae.model.Profile"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	  	
<jsp:include page="Header.jsp"></jsp:include>
                   <br/>
		
<center><h3><font color="teal"><b><i>View All Customers Details</b></font></h3></center>
   
  
      
     
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
       
       
       
	   
        
       
        <td width="110"><div align="center" class="style8"><b>FirstName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>LastName</b></div></td>
        
        
        <td width="64"><div align="center" class="style8"><b>Dob</b></div></td>
      <td width="110"><div align="center" class="style8"><b>Email</b></div></td>
        <td width="87"><div align="center" class="style8"><b>Fax</b></div></td>
        
        <td width="64"><div align="center" class="style8"><b>CustomerPicture</b></div></td>
        
      </tr>
      
     
      <%
             CoreList empInfo=(CoreList)request.getAttribute("FacultyInfo");
             System.out.println("in jsp ;;;;;;;;;;;;;;;"+empInfo);
             
             Iterator it=empInfo.listIterator();
             
             while(it.hasNext()){
        
                Profile pb=(Profile)it.next();
                %>
      <tr bgcolor="#CEC9FA" >
    
        
        
        <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=pb.getFirstname() %></div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7"><%=pb.getLastname() %></span></div></td>
        
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  <%=pb.getBdate() %></div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7"><%=pb.getEmail() %></div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7"><%=pb.getFax() %></span></div></td>
        <td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="userimages/<%=pb.getPhoto() %>" height="50" width="90"></p></td>
        
     </tr>
      <%} 
      
      if(empInfo.isEmpty()){
      %>
      
      
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    <%} %>
        
 </table>
 
 
 
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body>
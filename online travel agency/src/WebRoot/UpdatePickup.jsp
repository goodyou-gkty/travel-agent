<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.ewheelz.FormBean.PickupFormBean"%>
<%@page import="com.ewheelz.Dao.PickupDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

                        
  
  
  <body>
   <jsp:include page="Header.jsp"></jsp:include>
  <br/>
  <center>
  <h4><i>ENTER U R UPDATIONS HERE</i></h4>
  <%
  
  int pid=Integer.parseInt(request.getParameter("id"));

           Vector<PickupFormBean> vpb=new PickupDAO().ViewPickupAt(pid);
           
           Iterator it=vpb.listIterator();
      while(it.hasNext()){
       
       PickupFormBean pb=(PickupFormBean)it.next();
       
       %>
   <form action="./UpdatePickup">
   <table border="1">
   <tr><td>
   pointid<input type="text" name="pid" value="<%=pb.getpid() %>" readonly="readonly"/></td></tr>
  <tr><td> BusId:<input type="text" name="busid" value="<%=pb.getBid() %>"/></td></tr>
  <tr><td> Routeid<input type="text" name="routeid" value="<%=pb.getRid() %>"/></td></tr>
   <tr><td>Point Name:<input type="text" name="pname" value="<%=pb.getPname() %>"/></td></tr><tr></tr>
  <tr><td> <input type="submit" name="update" value="UPDATE"/></td></tr>
   <%} %>
   </table>
   </form>
   
   </center> <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>
        
                     


</body></html>
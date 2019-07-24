<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.ewheelz.FormBean.SeatFormBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
<script language="JavaScript" type="text/javascript">
    
function validate(){
document.getElementById("sid").style.color="red";
document.getElementById("sid").style.backgroundColor="green";
}
function show_alert() { 

var msg = "THIS SEAT IS ALREADY RESERVED";
alert(msg); 
}
function seatReserve(sno){

 
alert("you have choosen:"+sno);
window.location.href="./Reservation?seatno="+sno;

}

    </script>
   </head>
	

	<body bgcolor="">
	 <jsp:include page="Header.jsp"></jsp:include>
  <br/>
		<form action="">
		
			<center>
				<%
					Vector<SeatFormBean> vbus = (Vector<SeatFormBean>) request.getAttribute("seatvect");
					Iterator it = vbus.listIterator();
					SeatFormBean sb1 = null;
					String seatstatus = null;
					int seatno = 0;
					while (it.hasNext()) {

						sb1 = (SeatFormBean) it.next();
						seatstatus = sb1.getStatus();
						seatno = sb1.getSeatno();
						System.out.println("injsp"+seatstatus);
						System.out.println("injsp"+sb1.getSeatId());
				
				%>
				<%
					if (seatstatus.equalsIgnoreCase("active")) {
				%>
				<input type="button" id="sid" name="seatno" value="<%=sb1.getSeatId()%>"   style=" background-color: green" onclick="seatReserve(this.value);"  />
				<%
					} else if (seatstatus.equalsIgnoreCase("inactive")) {
				%>
				<input type="button" name="seatid" value="<%=sb1.getSeatId()%>" style=" background-color: red" onclick="show_alert();" />
				<%
					}
					}
				%>
				
				
			</center>






		</form><br/><br/><br/>
		
		Reserved:<input type="button" name="seatno" value="" style="width:200; height:200; background-color: red"/>
       <br/><br/>
      UnReserved:<input type="button" name="seatno" value="" style="width:200; height:200; background-color: green"/>
        <br/><br/>
                    
                 <jsp:include page="Footer.jsp"></jsp:include>

                     


</body></html>
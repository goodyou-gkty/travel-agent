package com.ewheelz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.ewheelz.FormBean.ReservationFormBean;

public class ReserveDAO extends AbstractDataAccessObject{
	
    String reserve,cancle;
    Connection con;
	PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
     int num;
    
public int addBusShedule(ReservationFormBean rb) throws Exception{

	 int userid=0;
		con=getConnection();
		stmt=con.createStatement();
		System.out.println("inside DAO class");
	String login=rb.getLoginid();
	System.out.println("in DAo loginid"+login);
		rs=stmt.executeQuery("select userid from userdetails where loginid="+"'"+login+"'"+"");
		System.out.println("query executed");
		while(rs.next()){
			//System.out.println("result"+rs.next());
			userid=rs.getInt(1);
			System.out.println("userid in resultset ......."+userid);
			
		}
		
		
	pstmt=con.prepareStatement("insert into reservation values((select nvl(max(resvid),0)+1 from reservation),?,?,?,?,?,?,?)");
	System.out.println("prepared ststement executed");
	String btype=rb.getBtype();
	System.out.println("inprepared- btype-----"+btype);
	String ufrom=rb.getUfrom();
	System.out.println("in prepared frommmmm...."+ufrom);
	String uto=rb.getUto();
	System.out.println("inprepared to ............"+uto);
	String udate=rb.getUdate();
	System.out.println("inprepared date;;;;;;;;;;"+udate);
	pstmt.setInt(1,userid );
	System.out.println("inprepared/////////////"+userid);
	int resvsaet=rb.getSeatno();
	int bsno=rb.getBusid();
	pstmt.setString(2, ufrom);
	pstmt.setString(3,uto);
	pstmt.setString(4,DateWrapper.parseDate(udate));
	pstmt.setString(5,btype);
	pstmt.setInt(6,bsno);
	pstmt.setInt(7, resvsaet);
	System.out.println("data readed from bean class");
	int no=pstmt.executeUpdate();
	
      int seatno=rb.getSeatno();
      
       int update=stmt.executeUpdate("update busseats set status='inactive' where seatno="+seatno+" and busid="+bsno);
   	       System.out.println("row is updated"+update);
	return no;


}

	public int reserveSeat(ReservationFormBean rb) throws Exception
	{    
		con=getConnection();
		int n=rb.getSeatno();
	stmt=con.createStatement();
	      rs=stmt.executeQuery("select seatcount from busshedule");
	      
	      if(reserve.equalsIgnoreCase("reserve")){      
	     int count=rs.getInt(1);
	      count=count-n;
	      System.out.println("no of seats"+count);
	      String ufrom=rb.getUfrom();
	  	String uto=rb.getUto();
	  	String udate=rb.getUdate();
	      pstmt=con.prepareStatement("update table busshedule set seatcount=count where rid in(select rid from routedetails where from1=? and to1=? and doj=?");
	      pstmt.setString(1,ufrom);
	      pstmt.setString(1,uto);
	      pstmt.setString(1,udate);
	      int num=pstmt.executeUpdate();
	      }
	     
	      return num;  
	}
	    	  
	   public int cancleSeat(ReservationFormBean rb)throws Exception{
		   int update=0;
		   con=getConnection();
		   int seatno=rb.getSeatno();
			System.out.println("in dao seat no issssssss "+seatno);
			int busid=rb.getBusid();
			System.out.println("in DAO busid is"+busid);
			int resvid=rb.getReservid();
			System.out.println("in DAO reservationid is"+resvid);
			
			stmt=con.createStatement();
		    int delete= stmt.executeUpdate("delete from reservation where resvid="+resvid);
	   System.out.println("no of seats deleted"+delete);
	   
	   if(delete>0){
		 
			pstmt=con.prepareStatement("update busseats set status='active' where seatno=? and busid=?");
			
		
			pstmt.setInt(1, seatno);
			pstmt.setInt(2,busid );
			      
			   update=pstmt.executeUpdate();
			   
			   System.out.println("in ReserveDAo........update is//////.."+update);
			   
			   
	   }
			   
			   
			     
	  
	     
	     return  update;
	      
	  
	   }
	   
	   public Vector<ReservationFormBean> selectReservation(String uid)throws Exception
		{
			con=getConnection();
			System.out.println("con--------"+con);
		stmt=con.createStatement();
		
		System.out.println("stmt---------"+stmt);
	//int uid=rb1.getUserid();
	//System.out.println("in  ..........."+uid);
	        rs=stmt.executeQuery("select * from reservation where userid=(select userid from userdetails where loginid='"+uid+"')");
	        
	        Vector<ReservationFormBean> vresrv=new Vector<ReservationFormBean>();
	        while(rs.next())
	        {
	        	ReservationFormBean rb=new ReservationFormBean();
	        	int rid=rs.getInt(1);
	        int userid=rs.getInt(2);
	        	String from=rs.getString(3);
	        	String to=rs.getString(4);
	        	String date=rs.getString(5);
	        	String btype=rs.getString(6);
	        	int bsno=rs.getInt(7);
	        	int seatno=rs.getInt(8);
	        	rb.setBtype(btype);
	        	rb.setBusid(bsno);
	        	rb.setUfrom(from);
	        	rb.setUto(to);
	        	rb.setUdate(date);
	        	rb.setUserid(userid);
	        	rb.setReservid(rid);
	             rb.setSeatno(seatno);
	        	vresrv.add(rb);
	        	}
	        return vresrv;
		}
	   
	   
	   public Vector<ReservationFormBean> getSeat(ReservationFormBean rb1) throws SQLException
	   {
		   con=getConnection();
		  pstmt=con.prepareStatement("select * from reservation where resvid=?");
		  
		  int resvid=rb1.getReservid();
		  System.out.println("indao reservid isssss"+resvid);
		   pstmt.setInt(1, resvid);
		   rs=pstmt.executeQuery();
		   System.out.println("query executed");
		   Vector<ReservationFormBean> vresrv=new Vector<ReservationFormBean>();
		   while(rs.next())
		   {
			   ReservationFormBean rb=new ReservationFormBean();
			   int rid=rs.getInt(1);
			   System.out.println("in resultset rid"+rid);
		        int userid=rs.getInt(2);
		        System.out.println("in result set usid"+userid);
		        	String from=rs.getString(3);
		        	String to=rs.getString(4);
		        	String date=rs.getString(5);
		        	String btype=rs.getString(6);
		        	System.out.println("inresult set bustype"+btype);
		        	int bsno=rs.getInt(7);
		        	System.out.println("in result set bsno"+bsno);
		        	int seatno=rs.getInt(8);
		        	rb.setBtype(btype);
		        	System.out.println("bustype is set into bean");
		        	rb.setBusid(bsno);
		        	rb.setUfrom(from);
		        	System.out.println("from set in to bean"+from);
		        	rb.setUto(to);
		        	rb.setUdate(date);
		        	rb.setUserid(userid);
		        	rb.setReservid(rid);
		             rb.setSeatno(seatno);
		        	vresrv.add(rb);
		        	}
		        return vresrv;
		   }
	
	
	   }


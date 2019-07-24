package com.ewheelz.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.ewheelz.FormBean.SeatFormBean;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class SeatDAO extends AbstractDataAccessObject implements Serializable{

	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public  Vector<SeatFormBean> getSeatNo(SeatFormBean sb)throws Exception
	{
		
		Vector<SeatFormBean> vsbus=null;
		
		try{
			
			
		
		con=getConnection();
	System.out.println("in get seatDAO");
	pstmt=con.prepareStatement("select bd.seatno,b.seatno,b.status from busdetails bd,busseats b,busshedule bs where  b.busid=bd.busid and bd.busid=? and bs.sdate=? and b.resvdate=? ");
		System.out.println("prepared executed"+pstmt);
	int bservno=sb.getBid();
	System.out.println("bus rev no...."+bservno);
	String rdate=sb.getDate();
	System.out.println("in DAo classs,,,,,,,,,,,,,,date is......"+rdate);
	pstmt.setInt(1, bservno);
	pstmt.setString(2, DateWrapper.parseDate(rdate));
	
	pstmt.setString(3, DateWrapper.parseDate(rdate));
	rs=pstmt.executeQuery();
			
	 vsbus=new Vector<SeatFormBean>();
	
	
    while(rs.next())
    {   SeatFormBean sb1=new SeatFormBean(); 
    	
    	int bsno=rs.getInt(1);
    	int seatid=rs.getInt(2);
    	String seatstatus=rs.getString(3);
		sb1.setSeatId(seatid);
    	sb1.setStatus(seatstatus);
		sb1.setSeatno(bsno);
		vsbus.add(sb1);
	}
		}catch (SQLException e) {
			e.printStackTrace();
		}
    System.out.println("vector ....."+vsbus);
    return vsbus;
}
	
	
	public int conformSeat(SeatFormBean sb) throws Exception{
		con=getConnection();
		
	pstmt=con.prepareStatement("insert into busseats values(?,?,?,?,?)");
	int sno=sb.getSeatId();
	System.out.println("indao seatno"+sno);
	int bsno=sb.getBid();
	System.out.println("in dao"+bsno);
	String date=sb.getDate();
	System.out.println("indao"+date);
	String status=sb.getStatus();
	System.out.println("in dao status"+status);
	int rid=sb.getRid();
	pstmt.setInt(1, sno);
	pstmt.setInt(2, bsno);
	pstmt.setString(3, DateWrapper.parseDate(date));
	pstmt.setString(4,status);
	pstmt.setInt(5, rid);
int insert=pstmt.executeUpdate();
	
	return insert;
	
		
	
	}
	
	
	public Vector<SeatFormBean> getSeat()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select seatno,busid,TO_CHAR(resvdate,'DD-MM-YYYY'),status from busseats");
        Vector<SeatFormBean> vseat=new Vector<SeatFormBean>();
        while(rs.next())
        {
        	SeatFormBean sb=new SeatFormBean();
        	int seatno=rs.getInt(1);
        	int bsno=rs.getInt(2);
        	String date=rs.getString(3);
        	String status=rs.getString(4);
        	sb.setBid(bsno);
        	sb.setSeatId(seatno);
        	sb.setDate(date);
        	sb.setStatus(status);
        	vseat.add(sb);
        
        	}
        return vseat;
	}
	
	
}

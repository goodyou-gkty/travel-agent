package com.ewheelz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.ewheelz.FormBean.SheduleFormBean;

public class SheduleDAO extends AbstractDataAccessObject{
      
	
        Connection con;
    	PreparedStatement pstmt;
	    Statement stmt;
	    ResultSet rs;

	public int addBusShedule(SheduleFormBean sb) throws Exception{
	
			con=getConnection();
		pstmt=con.prepareStatement("insert into busshedule values(?,?,?,?,?,?)");
		int bid=sb.getBid();
		int rid=sb.getRid();
		int sno=sb.getSc();
		int bfair=sb.getBfair();
		String time=sb.getTime();
		String date=sb.getSdate();
		pstmt.setInt(1,bid);
		pstmt.setInt(2,rid);
		pstmt.setInt(3,sno);
		pstmt.setInt(4,bfair);
		
		pstmt.setString(5, DateWrapper.parseDate(date));
		pstmt.setString(6, time);
		
		System.out.println("data readed from bean class");
		int no=pstmt.executeUpdate();
		
		
	
		return no;
	
	
	}
	

	public Vector<SheduleFormBean> selectBusShedule()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select * from busshedule");
        Vector<SheduleFormBean> vebus=new Vector<SheduleFormBean>();
        while(rs.next())
        {
        	SheduleFormBean sb=new SheduleFormBean();
        	int bid=rs.getInt(1);
        	int rid=rs.getInt(2);
        	int sno=rs.getInt(3);
        	int bfair=rs.getInt(4);
        	String date=rs.getString(5);
        	String time=rs.getString(6);
        	sb.setBid(bid);
        	sb.setRid(rid);
        	sb.setSc(sno);
            sb.setBfair(bfair);
            sb.setSdate(date);
            sb.setTime(time);
        	vebus.add(sb);
        	}
        return vebus;
	}
public int deleteShedule(SheduleFormBean sb)throws Exception{
		
		
		
		con=getConnection();
	pstmt=con.prepareStatement("delete from busshedule where busid=?");
	int id=sb.getBid();
	pstmt.setInt(1, id);
	System.out.println("data readed from bean class");
	int del=pstmt.executeUpdate();
	return del;	
	
	
	
	}


public int updateShedule(SheduleFormBean rb)throws Exception{
		
		
		System.out.println("i am update method");
		con=getConnection();
	pstmt=con.prepareStatement("update busshedule set rid=? ,seatcount=? ,busfair=?,dtime=? where busid=?");
	int bid=rb.getBid();
	System.out.println("id in update---"+bid);
	int seat=rb.getSc();
	System.out.println("seat"+seat);
	int rid=rb.getRid();
	System.out.println("id----"+rid);
	int bfair=rb.getBfair();
	System.out.println("fair........."+bfair);
	
	String time=rb.getTime();
	pstmt.setInt(1, rid);
	pstmt.setInt(2, seat);
	pstmt.setInt(3,bfair);
	pstmt.setString(4, time);
	pstmt.setInt(5, bid);
	System.out.println("data readed from bean class");
	int update=pstmt.executeUpdate();
	return update;	
	
}
}




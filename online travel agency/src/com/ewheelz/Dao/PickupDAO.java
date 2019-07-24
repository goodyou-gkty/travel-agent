package com.ewheelz.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.dts.core.dao.AbstractDataAccessObject;
import com.ewheelz.FormBean.PickupFormBean;

public class PickupDAO extends AbstractDataAccessObject{

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public int addPickupPoint(PickupFormBean pb) throws Exception{
	
			con=getConnection();
		pstmt=con.prepareStatement("insert into pickuppoint values((select max(pid)+1 from pickuppoint),?,?,?)");
		String pointname=pb.getPname();
		int bid=pb.getBid();
		int rid=pb.getRid();
		pstmt.setInt(1,bid);
		pstmt.setInt(2,rid);
		pstmt.setString(3,pointname );
		System.out.println("data readed from bean class");
		int no=pstmt.executeUpdate();
		
		
	
		return no;
	
	
	}
	public Vector<PickupFormBean> selectPickupId()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select * from pickuppoint");
        Vector<PickupFormBean> vebus=new Vector<PickupFormBean>();
        while(rs.next())
        {
        	PickupFormBean rb=new PickupFormBean();
        	int id=rs.getInt(1);
        	int bid=rs.getInt(2);
        	int rid=rs.getInt(3);
        	String pname=rs.getString(4);
        	rb.setpid(id);
        	rb.setBid(bid);
        	rb.setRid(rid);
        	rb.setPname(pname);
        	vebus.add(rb);
        	}
        return vebus;
	} 
	
	
	
	public Vector<PickupFormBean> ViewPickupAt(int pid)throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select * from pickuppoint where pid="+pid);
        Vector<PickupFormBean> vebus=new Vector<PickupFormBean>();
        while(rs.next())
        {
        	PickupFormBean rb=new PickupFormBean();
        	int id=rs.getInt(1);
        	int bid=rs.getInt(2);
        	int rid=rs.getInt(3);
        	String pname=rs.getString(4);
        	rb.setpid(id);
        	rb.setBid(bid);
        	rb.setRid(rid);
        	rb.setPname(pname);
        	vebus.add(rb);
        	}
        return vebus;
	} 
	
	
	
	public int deletePickup(PickupFormBean rb)throws Exception{
		
		
		
		con=getConnection();
	pstmt=con.prepareStatement("delete from pickuppoint where pid=?");
	int id=rb.getpid();
	pstmt.setInt(1, id);
	System.out.println("data readed from bean class");
	int del=pstmt.executeUpdate();
	con.setAutoCommit(true);
	return del;


}

public int updateBus(PickupFormBean rb)throws Exception{
		
		
		System.out.println("i am update method");
		con=getConnection();
	pstmt=con.prepareStatement("update pickuppoint set bid=? ,rid=? ,pointname=? where pid=?");
	int pid=rb.getpid();
	System.out.println("id in update---"+pid);
	String pname=rb.getPname();
	int rid=rb.getRid();
	int bid=rb.getBid();
	pstmt.setInt(1, bid);
	pstmt.setInt(2, rid);
	pstmt.setString(3,pname);
	pstmt.setInt(4, pid);
	System.out.println("data readed from bean class");
	int update=pstmt.executeUpdate();
	return update;	
	
}
	
	
}

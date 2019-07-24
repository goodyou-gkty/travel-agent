package com.ewheelz.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.ewheelz.FormBean.RootFormBean;


public class RouteDAo extends AbstractDataAccessObject{
	Connection con;
	int del ,rows;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	public int addRoute(RootFormBean rb)throws Exception{
			con=getConnection();
		pstmt=con.prepareStatement("insert into routedetails values((select max(rid)+1 from routedetails),?,?,?,?)");
		String from=rb.getFrom();
		System.out.println("from----------"+from);
		String date=rb.getDate();
		System.out.println("date-----"+date);
		String to=rb.getTo();
		System.out.println("to--------"+to);
		String via=rb.getVia();
		System.out.println("via------"+via);
		pstmt.setString(1, from);
		pstmt.setString(2, to);
		pstmt.setString(3, DateWrapper.parseDate(date));
		pstmt.setString(4, via);
		System.out.println("data readed from bean class");
		int no=pstmt.executeUpdate();
		con.setAutoCommit(true);
			return no;
		
	}

	public Vector<RootFormBean> selectRouteId()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select rid,from1,to1, to_char(doj,'dd-mm-yy'),rvia from routedetails");
        Vector<RootFormBean> vebus=new Vector<RootFormBean>();
        while(rs.next())
        {
        	RootFormBean rb=new RootFormBean();
        	int id=rs.getInt(1);
        	String rfrom=rs.getString(2);
        	String rto=rs.getString(3);
        	String date=rs.getString(4);
        	String rvia=rs.getString(5);
        	rb.setId(id);
        	rb.setFrom(rfrom);
        	rb.setTo(rto);
        	rb.setDate(date);
        	rb.setVia(rvia);
        	vebus.add(rb);
        
        	}
        return vebus;
	}
	
	
	
	public int deleteRoute(RootFormBean rb)throws Exception{
		
		
		
			con=getConnection();
		pstmt=con.prepareStatement("delete from routedetails where rid=?");
		int id=rb.getId();
		pstmt.setInt(1, id);
		System.out.println("data readed from bean class");
		int del=pstmt.executeUpdate();
		return del;
	

}
	
	public int getCount()throws Exception
	{     
		con=getConnection();
		pstmt=con.prepareStatement("select count(*) from routedetails");
		rs=pstmt.executeQuery();
		while(rs.next()){
		 rows=rs.getInt(1);
		System.out.println("rowsssss"+rows);
		}
		return rows;
		
		
	}
	
	
public int updateRoute(RootFormBean rb)throws Exception{
		
		
		System.out.println("i am update method");
		con=getConnection();
	pstmt=con.prepareStatement("update routedetails set from1=?,to1=?,doj=?,rvia=? where rid=?");
	int id=rb.getId();
	System.out.println("id in update---"+id);
	String rfrom=rb.getFrom();
	System.out.println("from-"+rfrom);
	String to=rb.getTo();
	System.out.println("tooo-"+to);
	String date=rb.getDate();
	System.out.println( "in routeDAO"+date);
	String rvia=rb.getVia();
	System.out.println("via----"+rvia);
	pstmt.setString(1, rfrom);
	pstmt.setString(2, to);
	pstmt.setString(3, DateWrapper.parseDate(date));
	pstmt.setString(4, rvia);
	pstmt.setInt(5, id);
	System.out.println("data readed from bean class");
	int update=pstmt.executeUpdate();
	return update;	
	
}
}

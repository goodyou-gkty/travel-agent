package com.ewheelz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.ewheelz.FormBean.BusFormBean;
import com.ewheelz.FormBean.CheckFormBean;

public class CheckDAO extends AbstractDataAccessObject
{

	
	
	
	Connection con;
	int del;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	public Vector<BusFormBean> getBus(CheckFormBean cb)throws Exception
	{
		
			con=getConnection();
		String from=cb.getFrom();
		System.out.println("from----------"+from);
		String date=cb.getDate();
		System.out.println("date-----"+date);
		String to=cb.getTo();
		System.out.println("to--------"+to);
	
		String btype=cb.getBtype();
		System.out.println("btype---------"+btype);
		System.out.println("data readed from bean class");
		
		
		if(btype.equalsIgnoreCase("any"))
		{
			String 	query="select distinct bd.busid,bd.bustype,bd.bname,bs.busfair,bs.dtime from busdetails bd, busshedule bs where bs.rid in(select rid from routedetails where from1=? and upper(to1)=upper(?)) and bs.sdate=?";
		       System.out.println("iniffffffff control");
			pstmt=con.prepareStatement(query);      
		pstmt.setString(1, from);
		pstmt.setString(2, to);
		pstmt.setString(3, DateWrapper.parseDate(date));
		}
		else if(btype.equalsIgnoreCase("ac")||btype.equalsIgnoreCase("nonac")||btype.equalsIgnoreCase("semi-sleeper"))
			{
			System.out.println("control comes here");
//			String 	query1="select distinct bd.busid,bd.bustype,bd.bname,bs.busfair,bs.dtime from busdetails bd, busshedule bs where  bs.rid in(select rid from routedetails where from1=? and upper(to1)=upper(?)) and bs.to_date(sdate,'dd-mon-yy')=? nd bd.bustype=?";
			/*Statement stmt=con.createStatement();
			rs=stmt.executeQuery(query1);*/
			
			pstmt=con.prepareStatement("select distinct bd.busid,bd.bustype,bd.bname, bs.busfair,bs.dtime from busdetails bd, busshedule bs where bs.rid in(select rid from routedetails where from1=? and upper(to1)=upper(?)) and bs.sdate=? and bd.bustype=?");
	
			pstmt.setString(1,from);
			System.out.println("inelse from--------"+from);
			pstmt.setString(2,to);
			System.out.println("inelse to----"+to);
			pstmt.setString(3, DateWrapper.parseDate(date));
			System.out.println("inelse date........."+date);
			pstmt.setString(4,btype);
			System.out.println("inelse bustype,,,,,,,,,,,"+btype);
			
		}
			rs=pstmt.executeQuery();
			System.out.println("resuleset"+rs);
			
			System.out.println("data inserted in to preparedstatement");
			System.out.println("vector object created");
			Vector<BusFormBean> vebus=new Vector<BusFormBean>();
			System.out.println("vector---...."+vebus);
			/*boolean flag=rs.next();
			System.out.println("flagg...."+flag);*/
			
			//System.out.println("resulet"+rs.next());
			
		   while(rs.next())
		    {
		           System.out.println("resule set"+rs);
		    
		    	BusFormBean bs=new BusFormBean();
		    	int id=rs.getInt(1);
		    	String btype1=rs.getString(2);
		    	String bname=rs.getString(3);
		    	int bfair=rs.getInt(4);
		    	String time=rs.getString(5);
		    	bs.setBtype(btype1);
		    	System.out.println("bus type"+btype);
		    	bs.setBusId(id);
		    	System.out.println("busid "+id);
		    	bs.setBname(bname);
		    	System.out.println("bus name"+bname);
		    	bs.setBfair(bfair);
		    	System.out.println("busfair  ..........."+bfair);
		    	bs.setTime(time);
		    	vebus.add(bs);
		    }
		   
			
		   
		    return vebus;
			
	}
		
		
		
		 
		
	
}


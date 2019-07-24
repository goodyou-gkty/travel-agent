package com.ewheelz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.dts.core.dao.AbstractDataAccessObject;
import com.ewheelz.FormBean.FairFormBean;

public class FairDAO extends AbstractDataAccessObject{

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	
	public int addFair(FairFormBean fb) throws Exception{
	
	
		con=getConnection();
		pstmt=con.prepareStatement("insert into busfair values(?,?,?)");
		int bid=fb.getBid();
		System.out.println("in DAO busid"+bid);
		int rid=fb.getRid();
		System.out.println("in DAO routeid"+rid);
		int famt=fb.getFamt();
		System.out.println("in DAO fairrrrrrrrrrr"+famt);
		pstmt.setInt(1,bid);
		pstmt.setInt(2,rid);
		pstmt.setInt(3,famt);
		System.out.println("data readed from bean class");
		int no=pstmt.executeUpdate();
		
		
	
		return no;
	
	
	}
	
	public Vector<FairFormBean> selectFair()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select * from busfair");
        Vector<FairFormBean> vfair=new Vector<FairFormBean>();
        while(rs.next())
        {
        	FairFormBean fb=new FairFormBean();
        	int bid=rs.getInt(1);
        	int rid=rs.getInt(2);
        	int famt=rs.getInt(3);
        	
        	fb.setBid(bid);
        	fb.setRid(rid);
        	fb.setFamt(famt);
        	vfair.add(fb);
        	}
        return vfair;
	} 
	
	public Vector<FairFormBean> getFair()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	pstmt=con.prepareStatement("select bf.fair from busfair bf where bf.busid in ");
	
	
	return null;
	}
	
	
public int deleteFair(FairFormBean fb)throws Exception{
		
		
		
		con=getConnection();
	pstmt=con.prepareStatement("delete from busfair where busid=?");
	int id=fb.getBid();
	pstmt.setInt(1, id);
	System.out.println("data readed from bean class");
	int del=pstmt.executeUpdate();
	con.setAutoCommit(true);
	return del;


}

public int updateFair(FairFormBean fb)throws Exception{
		
		
		System.out.println("i am update method");
		con=getConnection();
	pstmt=con.prepareStatement("update busfair set fair=? where busid=? and routeid=?");
	

	int famt=fb.getFamt();
	int rid=fb.getRid();
	int bid=fb.getBid();
	pstmt.setInt(1, famt);
	pstmt.setInt(2, bid);
	pstmt.setInt(3, rid);
	System.out.println("data readed from bean class");
	int update=pstmt.executeUpdate();
	return update;	
	
}

}

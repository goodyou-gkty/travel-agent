package com.ewheelz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Vector;

import com.dts.core.dao.AbstractDataAccessObject;
import com.ewheelz.FormBean.BusFormBean;

public class BusDAO extends AbstractDataAccessObject{

	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
 Statement stmt;
	public int addBus(BusFormBean bb) throws Exception{
			con=getConnection();
		pstmt=con.prepareStatement("insert into busdetails values((select nvl(max(busid),1000)+1 from busdetails),?,?,?)");
		String btype=bb.getBtype();
		System.out.println("btype......"+btype);
		int sno=bb.getSno();
		System.out.println("sno..........."+sno);
		String bname=bb.getBname();
		System.out.println("bname......."+bname);
		pstmt.setString(1, btype);
		pstmt.setInt(2,sno);
		pstmt.setString(3, bname);
		System.out.println("data readed from bean class");
		 int num=pstmt.executeUpdate();
		 System.out.println(num);
		 con.setAutoCommit(true);
		
		return num;
	
}
	
	
	
	public Vector<BusFormBean> selectBusId()throws Exception
	{
		con=getConnection();
		System.out.println("con--------"+con);
	stmt=con.createStatement();
	
	System.out.println("stmt---------"+stmt);
        rs=stmt.executeQuery("select * from busdetails");
        Vector<BusFormBean> vebus=new Vector<BusFormBean>();
        while(rs.next())
        {
        	BusFormBean bs=new BusFormBean();
        	int id=rs.getInt(1);
        	String btype=rs.getString(2);
        	int sno=rs.getInt(3);
        	bs.setBtype(btype);
        	bs.setBusId(id);
        	bs.setSno(sno);
        	bs.setBname(rs.getString("bname"));
        	vebus.add(bs);
        	}
        return vebus;
	}
	
	
	public int deleteBus(BusFormBean rb)throws Exception{
		
		
		
		con=getConnection();
	pstmt=con.prepareStatement("delete from busdetails where busid=?");
	int id=rb.getBusId();
	pstmt.setInt(1, id);
	System.out.println("data readed from bean class");
	int del=pstmt.executeUpdate();
	return del;	
	
	
	
	}
public int updateBus(BusFormBean rb)throws Exception{
		
		
		System.out.println("i am update method");
		con=getConnection();
	pstmt=con.prepareStatement("update busdetails set bustype=? ,seatno=? ,bname=? where busid=?");
	int id=rb.getBusId();
	System.out.println("id in update---"+id);
	String bname=rb.getBname();
	int seat=rb.getSno();
	String type=rb.getBtype();
	System.out.println("id----"+id);
	pstmt.setString(1, type);
	pstmt.setInt(2, seat);
	pstmt.setString(3,bname);
	pstmt.setInt(4, id);
	System.out.println("data readed from bean class");
	int update=pstmt.executeUpdate();
	return update;	
	
}
	
}

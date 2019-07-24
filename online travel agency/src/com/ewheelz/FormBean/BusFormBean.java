package com.ewheelz.FormBean;

import java.io.Serializable;

public class BusFormBean implements Serializable{

	private String btype;
	private int sno,bid,bfair;
	private String bname,time;
	public BusFormBean(){
	}
	

	public void setBusId(int bid)
	{
		this.bid=bid;
	}
	

	public int getBusId()
	{
		return bid;
	}	
	
public void setBtype(String btype)
{
	this.btype=btype;
}
public void setSno(int sno)
{
	this.sno=sno;
}

public String getBtype()
{
	return btype;
}

public int getSno()
{
	return sno;
}
public void setBname(String bname) {
	this.bname=bname;
	
}
public String getBname()
{
	return bname;
}


public int getBfair() {
	return bfair;
}


public void setBfair(int bfair) {
	this.bfair = bfair;
}


public int getBid() {
	return bid;
}


public void setBid(int bid) {
	this.bid = bid;
}


public String getTime() {
	return time;
}


public void setTime(String time) {
	this.time = time;
}



}

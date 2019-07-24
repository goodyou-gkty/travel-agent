package com.ewheelz.FormBean;

import java.sql.Date;

public class RootFormBean  implements java.io.Serializable{
	
	private  int rid;
	private String from;
	private String to;
	private String rvia;
	private String date;
	private Date date1;
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public RootFormBean(){
	}
public void setId(int rid)
	{
		this.rid=rid;
	}
public void setFrom(String from)
{
	this.from=from;
}
public void setTo(String to)
{
	this.to=to;
}
public void setVia(String rvia)
{
	this.rvia=rvia;
}

public void setDate(String date)
{
	this.date=date;
}
public int getId()
{
	return rid;
}
public String getFrom()
{
	return from;
}
public String getTo()
{
	return to;
}
public String getDate()
{
	return date;
}

public String getVia()
{
	return rvia;
}
}

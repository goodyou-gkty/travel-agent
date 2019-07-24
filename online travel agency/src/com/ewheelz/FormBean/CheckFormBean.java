package com.ewheelz.FormBean;

import java.io.Serializable;

public class CheckFormBean implements Serializable{
	
	private String from;
	private String to;
	private String date;
	private String btype;
	private int bid;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public void setBusId(int bid)
	{
		this.bid=bid;
	}
	

	public int getBusId()
	{
		return bid;
	}	

}

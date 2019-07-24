package com.ewheelz.FormBean;

import java.io.Serializable;

public class SheduleFormBean implements Serializable {

	
	private int bid,rid,sc,bfair;
	
	private String sdate,time;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	public int getBfair() {
		return bfair;
	}

	public void setBfair(int bfair) {
		this.bfair = bfair;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}

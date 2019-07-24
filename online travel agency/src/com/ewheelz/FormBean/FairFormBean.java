package com.ewheelz.FormBean;

import java.io.Serializable;

public class FairFormBean implements Serializable {

	private int bid,rid,famt;
	
	String btype;

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

	public int getFamt() {
		return famt;
	}

	public void setFamt(int famt) {
		this.famt = famt;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}
	
	
	
}

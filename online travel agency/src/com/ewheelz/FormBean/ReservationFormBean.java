package com.ewheelz.FormBean;

import java.io.Serializable;

public class ReservationFormBean implements Serializable {
	
	private String btype,ufrom ,uto ,udate,loginid;
	private int seatno,busid,userid,reservid;
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getUfrom() {
		return ufrom;
	}
	public void setUfrom(String ufrom) {
		this.ufrom = ufrom;
	}
	public String getUto() {
		return uto;
	}
	public void setUto(String uto) {
		this.uto = uto;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public int getReservid() {
		return reservid;
	}
	public void setReservid(int reservid) {
		this.reservid = reservid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	
	
	
	
	

}

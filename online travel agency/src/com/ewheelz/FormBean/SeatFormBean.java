package com.ewheelz.FormBean;

import java.io.Serializable;

public class SeatFormBean implements Serializable{
	
	String btype,bname,status,date;
int bid,seatno,SeatId,rid;
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
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public int getBid() {
	return bid;
}
public void setBid(int bsno){
	this.bid = bsno;
}
public int getSeatno() {
	return seatno;
}
public void setSeatno(int seatno) {
	this.seatno = seatno;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getSeatId() {
	return SeatId;
}
public void setSeatId(int seatId) {
	SeatId = seatId;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
	
}

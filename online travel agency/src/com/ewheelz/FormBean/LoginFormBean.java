package com.ewheelz.FormBean;

public class LoginFormBean  implements java.io.Serializable{
	
	private  String uname;
	private String pwd;
	LoginFormBean(){
	}
public void setName(String uname)
	{
		this.uname=uname;
	}
public void setPass(String pwd)
{
	this.pwd=pwd;
}
public String getUser()
{
	return uname;
}
public String getPass()
{
	return pwd;
}
}

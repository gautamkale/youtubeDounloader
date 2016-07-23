package com.dashboard.controller;

import com.dashboard.service.impl.DashFileReaderInterface;
import com.dashboard.services.DashFileReader;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateBsData extends ActionSupport {

	private int p1p2;
	private int p3p4;
	private int sr;
	private int fpr;
	private String rs;
	private String bsName;
	public String getBsName() {
		return bsName;
	}
	public void setBsName(String bsName) {
		this.bsName = bsName;
	}
	public int getP1p2() {
		return p1p2;
	}
	public String getRs() {
		return rs;
	}
	public void setRs(String rs) {
		this.rs = rs;
	}
	public void setP1p2(int p1p2) {
		this.p1p2 = p1p2;
	}
	public int getP3p4() {
		return p3p4;
	}
	public void setP3p4(int p3p4) {
		this.p3p4 = p3p4;
	}
	public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
	}
	public int getFpr() {
		return fpr;
	}
	public void setFpr(int fpr) {
		this.fpr = fpr;
	}
	public String execute()
	{
		DashFileReaderInterface reader=new DashFileReader();
		System.out.println(bsName+".....................................");
		try
		{
			rs=reader.updateBs(bsName, p1p2, p3p4, sr, fpr);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "update";
	}
	
}

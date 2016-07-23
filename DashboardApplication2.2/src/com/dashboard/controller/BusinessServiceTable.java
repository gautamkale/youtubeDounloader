package com.dashboard.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dashboard.model.Dashboard;
import com.dashboard.service.impl.DashFileReaderInterface;
import com.dashboard.services.DashFileReader;
import com.opensymphony.xwork2.ActionSupport;

public class BusinessServiceTable extends ActionSupport {
	private String clName;

	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}
private ArrayList<Dashboard> clusterDetailsList1= new ArrayList<Dashboard>();
	
	public ArrayList<Dashboard> getClusterDetailsList1() {
		return clusterDetailsList1;
	}
	public void setClusterDetailsList1(ArrayList<Dashboard> clusterDetailsList1) {
		this.clusterDetailsList1 = clusterDetailsList1;
	}
	public String execute()
	{
		
		DashFileReaderInterface reader=new DashFileReader();
		try {
			clusterDetailsList1=reader.getClusterBSList(getClName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "send";
	}
}

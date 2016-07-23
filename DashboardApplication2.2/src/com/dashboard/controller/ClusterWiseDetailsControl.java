package com.dashboard.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Util.ConstantString;

import com.dashboard.model.Dashboard;
import com.dashboard.service.impl.DashFileReaderInterface;
import com.dashboard.services.ClusterTicketDetails;
import com.dashboard.services.DashFileReader;
import com.opensymphony.xwork2.ActionSupport;

public class ClusterWiseDetailsControl extends ActionSupport{
	private String clusterName1;
	private String clusterName2;
	private ArrayList<Dashboard> clusterBreachTickets1= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> clusterBreachTickets2= new ArrayList<Dashboard>();
	private ArrayList<Dashboard>breachIn2Hr1= new ArrayList<Dashboard>();
	private ArrayList<Dashboard>breachIn2Hr2= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> clusterDetailsList1= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> clusterDetailsList2= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> clusterDump= new ArrayList<Dashboard>();
	
	public ArrayList<Dashboard> getClusterDump() {
		return clusterDump;
	}
	public void setClusterDump(ArrayList<Dashboard> clusterDump) {
		this.clusterDump = clusterDump;
	}
	public ArrayList<Dashboard> getClusterDetailsList1() {
		return clusterDetailsList1;
	}
	public void setClusterDetailsList1(ArrayList<Dashboard> clusterDetailsList1) {
		this.clusterDetailsList1 = clusterDetailsList1;
	}
	public ArrayList<Dashboard> getClusterDetailsList2() {
		return clusterDetailsList2;
	}
	public void setClusterDetailsList2(ArrayList<Dashboard> clusterDetailsList2) {
		this.clusterDetailsList2 = clusterDetailsList2;
	}
	public ArrayList<Dashboard> getBreachIn2Hr1() {
		return breachIn2Hr1;
	}
	public void setBreachIn2Hr1(ArrayList<Dashboard> breachIn2Hr1) {
		this.breachIn2Hr1 = breachIn2Hr1;
	}
	public ArrayList<Dashboard> getBreachIn2Hr2() {
		return breachIn2Hr2;
	}
	public void setBreachIn2Hr2(ArrayList<Dashboard> breachIn2Hr2) {
		this.breachIn2Hr2 = breachIn2Hr2;
	}
	public String getClusterName1() {
		return clusterName1;
	}
	public void setClusterName1(String clusterName1) {
		this.clusterName1 = clusterName1;
	}
	public String getClusterName2() {
		return clusterName2;
	}
	public void setClusterName2(String clusterName2) {
		this.clusterName2 = clusterName2;
	}
	public ArrayList<Dashboard> getClusterBreachTickets1() {
		return clusterBreachTickets1;
	}
	public void setClusterBreachTickets1(ArrayList<Dashboard> clusterBreachTickets1) {
		this.clusterBreachTickets1 = clusterBreachTickets1;
	}
	public ArrayList<Dashboard> getClusterBreachTickets2() {
		return clusterBreachTickets2;
	}
	public void setClusterBreachTickets2(ArrayList<Dashboard> clusterBreachTickets2) {
		this.clusterBreachTickets2 = clusterBreachTickets2;
	}
	public String getClusterDetail()
	{
		try
		{
			
			DashFileReaderInterface reader= new DashFileReader();
			ClusterTicketDetails cs=new ClusterTicketDetails();
			cs.updateBreachBacklog();
			clusterBreachTickets1=reader.showBreachTicket(ConstantString.callerName,getClusterName1());
			//clusterBreachTickets2=reader.showBreachTicket(ConstantString.callerName,getClusterName2());
			clusterDump=cs.showClusterDump(ConstantString.callerName,getClusterName1());
			breachIn2Hr1=reader.get2HrBreachList(ConstantString.callerName,getClusterName1());
			//breachIn2Hr2=reader.get2HrBreachList(ConstantString.callerName,getClusterName2());
			clusterDetailsList1=reader.getClusterBSList(getClusterName1());
			//clusterDetailsList2=reader.getClusterBSList(getClusterName2());
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "clusterwisedetail";
	}

}

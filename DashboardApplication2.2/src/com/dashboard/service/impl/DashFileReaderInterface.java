package com.dashboard.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dashboard.model.BreachModel;
import com.dashboard.model.Dashboard;

public interface DashFileReaderInterface {

	public abstract ArrayList<BreachModel> getBreachClusterDetails(
			String clusterName) throws SQLException;

	public abstract ArrayList<Dashboard> get2HrBreachList(String callerName)
			throws SQLException;
	public abstract ArrayList<Dashboard> get2HrBreachList(String callerName,String clusterName)
			throws SQLException;

	public abstract ArrayList<Dashboard> getBreachList(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> showBreachTicket(String callerName) throws SQLException;
	public abstract ArrayList<Dashboard> showBreachTicket(String callerName,String clusterName) throws SQLException;

	public abstract ArrayList<Dashboard> getTodaysTargetList(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> readDashboardFile(String callerName)
			throws SQLException;
	
	public Dashboard getBreachDetail(String cluster, String callerName)
			throws SQLException;
	public Dashboard getOverdueTicketDetail(String cluster, String callerName)
			throws SQLException;
	public boolean validatingUser(String user,String passwd)throws SQLException;
	public abstract ArrayList<Dashboard> getClusterBSList(String clusterName)
			throws SQLException;
	public abstract ArrayList<Dashboard> getBSList(String clusterName)
			throws SQLException;
	public abstract String updateBs(String bsName,int p1p2,int p3p4,int sr,int fpr)
			throws SQLException;
	

}
package com.dashboard.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dashboard.model.Dashboard;

public interface ClusterTicketDetailsImpl {

	public ArrayList<Dashboard> showPriorityTicketDetail(String prio,
			String callerName) throws SQLException;
	public ArrayList<Dashboard> showStatusTicketDetail(String status,
			String callerName) throws SQLException;
	public ArrayList<Dashboard> showOverdueTicketDetail(String callerName) throws SQLException;
	
	public ArrayList<Dashboard> getClusterWizeList(String whichList,String callerName) throws Exception;
	public boolean importData(String fileName)throws Exception;
	public ArrayList<String> getTicketNo(String term)throws Exception;
	public ArrayList<Dashboard> getSerachDataList(String tno,String fdate,String tdate)throws Exception;
	public String getUpdateTime()throws Exception;
	public void updateBreachBacklog()throws Exception;
	public abstract ArrayList<Dashboard> showClusterDump(String callerName,String clusterName) throws SQLException;

}
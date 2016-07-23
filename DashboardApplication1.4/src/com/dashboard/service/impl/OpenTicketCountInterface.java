package com.dashboard.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.dashboard.model.Dashboard;

public interface OpenTicketCountInterface {

	public abstract Dashboard ticketCounter(String clusterName, Dashboard db,
			String callerName) throws SQLException;

	public abstract Dashboard statusCounter(String clusterName, Dashboard db,
			String callerName) throws SQLException;

	public abstract Dashboard ageCounter(String clusterName, Dashboard db,
			String callerName) throws ParseException, SQLException;

	public abstract ArrayList<Dashboard> showTicketDetail(String clusterName,
			String prio, String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> showTicketStatusDetail(
			String clusterName, String prio, String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> showStatusDetail(String clusterName,
			String stat, String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> showStatusPriorityDetail(
			String clusterName, String stat, String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> showAgeDetail(String clusterName,
			int strCount, String callerName) throws ParseException,
			SQLException;

	public abstract ArrayList<ArrayList<Integer>> showAgeStatusPriorityDetail(
			String clusterName, int strCount, String callerName)
			throws ParseException, SQLException;

	public abstract Dashboard getReopenCountlst(String clustername,
			String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> showReopenDetail(String clusterName,
			String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> showClusterDetail(String clusterName,
			String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> showAgeTotal(int strCount,
			String callerName) throws ParseException, SQLException;

	public abstract ArrayList<Dashboard> showReopenTotal(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> showPriorityTotal(String prio,
			String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> showStatusTotal(String stat,
			String callerName) throws SQLException;

	public abstract ArrayList<Dashboard> getBartData(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> getPriorityChartData(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> getStatusChartData(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> getClusterCount(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> getAgeChart(String callerName)
			throws ParseException, SQLException;

	public abstract ArrayList<Dashboard> getKPIHighChartData(String callerName)
			throws SQLException;

	public abstract ArrayList<Dashboard> getOwnerInfo(String appId)
			throws SQLException;

	public abstract ArrayList<Dashboard> getOwnerInfoList() throws SQLException;

	public int getTotalPrioritycount(ArrayList<Dashboard> lst,int counter);
	public int getTotalStatusCount(ArrayList<Dashboard> lst, String stat);
	public int getTotalBkLogAndReopenCount(ArrayList<Dashboard> lst, String str);

}
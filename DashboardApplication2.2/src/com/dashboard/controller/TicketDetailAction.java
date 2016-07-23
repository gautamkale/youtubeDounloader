/**
 * 
 */
package com.dashboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import Util.ConstantString;

import com.dashboard.model.Dashboard;
import com.dashboard.service.impl.ClusterTicketDetailsImpl;
import com.dashboard.service.impl.DashFileReaderInterface;
import com.dashboard.service.impl.OpenTicketCountInterface;
import com.dashboard.services.ClusterTicketDetails;
import com.dashboard.services.DashFileReader;
import com.dashboard.services.OpenTicketCount;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author A551749
 *
 */
public class TicketDetailAction extends ActionSupport {
	private ArrayList<Dashboard> p1list =new ArrayList<Dashboard>();
	private ArrayList<Dashboard> clusterCount= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> p1Detaillst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> statusCounter= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> statusDetaillst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> backlogCount= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> reopenCountlst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> overdueCountlst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> clusterChartLst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> overdueTicketLst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> backlogTicketLst= new ArrayList<Dashboard>();
	private ArrayList<Dashboard> breach2hLst= new ArrayList<Dashboard>();
	private int totalP1=0;
	private int totalP2=0;
	private int totalP3=0;
	private int totalP4=0;
	private String rply;
	private String  priority;
	private String statusAction;
	private int assignedTotal;
	private int wipTotal;
	private int newTotal;
	private int totalBacklog;
	private int totalReopen;
	private int totalOverdue;
	private String blrepenAction;
	
	public String getRply() {
		return rply;
	}
	public void setRply(String rply) {
		this.rply = rply;
	}
	
	public ArrayList<Dashboard> getP1list() {
		return p1list;
	}
	public void setP1list(ArrayList<Dashboard> p1list) {
		this.p1list = p1list;
	}
	
	public int getAssignedTotal() {
		return assignedTotal;
	}
	public void setAssignedTotal(int assignedTotal) {
		this.assignedTotal = assignedTotal;
	}
	public int getWipTotal() {
		return wipTotal;
	}
	public void setWipTotal(int wipTotal) {
		this.wipTotal = wipTotal;
	}
	
	public ArrayList<Dashboard> getClusterCount() {
		return clusterCount;
	}
	public void setClusterCount(ArrayList<Dashboard> clusterCount) {
		this.clusterCount = clusterCount;
	}
	
	public int getTotalP1() {
		return totalP1;
	}
	public void setTotalP1(int totalP1) {
		this.totalP1 = totalP1;
	}
	public int getTotalP2() {
		return totalP2;
	}
	public void setTotalP2(int totalP2) {
		this.totalP2 = totalP2;
	}
	public int getTotalP3() {
		return totalP3;
	}
	public void setTotalP3(int totalP3) {
		this.totalP3 = totalP3;
	}
	public int getTotalP4() {
		return totalP4;
	}
	public void setTotalP4(int totalP4) {
		this.totalP4 = totalP4;
	}
	
	public ArrayList<Dashboard> getP1Detaillst() {
		return p1Detaillst;
	}
	public void setP1Detaillst(ArrayList<Dashboard> p1Detaillst) {
		this.p1Detaillst = p1Detaillst;
	}
	public ArrayList<Dashboard> getStatusCounter() {
		return statusCounter;
	}
	public void setStatusCounter(ArrayList<Dashboard> statusCounter) {
		this.statusCounter = statusCounter;
	}
	
	public ArrayList<Dashboard> getStatusDetaillst() {
		return statusDetaillst;
	}
	public void setStatusDetaillst(ArrayList<Dashboard> statusDetaillst) {
		this.statusDetaillst = statusDetaillst;
	}
	
	public String getStatusAction() {
		return statusAction;
	}
	public void setStatusAction(String statusAction) {
		this.statusAction = statusAction;
	}
	public ArrayList<Dashboard> getClusterChartLst() {
		return clusterChartLst;
	}
	public void setClusterChartLst(ArrayList<Dashboard> clusterChartLst) {
		this.clusterChartLst = clusterChartLst;
	}
	public ArrayList<Dashboard> getBacklogCount() {
		return backlogCount;
	}
	public void setBacklogCount(ArrayList<Dashboard> backlogCount) {
		this.backlogCount = backlogCount;
	}
	
	public int getTotalReopen() {
		return totalReopen;
	}
	public void setTotalReopen(int totalReopen) {
		this.totalReopen = totalReopen;
	}
	public int getTotalBacklog() {
		return totalBacklog;
	}
	public void setTotalBacklog(int totalBacklog) {
		this.totalBacklog = totalBacklog;
	}
	public ArrayList<Dashboard> getReopenCountlst() {
		return reopenCountlst;
	}
	public void setReopenCountlst(ArrayList<Dashboard> reopenCountlst) {
		this.reopenCountlst = reopenCountlst;
	}
	public String getBlrepenAction() {
		return blrepenAction;
	}
	public void setBlrepenAction(String blrepenAction) {
		this.blrepenAction = blrepenAction;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getNewTotal() {
		return newTotal;
	}
	public void setNewTotal(int newTotal) {
		this.newTotal = newTotal;
	}
	public int getTotalOverdue() {
		return totalOverdue;
	}
	public void setTotalOverdue(int totalOverdue) {
		this.totalOverdue = totalOverdue;
	}
	public ArrayList<Dashboard> getOverdueCountlst() {
		return overdueCountlst;
	}
	public void setOverdueCountlst(ArrayList<Dashboard> overdueCountlst) {
		this.overdueCountlst = overdueCountlst;
	}
	public ArrayList<Dashboard> getOverdueTicketLst() {
		return overdueTicketLst;
	}
	public void setOverdueTicketLst(ArrayList<Dashboard> overdueTicketLst) {
		this.overdueTicketLst = overdueTicketLst;
	}
	public ArrayList<Dashboard> getBacklogTicketLst() {
		return backlogTicketLst;
	}
	public void setBacklogTicketLst(ArrayList<Dashboard> backlogTicketLst) {
		this.backlogTicketLst = backlogTicketLst;
	}
	public ArrayList<Dashboard> getBreach2hLst() {
		return breach2hLst;
	}
	public void setBreach2hLst(ArrayList<Dashboard> breach2hLst) {
		this.breach2hLst = breach2hLst;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Action#execute()
	 */ 
	public  String getPriorityCount() throws Exception {
		// TODO Auto-generated method stub
		
		DashFileReaderInterface reader= new DashFileReader();
		
		ClusterTicketDetailsImpl lstObj=new ClusterTicketDetails();
		
		OpenTicketCountInterface ticketCount= new OpenTicketCount();

		p1list=reader.readDashboardFile(ConstantString.callerName);
		//get all priority count..
	
		clusterCount=lstObj.getClusterWizeList(ConstantString.PRIORITY, ConstantString.callerName);
		 
		setTotalP1(ticketCount.getTotalPrioritycount(clusterCount,1));
		setTotalP2(ticketCount.getTotalPrioritycount(clusterCount,2));
		setTotalP3(ticketCount.getTotalPrioritycount(clusterCount,3));
		setTotalP4(ticketCount.getTotalPrioritycount(clusterCount,4));
		
		/*statusCounter=lstObj.getClusterWizeList(ConstantString.STATUS, ConstantString.callerName);
		
	
		//get all status count
				
		setAssignedTotal(ticketCount.getTotalStatusCount(statusCounter,ConstantString.ASSIGNED));
		setWipTotal(ticketCount.getTotalStatusCount(statusCounter,ConstantString.WIP));
		setNewTotal(ticketCount.getTotalStatusCount(statusCounter,ConstantString.NEW));*/
		
	//	backlogCount=lstObj.getClusterWizeList(ConstantString.BACKLOG, ConstantString.callerName);
	//	setTotalBacklog(ticketCount.getTotalBkLogAndReopenCount(backlogCount, ConstantString.BACKLOG));
		
		/*reopenCountlst=lstObj.getClusterWizeList(ConstantString.REOPEN, ConstantString.callerName);
		setTotalReopen(ticketCount.getTotalBkLogAndReopenCount(backlogCount, ConstantString.REOPEN));*/
		
		
		/*setTotalOverdue(ticketCount.getTotalBkLogAndReopenCount(overdueCountlst, ConstantString.OVERDUE));
		
		breach2hLst=reader.get2HrBreachList(ConstantString.callerName);*/
		clusterChartLst=ticketCount.getClusterCount(ConstantString.callerName);
		
		setRply("priorityCount");
		
		return rply;
	}

	public String getPriorityDetail() throws Exception
	{
		getPriorityCount();
		ClusterTicketDetailsImpl p1Obj=new ClusterTicketDetails();
	
		p1Detaillst=p1Obj.showPriorityTicketDetail(getPriority(), ConstantString.callerName);
		setRply("prioritydetail");
		return rply;
		
	}
	public String getStatusDetail() throws Exception
	{
		getPriorityCount();
		ClusterTicketDetailsImpl p1Obj=new ClusterTicketDetails();
		
		statusDetaillst=p1Obj.showStatusTicketDetail(getStatusAction(), ConstantString.callerName);
		
		setRply("statusdetail");
		return rply;
		
	}
	public String getBacklogAndReopenDetail() throws Exception
	{
		getPriorityCount();
		ClusterTicketDetailsImpl p1Obj=new ClusterTicketDetails();
		DashFileReaderInterface reader= new DashFileReader();
		
		backlogTicketLst=reader.showBreachTicket(ConstantString.callerName);
		overdueTicketLst=p1Obj.showOverdueTicketDetail(ConstantString.callerName);
		setRply("backlog");
		return rply;
		
	}
	
		
	
}

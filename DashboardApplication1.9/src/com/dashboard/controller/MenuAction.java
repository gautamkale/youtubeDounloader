package com.dashboard.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.dashboard.model.Dashboard;
import com.dashboard.model.JQueryDataTableParamModel;
import com.dashboard.service.impl.ClusterTicketDetailsImpl;
import com.dashboard.service.impl.DashFileReaderInterface;
import com.dashboard.services.ClusterTicketDetails;
import com.dashboard.services.DashFileReader;
import com.opensymphony.xwork2.ActionSupport;

public  class MenuAction extends ActionSupport{
	 private String userId;
	 private String passwd;
	 private String rply;
	 private File myFile;
	 private String term;
	 private ArrayList<String> termlist=new ArrayList<String>();
	 private List<Dashboard>aaData;
	 private String tno;
	 private String fromDate;
	 private String toDate;
	JQueryDataTableParamModel dataTableObject= new JQueryDataTableParamModel();
	 //private List<Dashboard> aaData; 
	 
	 /*private String myFileContentType;
	 private String myFileFileName;
	 private String destPath;*/
	 
	public JQueryDataTableParamModel getDataTableObject() {
		return dataTableObject;
	}
	public void setDataTableObject(JQueryDataTableParamModel dataTableObject) {
		this.dataTableObject = dataTableObject;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getUserId() {
		return userId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public ArrayList<String> getTermlist() {
		return termlist;
	}
	public void setTermlist(ArrayList<String> termlist) {
		this.termlist = termlist;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	 
	public String getRply() {
		return rply;
	}
	public void setRply(String rply) {
		this.rply = rply;
	}

	
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	public String validateUser() throws SQLException
	{
		DashFileReaderInterface  reader=new DashFileReader();
		Boolean rs=reader.validatingUser(getUserId(), getPasswd());
		if (rs)
		{
			setRply("validate");
		}else
		{
			setRply("error");
		}
		
		return rply;
	}
public String login()throws Exception
{
	setRply("login");
	return rply;
}
public String autoCompletList()
{
	ClusterTicketDetailsImpl cl=new ClusterTicketDetails();
	try{
		termlist =cl.getTicketNo(getTerm());
		
		
	}catch(Exception e)
	{
		e.printStackTrace();;
	}
	setRply("autocomplete");
	return rply;
}

public List<Dashboard> getAaData() {
	return aaData;
}
public void setAaData(List<Dashboard> aaData) {
	this.aaData = aaData;
}
public String getserachDataAction()
{
	ClusterTicketDetailsImpl cstr=new ClusterTicketDetails();
	
	System.out.println("getterm......"+getTerm()+getTno());
	try{
		System.out.println("searchlist......."+getTno()+getFromDate()+getToDate());
		aaData=cstr.getSerachDataList(getTno(), getFromDate(), getToDate());
		  //dataTableObject.setAaData(searchlist);
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	setRply("searchData");
	return rply;
}
public String searchForm()
{
	setRply("search");
	System.out.println(getTno()+"Tno");
	return rply;
}
	
}

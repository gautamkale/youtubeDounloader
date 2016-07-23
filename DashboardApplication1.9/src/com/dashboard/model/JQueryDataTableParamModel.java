package com.dashboard.model;

import java.util.List;

public class JQueryDataTableParamModel {
	
	int  iTotalRecords;
	  
	 int  iTotalDisplayRecords;
	  
	 public String  sEcho;
	  
	 String sColumns;
	  
	 List<Dashboard> aaData;
	 
	 public int getiTotalRecords() {
	  return iTotalRecords;
	 }
	 
	 public void setiTotalRecords(int iTotalRecords) {
	  this.iTotalRecords = iTotalRecords;
	 }
	 
	 public int getiTotalDisplayRecords() {
	  return iTotalDisplayRecords;
	 }
	 
	 public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
	  this.iTotalDisplayRecords = iTotalDisplayRecords;
	 }
	 
	 public String getsEcho() {
	  return sEcho;
	 }
	 
	 public void setsEcho(String sEcho) {
	  this.sEcho = sEcho;
	 }
	 
	 public String getsColumns() {
	  return sColumns;
	 }
	 
	 public void setsColumns(String sColumns) {
	  this.sColumns = sColumns;
	 }
	 
	 public List<Dashboard> getAaData() {
	  return aaData;
	 }
	 
	 public void setAaData(List<Dashboard> aaData) {
	  this.aaData = aaData;
	 }
	  

}

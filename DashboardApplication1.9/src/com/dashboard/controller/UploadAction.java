package com.dashboard.controller;

import java.io.File;

import javax.security.auth.login.FailedLoginException;

import org.apache.commons.io.FileUtils;


import org.apache.commons.lang.StringUtils;

import Util.ConstantString;

import com.dashboard.service.impl.ClusterTicketDetailsImpl;
import com.dashboard.services.ClusterTicketDetails;
import com.opensymphony.xwork2.ActionSupport;


public class UploadAction extends ActionSupport  {
	
	 private String myFileContentType;
	 private String myFileFileName;
	 private String destPath;
	 private File myFile;
	 public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileFileName() {
			return myFileFileName;
		}
		public void setMyFileFileName(String myFileFileName) {
			this.myFileFileName = myFileFileName;
		}
		public String getMyFileContentType() {
			return myFileContentType;
		}
		public void setMyFileContentType(String myFileContentType) {
			this.myFileContentType = myFileContentType;
		}
		
	

		
	public String execute()  {
		try{
			    if(getMyFile()==null){
				    addFieldError("myFile", "file is required");
				    return INPUT;
				   }
			    String name = myFileFileName;
		          String []fileext = name.split("\\."); 
		          String ext = fileext[1];
		if(ext.equals("csv"))
		{
		destPath = ConstantString.FILEPATH;
		String str;
		
		ClusterTicketDetailsImpl imp=new ClusterTicketDetails();

	
			System.out.println("Src File name: " + getMyFile());
			System.out.println("Dst File name: " + myFileFileName);

			File destFile = new File(destPath, myFileFileName);
			FileUtils.copyFile(getMyFile(), destFile);
			str=destFile.getAbsolutePath();
			System.out.println("Dst File name: " + str);
			imp.importData(str);
			return "upload";
		}
		else{
			  addFieldError("myFile", "Upload only csv file");
	       return INPUT;}
	}catch(Exception e)
	{
		e.printStackTrace();
		addFieldError("Exception","something is wrong in Data");
        return INPUT;
	}
	}
	
	
	
	
}

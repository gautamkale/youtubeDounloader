package com.dashboard.controller;

import com.dashboard.service.impl.ClusterTicketDetailsImpl;
import com.dashboard.services.ClusterTicketDetails;
import com.opensymphony.xwork2.ActionSupport;

public class UploadTimeAction extends ActionSupport{

	private String timeStr;
	private String rply;
	public String getTimeStr() {
			return timeStr;
		}
		public void setTimeStr(String timeStr) {
			this.timeStr = timeStr;
		}

		public String getRply() {
			return rply;
		}
		public void setRply(String rply) {
			this.rply = rply;
		}
			
		public String execute() throws Exception {
			
			try
			{
				ClusterTicketDetailsImpl dateObj=new ClusterTicketDetails();
				setTimeStr(dateObj.getUpdateTime());
				System.out.println("gets"+getTimeStr());
				setRply("date");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return rply;
		}
}

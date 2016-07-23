package com.dashboard.model;

public class BreachModel {

	private String requestID;
	private String requestType;
	private int priority;
	private String arrivalDate;
	private String itslaTargetDate;
	private String ApprovedDate;
	private String SubmitDate;
	private String atosAppID;
	private String cluster;
	private String DasId;
	private boolean valid;
	private boolean Approved;
	private String Reason;
	private String Approver;

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getItslaTargetDate() {
		return itslaTargetDate;
	}

	public void setItslaTargetDate(String itslaTargetDate) {
		this.itslaTargetDate = itslaTargetDate;
	}

	public String getApprovedDate() {
		return ApprovedDate;
	}

	public void setApprovedDate(String approvedDate) {
		ApprovedDate = approvedDate;
	}

	public String getSubmitDate() {
		return SubmitDate;
	}

	public void setSubmitDate(String submitDate) {
		SubmitDate = submitDate;
	}

	public String getAtosAppID() {
		return atosAppID;
	}

	public void setAtosAppID(String atosAppID) {
		this.atosAppID = atosAppID;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getDasId() {
		return DasId;
	}

	public void setDasId(String dasId) {
		DasId = dasId;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isApproved() {
		return Approved;
	}

	public void setApproved(boolean approved) {
		Approved = approved;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getApprover_Remark() {
		return Approver_Remark;
	}

	public void setApprover_Remark(String approver_Remark) {
		Approver_Remark = approver_Remark;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public String getApprover() {
		return Approver;
	}

	public void setApprover(String approver) {
		Approver = approver;
	}

	private String Approver_Remark;
	private boolean lock;
	private boolean Reviewed;

	public boolean isReviewed() {
		return Reviewed;
	}

	public void setReviewed(boolean reviewed) {
		Reviewed = reviewed;
	}

}

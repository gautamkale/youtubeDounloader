package com.dashboard.model;

public class Dashboard {

	private String	application	;
	private String ticketNumber;
	private String callState;
	private String incidentDesc;
	private String businessServiceName;
	private String itServiceName;
	private String assignmentGroup;
	private String resolvingService;
	private String caller;
	private String incidentNumber;
	private String automaticFlow;
	private String madeSla;
	private String resolveDate;
	private String	arrivalDate	;
	private String breached;
	private String overdue;
	private String openSinceDays;
	private String referenceTicket;
	private String slaVi0lation;
	private String monthOfCreation;
	private String monthOfResolution;
	private String	status	;
	private String	individual	;	
	
	private String	gscValue;
	private String	itslaTargetDate	;
	private String atosAppID;

	private String serviceWindow;
	private String SLAClass;
	private String ownerStatus;
	private String primarySME;
	private String primaryEmail;
	private String primaryContact;
	private String secondarySME;
	private String secondaryEmail;
	private String secondaryContact; 
	private String SMName;
	private String SMEmail;
	private String SMContact ;
	private String SDMName;
	private String SDMEmail;
	private String SDMContact ;
	private String ICMName;
	private String ICMEmail;
	private String ICMContact;
	private String GCDMName;
	private String GCDMEmail;
	private String GCDMContact;
	private String SIBSMName;
	private String SIBSMEmail;
	private String	requestID	;
	private String	requestType	;
	private int	    priority	;
	private int	    Count	;
	private boolean today;
	private String cluster;
	private int p1Count;
	private int p2Count;
	private int p3Count;
	private int p4Count;
	private int assignedCount;
	private int wipCount;
	private int pendingCount;
	private int newCount;
	private int onHoldClockRunningCount;
	private int onHoldClockStoppedCount;
	private int solvedCount;
	private int closedCount;
	private int cancelledCount;
	private int daysCount;
	private int bklogCount;
	private int overdueCount;
	private int p1P2;
	private int p3P4;
	public int getP1P2() {
		return p1P2;
	}
	public void setP1P2(int p1p2) {
		p1P2 = p1p2;
	}
	public int getP3P4() {
		return p3P4;
	}
	public void setP3P4(int p3p4) {
		p3P4 = p3p4;
	}
	public int getSr() {
		return Sr;
	}
	public void setSr(int sr) {
		Sr = sr;
	}
	public int getFpr() {
		return Fpr;
	}
	public void setFpr(int fpr) {
		Fpr = fpr;
	}


	private int Sr;
	private int Fpr;

	private int reopenCount;
	
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getCallState() {
		return callState;
	}
	public void setCallState(String callState) {
		this.callState = callState;
	}
	public String getIncidentDesc() {
		return incidentDesc;
	}
	public void setIncidentDesc(String incidentDesc) {
		this.incidentDesc = incidentDesc;
	}
	public String getBusinessServiceName() {
		return businessServiceName;
	}
	public void setBusinessServiceName(String businessServiceName) {
		this.businessServiceName = businessServiceName;
	}
	public String getItServiceName() {
		return itServiceName;
	}
	public void setItServiceName(String itServiceName) {
		this.itServiceName = itServiceName;
	}
	public String getAssignmentGroup() {
		return assignmentGroup;
	}
	public void setAssignmentGroup(String assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}
	public String getResolvingService() {
		return resolvingService;
	}
	public void setResolvingService(String resolvingService) {
		this.resolvingService = resolvingService;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getIncidentNumber() {
		return incidentNumber;
	}
	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}
	public String getAutomaticFlow() {
		return automaticFlow;
	}
	public void setAutomaticFlow(String automaticFlow) {
		this.automaticFlow = automaticFlow;
	}
	public String getMadeSla() {
		return madeSla;
	}
	public void setMadeSla(String madeSla) {
		this.madeSla = madeSla;
	}
	public String getResolveDate() {
		return resolveDate;
	}
	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}
	public String getBreached() {
		return breached;
	}
	public void setBreached(String breached) {
		this.breached = breached;
	}
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	public String getOpenSinceDays() {
		return openSinceDays;
	}
	public void setOpenSinceDays(String openSinceDays) {
		this.openSinceDays = openSinceDays;
	}
	public String getReferenceTicket() {
		return referenceTicket;
	}
	public void setReferenceTicket(String referenceTicket) {
		this.referenceTicket = referenceTicket;
	}
	public String getSlaVi0lation() {
		return slaVi0lation;
	}
	public void setSlaVi0lation(String slaVi0lation) {
		this.slaVi0lation = slaVi0lation;
	}
	public String getMonthOfCreation() {
		return monthOfCreation;
	}
	public void setMonthOfCreation(String monthOfCreation) {
		this.monthOfCreation = monthOfCreation;
	}
	public String getMonthOfResolution() {
		return monthOfResolution;
	}
	public void setMonthOfResolution(String monthOfResolution) {
		this.monthOfResolution = monthOfResolution;
	}
	public int getP1Count() {
		return p1Count;
	}
	public void setP1Count(int p1Count) {
		this.p1Count = p1Count;
	}
	public int getP2Count() {
		return p2Count;
	}
	public void setP2Count(int p2Count) {
		this.p2Count = p2Count;
	}
	public int getP3Count() {
		return p3Count;
	}
	public void setP3Count(int p3Count) {
		this.p3Count = p3Count;
	}
	public int getP4Count() {
		return p4Count;
	}
	public void setP4Count(int p4Count) {
		this.p4Count = p4Count;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIndividual() {
		return individual;
	}
	public void setIndividual(String individual) {
		this.individual = individual;
	}
	public String getGscValue() {
		return gscValue;
	}
	public void setGscValue(String gscValue) {
		this.gscValue = gscValue;
	}
	public String getItslaTargetDate() {
		return itslaTargetDate;
	}
	public void setItslaTargetDate(String itslaTargetDate) {
		this.itslaTargetDate = itslaTargetDate;
	}
	public String getAtosAppID() {
		return atosAppID;
	}
	public void setAtosAppID(String atosAppID) {
		this.atosAppID = atosAppID;
	}
	
	public boolean isToday() {
		
		return today;
	}
	public void setToday(boolean today) {
		this.today = today;
	}
	
	
	public int getAssignedCount() {
		return assignedCount;
	}
	public void setAssignedCount(int assignedCount) {
		this.assignedCount = assignedCount;
	}
	public int getWipCount() {
		return wipCount;
	}
	public void setWipCount(int wipCount) {
		this.wipCount = wipCount;
	}
	public int getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}

	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}


	
	public String getServiceWindow() {
		return serviceWindow;
	}
	public void setServiceWindow(String serviceWindow) {
		this.serviceWindow = serviceWindow;
	}
	public String getSLAClass() {
		return SLAClass;
	}
	public void setSLAClass(String sLAClass) {
		SLAClass = sLAClass;
	}
	public String getOwnerStatus() {
		return ownerStatus;
	}
	public void setOwnerStatus(String ownerStatus) {
		this.ownerStatus = ownerStatus;
	}
	public String getPrimarySME() {
		return primarySME;
	}
	public void setPrimarySME(String primarySME) {
		this.primarySME = primarySME;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}
	public String getSecondarySME() {
		return secondarySME;
	}
	public void setSecondarySME(String secondarySME) {
		this.secondarySME = secondarySME;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getSecondaryContact() {
		return secondaryContact;
	}
	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}
	public String getSMName() {
		return SMName;
	}
	public void setSMName(String sMName) {
		SMName = sMName;
	}
	public String getSMEmail() {
		return SMEmail;
	}
	public void setSMEmail(String sMEmail) {
		SMEmail = sMEmail;
	}
	public String getSMContact() {
		return SMContact;
	}
	public void setSMContact(String sMContact) {
		SMContact = sMContact;
	}
	public String getSDMName() {
		return SDMName;
	}
	public void setSDMName(String sDMName) {
		SDMName = sDMName;
	}
	public String getSDMEmail() {
		return SDMEmail;
	}
	public void setSDMEmail(String sDMEmail) {
		SDMEmail = sDMEmail;
	}
	public String getSDMContact() {
		return SDMContact;
	}
	public void setSDMContact(String sDMContact) {
		SDMContact = sDMContact;
	}
	public String getICMName() {
		return ICMName;
	}
	public void setICMName(String iCMName) {
		ICMName = iCMName;
	}
	public String getICMEmail() {
		return ICMEmail;
	}
	public void setICMEmail(String iCMEmail) {
		ICMEmail = iCMEmail;
	}
	public String getICMContact() {
		return ICMContact;
	}
	public void setICMContact(String iCMContact) {
		ICMContact = iCMContact;
	}
	public String getGCDMName() {
		return GCDMName;
	}
	public void setGCDMName(String gCDMName) {
		GCDMName = gCDMName;
	}
	public String getGCDMEmail() {
		return GCDMEmail;
	}
	public void setGCDMEmail(String gCDMEmail) {
		GCDMEmail = gCDMEmail;
	}
	public String getGCDMContact() {
		return GCDMContact;
	}
	public void setGCDMContact(String gCDMContact) {
		GCDMContact = gCDMContact;
	}
	public String getSIBSMName() {
		return SIBSMName;
	}
	public void setSIBSMName(String sIBSMName) {
		SIBSMName = sIBSMName;
	}
	public String getSIBSMEmail() {
		return SIBSMEmail;
	}
	public void setSIBSMEmail(String sIBSMEmail) {
		SIBSMEmail = sIBSMEmail;
	}
	public String getSIBSMContact() {
		return SIBSMContact;
	}
	public void setSIBSMContact(String sIBSMContact) {
		SIBSMContact = sIBSMContact;
	}


	private String SIBSMContact;
	
	public int getReopenCount() {
		return reopenCount;
	}
	public void setReopenCount(int reopenCount) {
		this.reopenCount = reopenCount;
	}
	public int getDaysCount() {
		return daysCount;
	}
	public void setDaysCount(int days) {
		this.daysCount = daysCount;
	}
	public int getSolvedCount() {
		return solvedCount;
	}
	public void setSolvedCount(int solvedCount) {
		this.solvedCount = solvedCount;
	}
	public int getClosedCount() {
		return closedCount;
	}
	public void setClosedCount(int closedCount) {
		this.closedCount = closedCount;
	}
	public int getCancelledCount() {
		return cancelledCount;
	}
	public void setCancelledCount(int cancelledCount) {
		this.cancelledCount = cancelledCount;
	}

	private int greaterSixty;
	public int getGreaterSixty() {
		return greaterSixty;
	}
	public void setGreaterSixty(int greaterSixty) {
		this.greaterSixty = greaterSixty;
	}


	int twofiveCount=0,sixfifCount=0,fifthirteenCount=0,greaterthirtyCount=0;
	public int getTwofiveCount() {
		return twofiveCount;
	}
	public void setTwofiveCount(int twofiveCount) {
		this.twofiveCount = twofiveCount;
	}
	public int getSixfifCount() {
		return sixfifCount;
	}
	public void setSixfifCount(int sixfifCount) {
		this.sixfifCount = sixfifCount;
	}
	public int getFifthirteenCount() {
		return fifthirteenCount;
	}
	public void setFifthirteenCount(int fifthirteenCount) {
		this.fifthirteenCount = fifthirteenCount;
	}
	public int getGreaterthirtyCount() {
		return greaterthirtyCount;
	}
	public void setGreaterthirtyCount(int greaterthirtyCount) {
		this.greaterthirtyCount = greaterthirtyCount;
	}
	public String getCluster() {
		return cluster;
	}
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	public int getBklogCount() {
		return bklogCount;
	}
	public void setBklogCount(int bklogCount) {
		this.bklogCount = bklogCount;
	}
	public int getNewCount() {
		return newCount;
	}
	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}
	public int getOnHoldClockRunningCount() {
		return onHoldClockRunningCount;
	}
	public void setOnHoldClockRunningCount(int onHoldClockRunningCount) {
		this.onHoldClockRunningCount = onHoldClockRunningCount;
	}
	public int getOnHoldClockStoppedCount() {
		return onHoldClockStoppedCount;
	}
	public void setOnHoldClockStoppedCount(int onHoldClockStoppedCount) {
		this.onHoldClockStoppedCount = onHoldClockStoppedCount;
	}
	public int getOverdueCount() {
		return overdueCount;
	}
	public void setOverdueCount(int overdueCount) {
		this.overdueCount = overdueCount;
	}

}

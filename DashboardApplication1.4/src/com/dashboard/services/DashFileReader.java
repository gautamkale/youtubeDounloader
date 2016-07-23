package com.dashboard.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Util.ConnectToDatabase;

import com.dashboard.controller.MenuAction;
import com.dashboard.model.BreachModel;
import com.dashboard.model.Dashboard;
import com.dashboard.service.impl.DashFileReaderInterface;

public class DashFileReader implements DashFileReaderInterface {

	/* (non-Javadoc)
	 * @see com.dashboard.services.DashFileReaderInterface#getBreachClusterDetails(java.lang.String)
	 */
	@Override
	public ArrayList<BreachModel> getBreachClusterDetails(String clusterName)
			throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		ArrayList<BreachModel> lst = null;
		lst = new ArrayList<BreachModel>();
		Statement statement;
		ResultSet set;

		try {
			statement = conn.createStatement();
			statement.execute("select * from  Ticket_Details");
			set = statement.getResultSet();

			while (set.next()) {
				BreachModel db = new BreachModel();

				// db.setAtosAppID(set.getString("ATOS_App_ID"));

				db.setRequestID(set.getString("Request_ID"));

				db.setRequestType(set.getString("Request_Type"));

				db.setPriority(set.getInt("Priority"));

				// db.setArrivalDate(set.getTimestamp("Arrival_Date").toString()
				// );

				// db.setItslaTargetDate(set.getTimestamp("IT_SLA_Target_Date")
				// .toString());

				db.setArrivalDate(set.getString("Arrival_Date"));

				// db.setItslaTargetDate(set.getString("IT_SLA_Target_Date"));

				db.setCluster(set.getString("Cluster"));

				System.out.println("Request ID" + set.getString("Request_ID"));
				lst.add(db);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.DashFileReaderInterface#get2HrBreachList(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> get2HrBreachList(String callerName)
			throws SQLException {
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {

			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();
			if (callerName.equals("Incident")) {
				// System.out.println("check boy");
				statement
						.execute("select * from  Ticket_Details2 where (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)<=2) AND (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)>=0) and Request_Type='Incident'");
				System.out.println("check boy@@@@@@" + strDate);
			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details2 where (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)<=2) AND (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)>=0) and Request_Type='Service Request'");
			} else {
				statement
						.execute("select * from  Ticket_Details2 where (DateDiff('H',#"+ strDate + "#,SLA_Target_Date)<=2) AND (DateDiff('H',#"
								+ strDate + "#,SLA_Target_Date)>=0)");
			}
			// statement.execute("select DateDiff('H',#"+strDate+"#,IT_SLA_Target_Date) as hour from  Ticket_Details");
			set = statement.getResultSet();
			/*
			 * while(set.next()) {
			 * System.out.println("hr difference@@@@@@@"+set.getInt(1)); }
			 */

			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setTicketNumber(set.getString("Ticket_Number"));
				db.setArrivalDate(set.getString("Arrival_Date"));
				//db.setRequestType(set.getString("Request_Type"));
				//db.setBreached(set.getString("Breached_Tickets"));
				db.setBusinessServiceName(set.getString("Business_Service_Name"));
				db.setCaller(set.getString("Caller"));
				db.setCallState(set.getString("Call_State"));
				db.setIncidentDesc(set.getString("Incident_Desc"));
				//db.setCluster(set.getString("Cluster"));
				db.setItServiceName(set.getString("IT_Service_Name"));
				db.setItslaTargetDate(set.getString("SLA_Target_Date"));
				db.setAssignmentGroup(set.getString("Assignment_Group"));
			//	db.setResolvingService(set.getString("Resolving_Service_Provider"));
				//db.setAutomaticFlow(set.getString("Automatic_Flow"));
				db.setIncidentNumber(set.getString("Incident_Number"));
				/*db.setMadeSla(set.getString("Made_SLA"));
				db.setResolveDate(set.getString("Resolved_Date"));
				db.setOverdue(set.getString("Overdue"));
				db.setOpenSinceDays(set.getString("Open_Since"));
				db.setReferenceTicket(set.getString("Reference"));
				db.setSlaVi0lation(set.getString("SLA_Violation"));
				db.setMonthOfCreation(set.getString("MonthOfResolution"));
				db.setMonthOfResolution(set.getString("MonthOfCreation"));*/
				db.setPriority(set.getInt("Priority"));

				lst.add(db);
				System.out.println(lst+"..........2hr list");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}
	@Override
	public ArrayList<Dashboard> get2HrBreachList(String callerName,String clusterName)
			throws SQLException {
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {

			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();
			if (callerName.equals("Incident")) {
				// System.out.println("check boy");
				statement
						.execute("select * from  Ticket_Details2 where (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)<=2) AND (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)>=0) and Request_Type='Incident' and Cluster='"+clusterName+"'");
				System.out.println("check boy@@@@@@" + strDate);
			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details2 where (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)<=2) AND (DateDiff('H',#"
								+ strDate
								+ "#,SLA_Target_Date)>=0) and Request_Type='Service Request' and Cluster='"+clusterName+"'");
			} else {
				statement.execute("select * from  Ticket_Details2");
				System.out.println("select * from  Ticket_Details2 where (DateDiff('H',#"+ strDate + "#,SLA_Target_Date)<=2) AND (DateDiff('H',#"
								+ strDate + "#,SLA_Target_Date)>=0) and Cluster='"+clusterName+"'");
			}
			// statement.execute("select DateDiff('H',#"+strDate+"#,IT_SLA_Target_Date) as hour from  Ticket_Details");
			set = statement.getResultSet();
			/*
			 * while(set.next()) {
			 * System.out.println("hr difference@@@@@@@"+set.getInt(1)); }
			 */

			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setTicketNumber(set.getString("Ticket_Number"));
				db.setArrivalDate(set.getString("Arrival_Date"));
				//db.setRequestType(set.getString("Request_Type"));
				//db.setBreached(set.getString("Breached_Tickets"));
				db.setBusinessServiceName(set.getString("Business_Service_Name"));
				db.setCaller(set.getString("Caller"));
				db.setCallState(set.getString("Call_State"));
				db.setIncidentDesc(set.getString("Incident_Desc"));
				//db.setCluster(set.getString("Cluster"));
				db.setItServiceName(set.getString("IT_Service_Name"));
				db.setItslaTargetDate(set.getString("SLA_Target_Date"));
				db.setAssignmentGroup(set.getString("Assignment_Group"));
			//	db.setResolvingService(set.getString("Resolving_Service_Provider"));
				//db.setAutomaticFlow(set.getString("Automatic_Flow"));
				db.setIncidentNumber(set.getString("Incident_Number"));
				/*db.setMadeSla(set.getString("Made_SLA"));
				db.setResolveDate(set.getString("Resolved_Date"));
				db.setOverdue(set.getString("Overdue"));
				db.setOpenSinceDays(set.getString("Open_Since"));
				db.setReferenceTicket(set.getString("Reference"));
				db.setSlaVi0lation(set.getString("SLA_Violation"));
				db.setMonthOfCreation(set.getString("MonthOfResolution"));
				db.setMonthOfResolution(set.getString("MonthOfCreation"));*/
				db.setPriority(set.getInt("Priority"));
					System.out.println(db.getBusinessServiceName());
				lst.add(db);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.DashFileReaderInterface#getBreachList(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getBreachList(String callerName)
			throws SQLException {
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where IT_SLA_Target_Date < #"
								+ strDate
								+ "# and (Status <> 'Closed' AND Status <>'Cancelled' AND Status<>'Solved' ) and Team <>'NOLS Support Desk - Atos' and GSC_Function <> 'T3. Advanced Application Support' and Service_Request  Not Like 'Minor Enhancement%' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where IT_SLA_Target_Date < #"
								+ strDate
								+ "# and (Status <> 'Closed' AND Status <>'Cancelled' AND Status<>'Solved' ) and Team <>'NOLS Support Desk - Atos' and GSC_Function <> 'T3. Advanced Application Support' and Service_Request  Not Like 'Minor Enhancement%' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select * from  Ticket_Details where IT_SLA_Target_Date < #"
								+ strDate
								+ "# and (Status <> 'Closed' AND Status <>'Cancelled' AND Status<>'Solved' ) and Team <>'NOLS Support Desk - Atos' and GSC_Function <> 'T3. Advanced Application Support' and Service_Request  Not Like 'Minor Enhancement%' ");
			}

			set = statement.getResultSet();

			while (set.next()) {
				Dashboard db = new Dashboard();

				db.setAtosAppID(set.getString("ATOS_App_ID"));

				db.setApplication(set.getString("Application"));

				db.setRequestID(set.getString("Request_ID"));

				db.setRequestType(set.getString("Request_Type"));

				db.setPriority(set.getInt("Priority"));

				db.setArrivalDate(set.getString("Arrival_Date"));

				db.setItslaTargetDate(set.getString("IT_SLA_Target_Date"));

				db.setStatus(set.getString("Status"));

				db.setIndividual(set.getString("Individual"));

				db.setGscValue(set.getString("GSC_Function"));

				db.setCluster(set.getString("Cluster"));

				db.setReopenCount(set.getInt("Reopen"));
				lst.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}

	public Dashboard getBreachDetail(String cluster, String callerName)
			throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		Dashboard db = null;
	
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				/*statement.execute("select count(*)as count   from  Ticket_Details2 where SLA_Target_Date < #"
								+ strDate
								+ "# and Status <> 'Closed'   and Cluster='"
								+ cluster
								+ "' and   Request_Type='Incident'");*/
				statement.execute("select count(*)as count   from  Ticket_Details2 where Breached_Tickets=-1 and Status <> 'Closed'   and Cluster='"
						+ cluster
						+ "' and   Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				/*statement.execute("select count(*)as count   from  Ticket_Details2 where SLA_Target_Date < #"
								+ strDate
								+ "# and Status <> 'Closed'  and Cluster='"
								+ cluster
								+ "' and Request_Type='Service Request'");*/
				statement.execute("select count(*)as count   from  Ticket_Details2 where Breached_Tickets=-1 and Status <> 'Closed'  and Cluster='"
						+ cluster
						+ "' and Request_Type='Service Request'");
			} else {
				/*statement.execute("select count(*)as count   from  Ticket_Details2 where SLA_Target_Date < #"
								+ strDate
								+ "# and Status <> 'Closed' and Cluster='"
								+ cluster
								+ "'");*/
				statement.execute("select count(*)as count   from  Ticket_Details2 where IT_SLA_Target_Date < #"
								+ strDate
								+ "# and Cluster='"
						+ cluster
						+ "'");

				// System.out.print("select count(*)as count   from  Ticket_Details where IT_SLA_Target_Date < #"+strDate+"# and Cluster='"+cluster+"' and Team <>'NOLS Support Desk - Atos' and Service_Request  Not Like 'Minor Enhancement'");
			}

			// statement.execute("select * from  Ticket_Details where Priority=1");
			set = statement.getResultSet();

			while (set.next()) {
				db = new Dashboard();

				db.setCluster(cluster);

				db.setBklogCount(set.getInt("count"));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return db;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.DashFileReaderInterface#showBreachTicket(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showBreachTicket(String callerName,String clusterName) throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;
		lst = new ArrayList<Dashboard>();
		Statement statement,statement2;
		ResultSet set,set2;
		System.out.println(callerName + " showBreachTicket im method");

		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();
			statement2 = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details2 where Breached_Tickets=-1 and Cluster='"+clusterName+"'and Status <> 'Closed'  and   Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details2 where Breached_Tickets=-1 and Cluster='"+clusterName+"' and Status <> 'Closed'  and   Request_Type='Service Request'");
			} else {
				//System.out.println("select * from  Ticket_Details2 where Breached_Tickets=-1 and Cluster='"+clusterName+"' and Status <> 'Closed' ");
				statement2.execute("select Business_Service_Name from  BS_Details where Cluster_Name='"+clusterName+"' ");
			
				set2 = statement2.getResultSet();
				while (set2.next()) {
					Dashboard db1 = new Dashboard();
					db1.setBusinessServiceName(set2.getString("Business_Service_Name"));
					System.out.println(db1.getBusinessServiceName());
					statement.execute("select * from  Ticket_Details2 where SLA_Target_Date < #"
								+ strDate+ "# and  Business_Service_Name='"+db1.getBusinessServiceName().trim()+"'");
					set = statement.getResultSet();
					while (set.next()) {
						
						Dashboard db = new Dashboard();

						db.setTicketNumber(set.getString("Ticket_Number"));
						db.setArrivalDate(set.getString("Arrival_Date"));
						//db.setRequestType(set.getString("Request_Type"));
						//db.setBreached(set.getString("Breached_Tickets"));
						db.setBusinessServiceName(set.getString("Business_Service_Name"));
						db.setCaller(set.getString("Caller"));
						db.setCallState(set.getString("Call_State"));
						db.setIncidentDesc(set.getString("Incident_Desc"));
						//db.setCluster(set.getString("Cluster"));
						db.setItServiceName(set.getString("IT_Service_Name"));
						db.setItslaTargetDate(set.getString("SLA_Target_Date"));
						db.setAssignmentGroup(set.getString("Assignment_Group"));
					//	db.setResolvingService(set.getString("Resolving_Service_Provider"));
						//db.setAutomaticFlow(set.getString("Automatic_Flow"));
						db.setIncidentNumber(set.getString("Incident_Number"));
						/*db.setMadeSla(set.getString("Made_SLA"));
						db.setResolveDate(set.getString("Resolved_Date"));
						db.setOverdue(set.getString("Overdue"));
						db.setOpenSinceDays(set.getString("Open_Since"));
						db.setReferenceTicket(set.getString("Reference"));
						db.setSlaVi0lation(set.getString("SLA_Violation"));
						db.setMonthOfCreation(set.getString("MonthOfResolution"));
						db.setMonthOfResolution(set.getString("MonthOfCreation"));*/
						db.setPriority(set.getInt("Priority"));
							System.out.println(db.getBusinessServiceName());
						lst.add(db);
						
					}
						
				}
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}
	@Override
	public ArrayList<Dashboard> showBreachTicket(String callerName) throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;
		lst = new ArrayList<Dashboard>();
		Statement statement;
		ResultSet set;
		System.out.println(callerName + "im method");

		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details2 where Breached_Tickets=-1 and Status <> 'Closed'  and   Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details2 where Breached_Tickets=-1  and Status <> 'Closed'  and   Request_Type='Service Request'");
			} else {
				System.out.println("in query..." + callerName);
				statement
						.execute("select * from  Ticket_Details2 where Breached_Tickets=-1  and Status <> 'Closed' ");
			}
			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setTicketNumber(set.getString("Ticket_Number"));
				db.setArrivalDate(set.getString("Arrival_Date"));
				//db.setRequestType(set.getString("Request_Type"));
				//db.setBreached(set.getString("Breached_Tickets"));
				db.setBusinessServiceName(set.getString("Business_Service_Name"));
				db.setCaller(set.getString("Caller"));
				db.setCallState(set.getString("Call_State"));
				db.setIncidentDesc(set.getString("Incident_Desc"));
				//db.setCluster(set.getString("Cluster"));
				db.setItServiceName(set.getString("IT_Service_Name"));
				db.setItslaTargetDate(set.getString("SLA_Target_Date"));
				db.setAssignmentGroup(set.getString("Assignment_Group"));
			//	db.setResolvingService(set.getString("Resolving_Service_Provider"));
				//db.setAutomaticFlow(set.getString("Automatic_Flow"));
				db.setIncidentNumber(set.getString("Incident_Number"));
				/*db.setMadeSla(set.getString("Made_SLA"));
				db.setResolveDate(set.getString("Resolved_Date"));
				db.setOverdue(set.getString("Overdue"));
				db.setOpenSinceDays(set.getString("Open_Since"));
				db.setReferenceTicket(set.getString("Reference"));
				db.setSlaVi0lation(set.getString("SLA_Violation"));
				db.setMonthOfCreation(set.getString("MonthOfResolution"));
				db.setMonthOfResolution(set.getString("MonthOfCreation"));*/
				db.setPriority(set.getInt("Priority"));

				lst.add(db);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.DashFileReaderInterface#getTodaysTargetList(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getTodaysTargetList(String callerName)
			throws SQLException {
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
			Date now = new Date();
			String strDate = sdfDate.format(now);
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where IT_SLA_Target_Date >= #"
								+ strDate + "# and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where IT_SLA_Target_Date >= #"
								+ strDate
								+ "# and Request_Type='Service Request'");
			} else {
				statement
						.execute("select * from  Ticket_Details where IT_SLA_Target_Date >= #"
								+ strDate + "#");
			}

			// statement.execute("select * from  Ticket_Details where Priority=1");

			set = statement.getResultSet();

			while (set.next()) {
				Dashboard db = new Dashboard();

				db.setAtosAppID(set.getString("ATOS_App_ID"));

				db.setApplication(set.getString("Application"));

				db.setRequestID(set.getString("Request_ID"));

				db.setRequestType(set.getString("Request_Type"));

				db.setPriority(set.getInt("Priority"));

				db.setArrivalDate(set.getString("Arrival_Date"));

				db.setItslaTargetDate(set.getString("IT_SLA_Target_Date"));

				db.setStatus(set.getString("Status"));

				db.setIndividual(set.getString("Individual"));

				db.setGscValue(set.getString("GSC_Function"));

				db.setCluster(set.getString("Cluster"));

				db.setReopenCount(set.getInt("Reopen"));

				lst.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.DashFileReaderInterface#readDashboardFile(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> readDashboardFile(String callerName)
			throws SQLException {

		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement.execute("select * from  Ticket_Details where Priority=1 and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement.execute("select * from  Ticket_Details where Priority=1 and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement.execute("select * from  Ticket_Details where Priority=1 and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			// statement.execute("select Arrival_Date from  Ticket_Details where Cluster='"+clusterName+"'");
			set = statement.getResultSet();

			
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setAtosAppID(set.getString("ATOS_App_ID"));

				db.setApplication(set.getString("Application"));

				db.setRequestID(set.getString("Request_ID"));

				db.setRequestType(set.getString("Request_Type"));

				db.setPriority(set.getInt("Priority"));

				db.setArrivalDate(set.getString("Arrival_Date"));

				db.setItslaTargetDate(set.getString("IT_SLA_Target_Date"));

				db.setStatus(set.getString("Status"));

				db.setIndividual(set.getString("Individual"));

				db.setGscValue(set.getString("GSC_Function"));

				db.setCluster(set.getString("Cluster"));
				db.setReopenCount(set.getInt("Reopen"));
				lst.add(db);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return lst;
	}

	public Dashboard getOverdueTicketDetail(String cluster, String callerName)
			throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		Dashboard db = null;
	
		try {
			
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement.execute("select count(*)as count   from  Ticket_Details2 where Overdue=-1 and Status <> 'Closed'   and Cluster='"
						+ cluster
						+ "' and   Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement.execute("select count(*)as count   from  Ticket_Details2 where  Overdue=-1 and Status <> 'Closed'  and Cluster='"
						+ cluster
						+ "' and Request_Type='Service Request'");
			} else {
				statement.execute("select count(*)as count   from  Ticket_Details2 where  Overdue=-1 and Status <> 'Closed' and Cluster='"
						+ cluster
						+ "'");

			}
			set = statement.getResultSet();

			while (set.next()) {
				db = new Dashboard();

				db.setCluster(cluster);

				db.setOverdueCount(set.getInt("count"));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return db;
	}

	@Override
	public boolean validatingUser(String user, String passwd)
			throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		MenuAction ac=new MenuAction();
		Statement statement;
		String username=null;
		String pass = null;
		ResultSet set;
		try {
			
			statement = conn.createStatement();

			statement.execute("select *from  user where  user='"+user+"' and password= '"+passwd+"'");

			
			set = statement.getResultSet();
			
			while (set.next()) {
				username=set.getString("user");
				pass=set.getString("password");
			}

			if(username!=null && pass!=null)
			{
				return true;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}

	@Override
	public ArrayList<Dashboard> getClusterBSList(String clusterName)
			throws SQLException {
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {
			statement = conn.createStatement();

		
				statement.execute("select * from BS_Details where Cluster_Name='"+clusterName+"'");
			

		
			set = statement.getResultSet();

			
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setBusinessServiceName(set.getString("Business_Service_Name"));
				db.setP1P2(set.getInt("P1_P2"));
				db.setP3P4(set.getInt("P3_P4"));
				db.setSr(set.getInt("SR"));
				db.setFpr(set.getInt("FPR"));
					db.setOverdueCount(set.getInt("Overdue"));
				db.setBklogCount(set.getInt("Backlog"));

				
				lst.add(db);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return lst;
	}

	@Override
	public ArrayList<Dashboard> getBSList(String clusterName)
			throws SQLException {
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		ResultSet set;
		try {
			statement = conn.createStatement();

		
				statement.execute("select Business_Service_Name from BS_Details where Cluster_Name='"+clusterName+"'");
			

		
			set = statement.getResultSet();

			
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setBusinessServiceName(set.getString("Business_Service_Name"));
					
				lst.add(db);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return lst;
	}

	@Override
	public String updateBs(String bsName,int p1p2, int p3p4, int sr, int fpr)
			throws SQLException {
		ConnectToDatabase condb = new ConnectToDatabase();
		Connection conn = condb.DBConnnect();
		Statement statement;
		String str=null;
		
		try {
			statement = conn.createStatement();

		
				statement.execute("update BS_Details set P1_P2="+p1p2+",P3_P4="+p3p4+",SR="+sr+",FPR="+fpr+" where Business_Service_Name='"+bsName+"' ");
				str="updated";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			str="error";
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return str;
	}

}

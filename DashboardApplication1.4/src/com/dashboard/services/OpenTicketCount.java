package com.dashboard.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Util.ConnectToDatabase;

import com.dashboard.model.Dashboard;
import com.dashboard.service.impl.OpenTicketCountInterface;

public class OpenTicketCount implements OpenTicketCountInterface {

	ConnectToDatabase condb = new ConnectToDatabase();

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#ticketCounter(java.lang.String, com.dashboard.model.Dashboard, java.lang.String)
	 */
	@Override
	public Dashboard ticketCounter(String clusterName, Dashboard db,
			String callerName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = condb.DBConnnect();
		int p1count = 0, p2count = 0, p3count = 0, p4count = 0;
		Statement statement;
		ResultSet set = null;
		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=1 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Incident' ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=1 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=1 AND Cluster='"
								+ clusterName
								+ "'");
			}

			set = statement.getResultSet();
			set.next();
			p1count = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=2 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Incident' ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=2 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request' ");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=2 AND Cluster='"
								+ clusterName
								+ "'");
			}
			
			set = statement.getResultSet();
			set.next();
			p2count = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=3 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Incident' ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=3 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request' ");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=3 AND Cluster='"
								+ clusterName
								+ "' ");
			}

			set = statement.getResultSet();
			set.next();
			p3count = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=4 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Incident' ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=4 AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request' ");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Priority=4 AND Cluster='"
								+ clusterName
								+ "' ");
			}

			set = statement.getResultSet();
			set.next();
			p4count = set.getInt("count");
			//System.out.println("priority coubnrtt......."+p1count+"-+"+p2count+"--"+p3count+"--"+p4count+"---"+clusterName);
			db.setP1Count(p1count);
			db.setCluster(clusterName);
			db.setP2Count(p2count);
			db.setP3Count(p3count);
			db.setP4Count(p4count);

			System.out.println("priority coubnrtt......."+p1count+"-+"+p2count+"--"+p3count+"--"+p4count+"---"+clusterName);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}
		return db;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#statusCounter(java.lang.String, com.dashboard.model.Dashboard, java.lang.String)
	 */
	@Override
	public Dashboard statusCounter(String clusterName, Dashboard db,
			String callerName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = condb.DBConnnect();
		int assignedCount = 0, wipCount = 0, newCount = 0, clockStopCount = 0, closedCount = 0, clockRunningCount = 0;

		Statement statement;
		ResultSet set = null;
		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Assigned' AND Cluster='"
								+ clusterName + "' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Assigned' AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Assigned' AND Cluster='"
								+ clusterName + "'");
			}

			set = statement.getResultSet();
			set.next();
			assignedCount = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Work In Progress' AND Cluster='"
								+ clusterName + "' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Work In Progress' AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Work In Progress' AND Cluster='"
								+ clusterName + "'");
			}

			set = statement.getResultSet();
			set.next();
			wipCount = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='New' AND Cluster='"
								+ clusterName + "' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='New' AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='New' AND Cluster='"
								+ clusterName + "'");
			}

			set = statement.getResultSet();
			set.next();
			newCount = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='On Hold - Clock Stopped' AND Cluster='"
								+ clusterName + "' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='On Hold - Clock Stopped' AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='On Hold - Clock Stopped' AND Cluster='"
								+ clusterName + "'");
			}

			set = statement.getResultSet();
			set.next();
			clockStopCount = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Closed' AND Cluster='"
								+ clusterName + "' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Closed' AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='Closed' AND Cluster='"
								+ clusterName + "'");
			}

			set = statement.getResultSet();
			set.next();
			closedCount = set.getInt("count");

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='On Hold - Clock Running' AND Cluster='"
								+ clusterName + "' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='On Hold - Clock Running' AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select Count(*) AS count from Ticket_Details2 where Status='On Hold - Clock Running' AND Cluster='"
								+ clusterName + "'");
			}

			set = statement.getResultSet();
			set.next();
			clockRunningCount = set.getInt("count");
			db.setCluster(clusterName);
			db.setAssignedCount(assignedCount);
			db.setWipCount(wipCount);
			db.setNewCount(newCount);
			db.setOnHoldClockStoppedCount(clockStopCount);
			db.setClosedCount(closedCount);
			db.setOnHoldClockRunningCount(clockRunningCount);

			// System.out.println("priority coubnrtt......."+assignedCount
			// +"-+"+wipCount +"--"+pendingCount +"--"+solvedCount
			// +"---"+closedCount+"---"+cancelledCount+"=="+clusterName);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return db;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#ageCounter(java.lang.String, com.dashboard.model.Dashboard, java.lang.String)
	 */
	@Override
	public Dashboard ageCounter(String clusterName, Dashboard db,
			String callerName) throws ParseException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = condb.DBConnnect();

		int twofiveCount = 0, sixfifCount = 0, fifthirteenCount = 0, greaterthirtyCount = 0, greatSixty = 0;

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);

		Statement statement = null;
		ResultSet set = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// statement.execute("select Arrival_Date from Ticket_Details where Cluster='"+clusterName+"'")
			// ;
			// set = statement.getResultSet();

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=5) and Request_Type='Incident'and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=5) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=5) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			set = statement.getResultSet();

			set.next();
			twofiveCount = set.getInt("count");
			// System.out.println("2 to 5 count...."+twofiveCount);
			db.setCluster(clusterName);
			db.setTwofiveCount(twofiveCount);

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=10) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=10) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=10) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			set = statement.getResultSet();
			set.next();
			sixfifCount = set.getInt("count");
			// System.out.println("6 to 10 count...."+sixfifCount);

			db.setSixfifCount(sixfifCount);

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>10 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=15) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>10 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=15) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>10 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=15) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			set = statement.getResultSet();
			set.next();
			fifthirteenCount = set.getInt("count");
			// System.out.println("15 to 30 count...."+fifthirteenCount);

			db.setFifthirteenCount(fifthirteenCount);

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>15 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=30) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>15 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=30) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>15 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=30) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			set = statement.getResultSet();
			set.next();
			greaterthirtyCount = set.getInt("count");
			// System.out.println("30 to 60 count...."+greaterthirtyCount);

			db.setGreaterthirtyCount(greaterthirtyCount);

			if (callerName.equals("Incident")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>30) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>30) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select Count(*) AS count from  Ticket_Details where Cluster='"
								+ clusterName
								+ "' AND ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>30) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			set = statement.getResultSet();
			set.next();
			greatSixty = set.getInt("count");
			// System.out.println(">30...."+greatSixty);

			db.setGreaterSixty(greatSixty);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			set.close();
			conn.close();
		}

		return db;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showTicketDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showTicketDetail(String clusterName,
			String prio, String callerName) throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();
		int priority = Integer.parseInt(prio);

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where Priority="
								+ priority
								+ " AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where Priority="
								+ priority
								+ " AND Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select * from  Ticket_Details where Priority="
								+ priority
								+ " AND Cluster='"
								+ clusterName
								+ "' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			}

			set = statement.getResultSet();
			while (set.next()) {
				Dashboard db = new Dashboard();

				db.setAtosAppID(set.getString("ATOS_App_ID"));

				db.setApplication(set.getString("Application"));

				db.setRequestID(set.getString("Request_ID"));

				db.setRequestType(set.getString("Request_Type"));

				db.setPriority(set.getInt("Priority"));

				// db.setArrivalDate(set.getTimestamp("Arrival_Date").toString()
				// );

				// db.setItslaTargetDate(set.getTimestamp("IT_SLA_Target_Date")
				// .toString());

				db.setArrivalDate(set.getString("Arrival_Date"));

				db.setItslaTargetDate(set.getString("IT_SLA_Target_Date"));
				db.setStatus(set.getString("Status"));

				db.setIndividual(set.getString("Individual"));

				db.setGscValue(set.getString("GSC_Function"));

				db.setCluster(set.getString("Cluster"));

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showTicketStatusDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showTicketStatusDetail(String clusterName,
			String prio, String callerName) throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();
		int priority = Integer.parseInt(prio);

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select  Status, (select count(*) FROM Ticket_Details a WHERE   Priority="
								+ priority
								+ " AND Cluster='"
								+ clusterName
								+ "' and  a.Status= tick.Status  and Request_Type='Incident and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled' ) from  Ticket_Details tick group by Status  ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select  Status, (select count(*) FROM Ticket_Details a WHERE   Priority="
								+ priority
								+ " AND Cluster='"
								+ clusterName
								+ "' and  a.Status= tick.Status and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') from  Ticket_Details tick group by Status  ");
			} else {
				statement
						.execute("select  Status, (select count(*) FROM Ticket_Details a WHERE   Priority="
								+ priority
								+ " AND Cluster='"
								+ clusterName
								+ "' and  a.Status= tick.Status and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled' ) from  Ticket_Details tick where Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled' group by Status  ");
			}

			set = statement.getResultSet();
			while (set.next()) {
				Dashboard db = new Dashboard();

				db.setStatus(set.getString(1));

				db.setCount(set.getInt(2));

				// System.out.println(db.getStatus()+".............."+db.getCount());

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showStatusDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showStatusDetail(String clusterName,
			String stat, String callerName) throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();
		String status = stat;

		Statement statement;
		ResultSet set;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where Status='"
								+ status + "' AND Cluster='" + clusterName
								+ "'  and Request_Type='Incident'  ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where Status='"
								+ status + "' AND Cluster='" + clusterName
								+ "'and Request_Type='Service Request'");
			} else {
				statement
						.execute("select * from  Ticket_Details where Status='"
								+ status + "' AND Cluster='" + clusterName
								+ "'");
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
	 * @see com.dashboard.services.OpenTicketCountInterface#showStatusPriorityDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showStatusPriorityDetail(String clusterName,
			String stat, String callerName) throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();
		String status = stat;

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select Priority, (select Count(*) from Ticket_Details a where  Status='"
								+ status
								+ "' AND Cluster='"
								+ clusterName
								+ "' and a.Priority=tick.Priority and Request_Type='Incident' ) from  Ticket_Details tick group by Priority");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select Priority, (select Count(*) from Ticket_Details a where  Status='"
								+ status
								+ "' AND Cluster='"
								+ clusterName
								+ "' and a.Priority=tick.Priority  and Request_Type='Service Request'  ) from  Ticket_Details tick group by Priority");
			} else {
				statement
						.execute("select Priority, (select Count(*) from Ticket_Details a where  Status='"
								+ status
								+ "' AND Cluster='"
								+ clusterName
								+ "' and a.Priority=tick.Priority  ) from  Ticket_Details tick group by Priority");
			}

			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setPriority(set.getInt(1));

				db.setCount(set.getInt(2));

				// System.out.println(db.getPriority()+"........"+db.getCount());

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showAgeDetail(java.lang.String, int, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showAgeDetail(String clusterName, int strCount,
			String callerName) throws ParseException, SQLException {
		Connection conn = condb.DBConnnect();

		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		Statement statement;
		ResultSet set = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);

		if (strCount == 1) {
			try {
				statement = conn.createStatement();
				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		}

		else if (strCount == 2) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else if (strCount == 3) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else if (strCount == 4) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Request_Type='Service Request'and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showAgeStatusPriorityDetail(java.lang.String, int, java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<Integer>> showAgeStatusPriorityDetail(
			String clusterName, int strCount, String callerName)
			throws ParseException, SQLException {
		Connection conn = condb.DBConnnect();

		ArrayList<Integer> statuslst = new ArrayList<Integer>();
		ArrayList<Integer> prilst = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		int assCnt = 0, pendCnt = 0, wipCnt = 0, p1Cnt = 0, p2Cnt = 0, p3Cnt = 0, p4Cnt = 0, p1wipCnt = 0, p2wipCnt = 0, p3wipCnt = 0, p4wipCnt = 0, p1pendCnt = 0, p2pendCnt = 0, p3pendCnt = 0, p4pendCnt = 0;
		Statement statement;
		ResultSet set = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);

		if (strCount == 1) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Request_Type='Incident'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Request_Type='Service Request'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate + "#)<=5)");
				}

				// statement.execute("select Arrival_Date from  Ticket_Details where Cluster='"+clusterName+"'");
				set = statement.getResultSet();

				while (set.next()) {

					Dashboard db = new Dashboard();

					db.setPriority(set.getInt("Priority"));

					db.setStatus(set.getString("Status"));
					if (db.getStatus().equals("Assigned")) {
						assCnt++;
						if (db.getPriority() == 1) {
							p1Cnt++;
						} else if (db.getPriority() == 2) {
							p2Cnt++;
						} else if (db.getPriority() == 3) {
							p3Cnt++;
						} else if (db.getPriority() == 4) {
							p4Cnt++;
						}

					} else if (db.getStatus().equals("WIP")) {
						wipCnt++;
						if (db.getPriority() == 1) {
							p1wipCnt++;
						} else if (db.getPriority() == 2) {
							p2wipCnt++;
						} else if (db.getPriority() == 3) {
							p3wipCnt++;
						} else if (db.getPriority() == 4) {
							p4wipCnt++;
						}
					} else if (db.getStatus().equals("Pending")) {
						pendCnt++;
						if (db.getPriority() == 1) {
							p1pendCnt++;
						} else if (db.getPriority() == 2) {
							p2pendCnt++;
						} else if (db.getPriority() == 3) {
							p3pendCnt++;
						} else if (db.getPriority() == 4) {
							p4pendCnt++;
						}
					}

				}
				statuslst.add(assCnt);
				statuslst.add(pendCnt);
				statuslst.add(wipCnt);
				prilst.add(p1Cnt);
				prilst.add(p2Cnt);
				prilst.add(p3Cnt);
				prilst.add(p4Cnt);
				prilst.add(p1pendCnt);
				prilst.add(p2pendCnt);
				prilst.add(p3pendCnt);
				prilst.add(p4pendCnt);
				prilst.add(p1wipCnt);
				prilst.add(p2wipCnt);
				prilst.add(p3wipCnt);
				prilst.add(p4wipCnt);

				list.add(statuslst);
				list.add(prilst);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		}

		else if (strCount == 2) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Request_Type='Incident'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Request_Type='Service Request'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate + "#)<=10)");
				}

				// statement.execute("select Arrival_Date from  Ticket_Details where Cluster='"+clusterName+"'");
				set = statement.getResultSet();

				while (set.next()) {

					Dashboard db = new Dashboard();

					db.setPriority(set.getInt("Priority"));

					db.setStatus(set.getString("Status"));
					if (db.getStatus().equals("Assigned")) {
						assCnt++;
						if (db.getPriority() == 1) {
							p1Cnt++;
						} else if (db.getPriority() == 2) {
							p2Cnt++;
						} else if (db.getPriority() == 3) {
							p3Cnt++;
						} else if (db.getPriority() == 4) {
							p4Cnt++;
						}

					} else if (db.getStatus().equals("WIP")) {
						wipCnt++;
						if (db.getPriority() == 1) {
							p1wipCnt++;
						} else if (db.getPriority() == 2) {
							p2wipCnt++;
						} else if (db.getPriority() == 3) {
							p3wipCnt++;
						} else if (db.getPriority() == 4) {
							p4wipCnt++;
						}
					} else if (db.getStatus().equals("Pending")) {
						pendCnt++;
						if (db.getPriority() == 1) {
							p1pendCnt++;
						} else if (db.getPriority() == 2) {
							p2pendCnt++;
						} else if (db.getPriority() == 3) {
							p3pendCnt++;
						} else if (db.getPriority() == 4) {
							p4pendCnt++;
						}
					}

				}
				statuslst.add(assCnt);
				statuslst.add(pendCnt);
				statuslst.add(wipCnt);
				prilst.add(p1Cnt);
				prilst.add(p2Cnt);
				prilst.add(p3Cnt);
				prilst.add(p4Cnt);
				prilst.add(p1pendCnt);
				prilst.add(p2pendCnt);
				prilst.add(p3pendCnt);
				prilst.add(p4pendCnt);
				prilst.add(p1wipCnt);
				prilst.add(p2wipCnt);
				prilst.add(p3wipCnt);
				prilst.add(p4wipCnt);

				list.add(statuslst);
				list.add(prilst);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else if (strCount == 3) {
			try {
				statement = conn.createStatement();
				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>10 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Request_Type='Incident'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>10 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Request_Type='Service Request'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>10 AND DateDiff('D',Arrival_Date,#"
									+ strDate + "#)<=15)");
				}

				// statement.execute("select Arrival_Date from  Ticket_Details where Cluster='"+clusterName+"'");
				set = statement.getResultSet();

				while (set.next()) {

					Dashboard db = new Dashboard();

					db.setPriority(set.getInt("Priority"));

					db.setStatus(set.getString("Status"));
					if (db.getStatus().equals("Assigned")) {
						assCnt++;
						if (db.getPriority() == 1) {
							p1Cnt++;
						} else if (db.getPriority() == 2) {
							p2Cnt++;
						} else if (db.getPriority() == 3) {
							p3Cnt++;
						} else if (db.getPriority() == 4) {
							p4Cnt++;
						}

					} else if (db.getStatus().equals("WIP")) {
						wipCnt++;
						if (db.getPriority() == 1) {
							p1wipCnt++;
						} else if (db.getPriority() == 2) {
							p2wipCnt++;
						} else if (db.getPriority() == 3) {
							p3wipCnt++;
						} else if (db.getPriority() == 4) {
							p4wipCnt++;
						}
					} else if (db.getStatus().equals("Pending")) {
						pendCnt++;
						if (db.getPriority() == 1) {
							p1pendCnt++;
						} else if (db.getPriority() == 2) {
							p2pendCnt++;
						} else if (db.getPriority() == 3) {
							p3pendCnt++;
						} else if (db.getPriority() == 4) {
							p4pendCnt++;
						}
					}

				}
				statuslst.add(assCnt);
				statuslst.add(pendCnt);
				statuslst.add(wipCnt);
				prilst.add(p1Cnt);
				prilst.add(p2Cnt);
				prilst.add(p3Cnt);
				prilst.add(p4Cnt);
				prilst.add(p1pendCnt);
				prilst.add(p2pendCnt);
				prilst.add(p3pendCnt);
				prilst.add(p4pendCnt);
				prilst.add(p1wipCnt);
				prilst.add(p2wipCnt);
				prilst.add(p3wipCnt);
				prilst.add(p4wipCnt);

				list.add(statuslst);
				list.add(prilst);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else if (strCount == 4) {
			try {
				statement = conn.createStatement();
				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>15 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Request_Type='Incident'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>15 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Request_Type='Service Request'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>15 AND DateDiff('D',Arrival_Date,#"
									+ strDate + "#)<=30)");
				}

				// statement.execute("select Arrival_Date from  Ticket_Details where Cluster='"+clusterName+"'");
				set = statement.getResultSet();

				while (set.next()) {

					Dashboard db = new Dashboard();

					db.setPriority(set.getInt("Priority"));

					db.setStatus(set.getString("Status"));
					if (db.getStatus().equals("Assigned")) {
						assCnt++;
						if (db.getPriority() == 1) {
							p1Cnt++;
						} else if (db.getPriority() == 2) {
							p2Cnt++;
						} else if (db.getPriority() == 3) {
							p3Cnt++;
						} else if (db.getPriority() == 4) {
							p4Cnt++;
						}

					} else if (db.getStatus().equals("WIP")) {
						wipCnt++;
						if (db.getPriority() == 1) {
							p1wipCnt++;
						} else if (db.getPriority() == 2) {
							p2wipCnt++;
						} else if (db.getPriority() == 3) {
							p3wipCnt++;
						} else if (db.getPriority() == 4) {
							p4wipCnt++;
						}
					} else if (db.getStatus().equals("Pending")) {
						pendCnt++;
						if (db.getPriority() == 1) {
							p1pendCnt++;
						} else if (db.getPriority() == 2) {
							p2pendCnt++;
						} else if (db.getPriority() == 3) {
							p3pendCnt++;
						} else if (db.getPriority() == 4) {
							p4pendCnt++;
						}
					}

				}
				statuslst.add(assCnt);
				statuslst.add(pendCnt);
				statuslst.add(wipCnt);
				prilst.add(p1Cnt);
				prilst.add(p2Cnt);
				prilst.add(p3Cnt);
				prilst.add(p4Cnt);
				prilst.add(p1pendCnt);
				prilst.add(p2pendCnt);
				prilst.add(p3pendCnt);
				prilst.add(p4pendCnt);
				prilst.add(p1wipCnt);
				prilst.add(p2wipCnt);
				prilst.add(p3wipCnt);
				prilst.add(p4wipCnt);

				list.add(statuslst);
				list.add(prilst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else {
			try {
				statement = conn.createStatement();
				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30)) and Request_Type='Incident'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Request_Type='Service Request'");
				} else {
					statement
							.execute("select * from  Ticket_Details where Cluster='"
									+ clusterName
									+ "' AND  ( DateDiff('D',Arrival_Date,#"
									+ strDate + "#)>30)");
				}

				// statement.execute("select Arrival_Date from  Ticket_Details where Cluster='"+clusterName+"'");
				set = statement.getResultSet();

				while (set.next()) {

					Dashboard db = new Dashboard();

					db.setPriority(set.getInt("Priority"));

					db.setStatus(set.getString("Status"));
					if (db.getStatus().equals("Assigned")) {
						assCnt++;
						if (db.getPriority() == 1) {
							p1Cnt++;
						} else if (db.getPriority() == 2) {
							p2Cnt++;
						} else if (db.getPriority() == 3) {
							p3Cnt++;
						} else if (db.getPriority() == 4) {
							p4Cnt++;
						}

					} else if (db.getStatus().equals("WIP")) {
						wipCnt++;
						if (db.getPriority() == 1) {
							p1wipCnt++;
						} else if (db.getPriority() == 2) {
							p2wipCnt++;
						} else if (db.getPriority() == 3) {
							p3wipCnt++;
						} else if (db.getPriority() == 4) {
							p4wipCnt++;
						}
					} else if (db.getStatus().equals("Pending")) {
						pendCnt++;
						if (db.getPriority() == 1) {
							p1pendCnt++;
						} else if (db.getPriority() == 2) {
							p2pendCnt++;
						} else if (db.getPriority() == 3) {
							p3pendCnt++;
						} else if (db.getPriority() == 4) {
							p4pendCnt++;
						}
					}

				}
				statuslst.add(assCnt);
				statuslst.add(pendCnt);
				statuslst.add(wipCnt);
				prilst.add(p1Cnt);
				prilst.add(p2Cnt);
				prilst.add(p3Cnt);
				prilst.add(p4Cnt);
				prilst.add(p1pendCnt);
				prilst.add(p2pendCnt);
				prilst.add(p3pendCnt);
				prilst.add(p4pendCnt);
				prilst.add(p1wipCnt);
				prilst.add(p2wipCnt);
				prilst.add(p3wipCnt);
				prilst.add(p4wipCnt);

				list.add(statuslst);
				list.add(prilst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		}

		return list;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getReopenCount(java.lang.String, java.lang.String)
	 */
	@Override
	public Dashboard getReopenCountlst(String clustername, String callerName)
			throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = condb.DBConnnect();

		Dashboard db = new Dashboard();

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();
			if (callerName.equals("Incident")) {
				statement
						.execute("select count(*) as reopencount from  Ticket_Details where Reopen>0 and Cluster='"
								+ clustername
								+ "' and Status='Closed' and Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select count(*) as reopencount from  Ticket_Details where Reopen>0 and Cluster='"
								+ clustername
								+ "' and Status='Closed'  and Request_Type='Service Request'");
			} else {
				statement
						.execute("select count(*) as reopencount from  Ticket_Details where Reopen>0 and Cluster='"
								+ clustername + "' and Status='Closed'");
			}

			set = statement.getResultSet();
				
			set.next();
			db.setCluster(clustername);
			db.setReopenCount(set.getInt("reopencount"));
		
			// db.setRequestType(set.getString(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return db;
	}

	private char[] getReopenCount() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showReopenDetail(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showReopenDetail(String clusterName,
			String callerName) throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();
			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where Reopen > 0 and Status='Closed'  AND Cluster='"
								+ clusterName + "'and  Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where Reopen > 0 and Status='Closed'  AND  Cluster='"
								+ clusterName
								+ "'and Request_Type='Service Request'");
			} else {
				statement
						.execute("select * from  Ticket_Details where Reopen > 0 and Status='Closed'  AND Cluster='"
								+ clusterName + "'");

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
				db.setReopenCount(set.getInt("Reopen"));
				db.setGscValue(set.getString("GSC_Function"));

				db.setCluster(set.getString("Cluster"));

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showClusterDetail(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showClusterDetail(String clusterName,
			String callerName) throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where  Cluster='"
								+ clusterName
								+ "' and  Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where  Cluster='"
								+ clusterName
								+ "' and Request_Type='Service Request'");
			} else {
				statement
						.execute("select * from  Ticket_Details where  Cluster='"
								+ clusterName + "'");
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
				db.setReopenCount(set.getInt("Reopen"));
				db.setStatus(set.getString("Status"));

				db.setIndividual(set.getString("Individual"));

				db.setGscValue(set.getString("GSC_Function"));

				db.setCluster(set.getString("Cluster"));

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showAgeTotal(int, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showAgeTotal(int strCount, String callerName)
			throws ParseException, SQLException {
		Connection conn = condb.DBConnnect();

		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();
		Statement statement;
		ResultSet set = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);

		if (strCount == 1) {
			try {
				statement = conn.createStatement();
				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=0 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=5) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		}

		else if (strCount == 2) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=10) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else if (strCount == 3) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=15) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else if (strCount == 4) {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Request_Type='Service Request'and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where  ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)<=30) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		} else {
			try {
				statement = conn.createStatement();

				if (callerName.equals("Incident")) {
					statement
							.execute("select * from  Ticket_Details where   ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

				} else if (callerName.equals("Service_Request")) {
					statement
							.execute("select * from  Ticket_Details where   ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
				} else {
					statement
							.execute("select * from  Ticket_Details where    ( DateDiff('D',Arrival_Date,#"
									+ strDate
									+ "#)>30) and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
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

					lst.add(db);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				set.close();
				conn.close();
			}
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showReopenTotal(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showReopenTotal(String callerName)
			throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = condb.DBConnnect();

		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select *  from  Ticket_Details where Reopen>0 and (Status='Closed' or Status='Cancelled' or Status='Solved' ) and  Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select *  from  Ticket_Details where Reopen>0  and (Status='Closed' or Status='Cancelled' or Status='Solved' ) and Request_Type='Service Request'");
			} else {
				statement
						.execute("select *  from  Ticket_Details where Reopen>0 and (Status='Closed' or Status='Cancelled' or Status='Solved' ) ");
			}

			set = statement.getResultSet();

			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setReopenCount(set.getInt("Reopen"));
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

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showPriorityTotal(java.lang.String, java.lang.String)
	 */
	
	@Override
	public ArrayList<Dashboard> showPriorityTotal(String prio, String callerName)
			throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;
		
		lst = new ArrayList<Dashboard>();
		int priority = Integer.parseInt(prio);

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where Priority="
								+ priority
								+ "  and  Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where Priority="
								+ priority
								+ "   and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'");
			} else {
				statement
						.execute("select * from  Ticket_Details where Priority="
								+ priority
								+ " and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled' ");
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

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;
	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#showStatusTotal(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> showStatusTotal(String stat, String callerName)
			throws SQLException {
		Connection conn = condb.DBConnnect();
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();
		String status = stat;

		Statement statement;
		ResultSet set = null;

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select * from  Ticket_Details where Status='"
								+ status + "'  and  Request_Type='Incident'");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select * from  Ticket_Details where Status='"
								+ status
								+ "'    and Request_Type='Service Request'");
			} else {

				statement
						.execute("select * from  Ticket_Details where Status='"
								+ status + "' ");

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

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getBartData(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getBartData(String callerName)
			throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ArrayList<Dashboard> lst = null;

		ResultSet set = null;
		lst = new ArrayList<Dashboard>();

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select cluster,Priority,Count(*) AS count from Ticket_Details where Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'   group by  cluster,Priority  ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select cluster,Priority,Count(*) AS count from Ticket_Details where Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'  group by  cluster,Priority  ");
			} else {
				statement
						.execute("select cluster,Priority,Count(*) AS count from Ticket_Details where  Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled'   group by  cluster,Priority  ");
			}

			set = statement.getResultSet();
			while (set.next()) {
				Dashboard db = new Dashboard();

				db.setCluster(set.getString(1));
				db.setPriority(set.getInt(2));
				db.setCount(set.getInt(3));
				// System.out.println(db.getCluster()+"..................."+db.getPriority()+",,,,,,,,,,,"+db.getCount());
				lst.add(db);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getPriorityChartData(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getPriorityChartData(String callerName)
			throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ResultSet set = null;
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		try {
			statement = conn.createStatement();
			if (callerName.equals("Incident")) {
				statement
						.execute(" SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE Priority=1 and a.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as P1,(SELECT COUNT(*) FROM Ticket_Details b WHERE Priority=2 and b.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p2,  (SELECT COUNT(*) FROM Ticket_Details c WHERE Priority=3 and c.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p3,	   (SELECT COUNT(*) FROM Ticket_Details d WHERE Priority=4 and d.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p4 FROM Ticket_Details tick   group by cluster ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute(" SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE Priority=1 and a.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as P1,(SELECT COUNT(*) FROM Ticket_Details b WHERE Priority=2 and b.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p2,  (SELECT COUNT(*) FROM Ticket_Details c WHERE Priority=3 and c.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p3,	   (SELECT COUNT(*) FROM Ticket_Details d WHERE Priority=4 and d.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p4 FROM Ticket_Details tick   group by cluster ");
			} else {
				statement
						.execute(" SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE Priority=1 and a.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as P1,(SELECT COUNT(*) FROM Ticket_Details b WHERE Priority=2 and b.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p2,  (SELECT COUNT(*) FROM Ticket_Details c WHERE Priority=3 and c.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p3,	   (SELECT COUNT(*) FROM Ticket_Details d WHERE Priority=4 and d.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as p4 FROM Ticket_Details tick   group by cluster ");
			}

			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setCluster(set.getString(1));
				db.setP1Count(set.getInt(2));
				db.setP2Count(set.getInt(3));
				db.setP3Count(set.getInt(4));
				db.setP4Count(set.getInt(5));
				// System.out.println(db.getCluster()+"..................."+db.getP2Count()+",,,,,,,,,,,"+db.getP3Count()+""+db.getP4Count());
				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getStatusChartData(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getStatusChartData(String callerName)
			throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ResultSet set = null;
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute(" SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE  Status='Assigned' and a.cluster= tick.cluster and Request_Type='Incident') as Assign,(SELECT COUNT(*) FROM Ticket_Details b WHERE Status='WIP' and b.cluster= tick.cluster  and Request_Type='Incident') as WIP,  (SELECT COUNT(*) FROM Ticket_Details c WHERE Status='Pending' and c.cluster= tick.cluster  and Request_Type='Incident') as Pending FROM Ticket_Details tick   group by cluster ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute(" SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE  Status='Assigned' and a.cluster= tick.cluster and Request_Type='Service Request') as Assign,(SELECT COUNT(*) FROM Ticket_Details b WHERE Status='WIP' and b.cluster= tick.cluster and Request_Type='Service Request') as WIP,  (SELECT COUNT(*) FROM Ticket_Details c WHERE Status='Pending' and c.cluster= tick.cluster  and Request_Type='Service Request') as Pending FROM Ticket_Details tick   group by cluster ");
			} else {
				statement
						.execute(" SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE  Status='Assigned' and a.cluster= tick.cluster) as Assign,(SELECT COUNT(*) FROM Ticket_Details b WHERE Status='WIP' and b.cluster= tick.cluster) as WIP,  (SELECT COUNT(*) FROM Ticket_Details c WHERE Status='Pending' and c.cluster= tick.cluster ) as Pending FROM Ticket_Details tick   group by cluster ");
			}

			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setCluster(set.getString(1));
				db.setAssignedCount(set.getInt(2));
				db.setWipCount(set.getInt(3));
				db.setPendingCount(set.getInt(4));

				// System.out.println(db.getCluster()+"..................."+db.getAssignedCount()+",,,,,,,,,,,"+db.getWipCount()+""+db.getPendingCount());
				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getPieHighChartData(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getClusterCount(String callerName)
			throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ResultSet set = null;
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		try {
			statement = conn.createStatement();
			if (callerName.equals("Incident")) {
				statement
						.execute("select cluster, count(*) as clusterCount from ticket_details where Request_Type='Incident'  group by cluster ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select cluster, count(*) as clusterCount from ticket_details where Request_Type='Service Request'  group by cluster ");
			} else {
				statement
						.execute("select cluster, count(*) as clusterCount from ticket_details group by cluster ");
			}

			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setCluster(set.getString(1));

				db.setCount(set.getInt(2));

				// System.out.println(db.getCluster()+"..................."+db.getCount());
				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getAgeChart(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getAgeChart(String callerName)
			throws ParseException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = condb.DBConnnect();

		// System.out.println("staart");
		ArrayList<Dashboard> lst = new ArrayList<Dashboard>();

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);

		Statement statement = null;
		ResultSet set = null;

		statement = conn.createStatement();

		try {
			if (callerName.equals("Incident")) {

				statement
						.execute("SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>0 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=5) and a.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as FiveToOne,(SELECT COUNT(*) FROM Ticket_Details b WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=10) and b.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as SixToTen, (SELECT COUNT(*) FROM Ticket_Details c WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=15 ) and c.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as ElevenToFifteen,(SELECT COUNT(*) FROM Ticket_Details d WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=30) and d.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as SixteenToThirty,(SELECT COUNT(*) FROM Ticket_Details c WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>30 ) and c.cluster= tick.cluster and Request_Type='Incident' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as GreaterThirty FROM Ticket_Details tick group by cluster");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>0 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=5) and a.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as FiveToOne,(SELECT COUNT(*) FROM Ticket_Details b WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=10) and b.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as SixToTen, (SELECT COUNT(*) FROM Ticket_Details c WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=15) and c.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as ElevenToFifteen,(SELECT COUNT(*) FROM Ticket_Details d WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=30) and d.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as SixteenToThirty,(SELECT COUNT(*) FROM Ticket_Details c WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>30 ) and c.cluster= tick.cluster and Request_Type='Service Request' and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as GreaterThirty FROM Ticket_Details tick group by cluster");
			} else {
				statement
						.execute("SELECT cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>0 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=5) and a.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as FiveToOne,(SELECT COUNT(*) FROM Ticket_Details b WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=6 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=10) and b.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as SixToTen, (SELECT COUNT(*) FROM Ticket_Details c WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=11 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=15) and c.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as ElevenToFifteen,(SELECT COUNT(*) FROM Ticket_Details d WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>=16 AND DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)<=30) and d.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as SixteenToThirty,(SELECT COUNT(*) FROM Ticket_Details c WHERE ( DateDiff('D',Arrival_Date,#"
								+ strDate
								+ "#)>30 ) and c.cluster= tick.cluster and Status<>'Closed' and Status<>'Solved' and Status<>'Cancelled') as GreaterThirty FROM Ticket_Details tick group by cluster");
			}

			set = statement.getResultSet();

			while (set.next()) {
				Dashboard db = new Dashboard();

				db.setCluster(set.getString(1));
				db.setTwofiveCount(set.getInt(2));
				db.setSixfifCount(set.getInt(3));
				db.setFifthirteenCount(set.getInt(4));
				db.setGreaterthirtyCount(set.getInt(5));
				db.setGreaterSixty(set.getInt(6));
				// System.out.println(db.getCluster()+"..................."
				// +db.getTwofiveCount()
				// +"........"+db.getSixfifCount()+"......"+db.getFifthirteenCount()+"......"+
				// db.getGreaterthirtyCount()+"...."+db.getGreaterSixty());
				lst.add(db);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getKPIHighChartData(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getKPIHighChartData(String callerName)
			throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ResultSet set = null;
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);

		try {
			statement = conn.createStatement();

			if (callerName.equals("Incident")) {
				statement
						.execute("select cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE  Reopen>0  and (Status='Closed' or Status='Cancelled' or Status='Solved' )and a.cluster= tick.cluster and Request_Type='Incident') as reopen,(SELECT COUNT(*) FROM Ticket_Details b WHERE   IT_SLA_Target_Date < #"
								+ strDate
								+ "# and b.cluster= tick.cluster and Request_Type='Incident' and Status <> 'Closed' AND Status <>'Cancelled' AND Status<>'Solved'  and Team <>'NOLS Support Desk - Atos' and GSC_Function <> 'T3. Advanced Application Support' and Service_Request  Not Like 'Minor Enhancement%' ) as breach from ticket_details tick group by cluster ");

			} else if (callerName.equals("Service_Request")) {
				statement
						.execute("select cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE  Reopen>0  and (Status='Closed' or Status='Cancelled' or Status='Solved' ) and a.cluster= tick.cluster and Request_Type='Service Request') as reopen,(SELECT COUNT(*) FROM Ticket_Details b WHERE   IT_SLA_Target_Date < #"
								+ strDate
								+ "# and b.cluster= tick.cluster and Request_Type='Service Request'  and Status <> 'Closed' AND Status <>'Cancelled' AND Status<>'Solved'  and Team <>'NOLS Support Desk - Atos' and GSC_Function <> 'T3. Advanced Application Support' and Service_Request  Not Like 'Minor Enhancement%'  ) as breach from ticket_details tick group by cluster ");
			} else {
				statement
						.execute("select cluster, (SELECT COUNT(*) FROM Ticket_Details a WHERE  Reopen>0  and (Status='Closed' or Status='Cancelled' or Status='Solved' )and a.cluster= tick.cluster) as reopen,(SELECT COUNT(*) FROM Ticket_Details b WHERE   IT_SLA_Target_Date < #"
								+ strDate
								+ "# and b.cluster= tick.cluster and Status <> 'Closed' AND Status <>'Cancelled' AND Status<>'Solved'  and Team <>'NOLS Support Desk - Atos' and GSC_Function <> 'T3. Advanced Application Support' and Service_Request  Not Like 'Minor Enhancement%' ) as breach from ticket_details tick group by cluster ");
			}

			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setCluster(set.getString(1));

				db.setReopenCount(set.getInt(2));
				db.setCount(set.getInt(3));

				// System.out.println(db.getCluster()+"..................."+db.getCount()+".............."+db.getReopenCount());
				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getOwnerInfo(java.lang.String)
	 */
	@Override
	public ArrayList<Dashboard> getOwnerInfo(String appId) throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ResultSet set = null;
		ArrayList<Dashboard> lst = null;
		Dashboard db = new Dashboard();

		lst = new ArrayList<Dashboard>();

		try {
			statement = conn.createStatement();

			statement
					.execute("select * from Application_Owners where ATOS_App_ID='"
							+ appId + "' ");

			set = statement.getResultSet();
			while (set.next()) {

				db.setAtosAppID(set.getString("ATOS_App_ID"));
				db.setApplication(set.getString("Application"));
				db.setServiceWindow(set.getString("Service_Window"));
				db.setPrimarySME(set.getString("Primary_SME_Name"));
				db.setPrimaryEmail(set.getString("Primary_SME_Email"));
				db.setPrimaryContact(set.getString("Primary_SME_Contact"));
				// db.setCluster(set.getString(set.getString(1)));
				db.setSecondarySME(set.getString("Secondary_SME_Name"));
				db.setSecondaryEmail(set.getString("Secondary_SME_Email"));
				db.setSecondaryContact(set.getString("Secondary_SME_Contact"));
				db.setSMName(set.getString("Service_Manager_Name"));
				db.setSMEmail(set.getString("Service_Manager_Email"));
				db.setSMContact(set.getString("Service_Manager_Contact"));
				db.setSDMName(set.getString("India_SDM_Name"));
				db.setSDMEmail(set.getString("India_SDM_Email"));
				db.setSDMContact(set.getString("India_SDM_Contact"));
				db.setICMName(set.getString("India_Cluster_Manager_Name"));
				db.setICMEmail(set.getString("India_Cluster_Manager_Email"));
				db.setICMContact(set.getString("India_Cluster_Manager_Contact"));
				db.setGCDMName(set
						.getString("Globle_Cluster_Delivery_Manager_Name"));
				db.setGCDMEmail(set
						.getString("Globle_Cluster_Delivery_Manager_Email"));
				db.setGCDMContact(set
						.getString("Globle_Cluster_Delivery_Manager_Contact"));
				db.setSIBSMName(set.getString("SI_BSM_Name"));
				db.setSIBSMEmail(set.getString("SI_BSM_Email"));
				db.setSIBSMContact(set.getString("SI_BSM_Contact"));
				// System.out.println(db.getCluster()+"..................."+db.getCount());

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}

	/* (non-Javadoc)
	 * @see com.dashboard.services.OpenTicketCountInterface#getOwnerInfoList()
	 */
	@Override
	public ArrayList<Dashboard> getOwnerInfoList() throws SQLException {

		Connection conn = condb.DBConnnect();

		Statement statement;
		ResultSet set = null;
		ArrayList<Dashboard> lst = null;

		lst = new ArrayList<Dashboard>();

		try {
			statement = conn.createStatement();

			statement.execute("select * from Application_Owners");

			set = statement.getResultSet();
			while (set.next()) {

				Dashboard db = new Dashboard();

				db.setAtosAppID(set.getString("ATOS_App_ID"));
				db.setApplication(set.getString("Application"));
				db.setServiceWindow(set.getString("Service_Window"));
				db.setPrimarySME(set.getString("Primary_SME_Name"));
				db.setPrimaryEmail(set.getString("Primary_SME_Email"));
				db.setPrimaryContact(set.getString("Primary_SME_Contact"));
				// db.setCluster(set.getString(set.getString(1)));
				db.setSecondarySME(set.getString("Secondary_SME_Name"));
				db.setSecondaryEmail(set.getString("Secondary_SME_Email"));
				db.setSecondaryContact(set.getString("Secondary_SME_Contact"));
				db.setSMName(set.getString("Service_Manager_Name"));
				db.setSMEmail(set.getString("Service_Manager_Email"));
				db.setSMContact(set.getString("Service_Manager_Contact"));
				db.setSDMName(set.getString("India_SDM_Name"));
				db.setSDMEmail(set.getString("India_SDM_Email"));
				db.setSDMContact(set.getString("India_SDM_Contact"));
				db.setICMName(set.getString("India_Cluster_Manager_Name"));
				db.setICMEmail(set.getString("India_Cluster_Manager_Email"));
				db.setICMContact(set.getString("India_Cluster_Manager_Contact"));
				db.setGCDMName(set
						.getString("Globle_Cluster_Delivery_Manager_Name"));
				db.setGCDMEmail(set
						.getString("Globle_Cluster_Delivery_Manager_Email"));
				db.setGCDMContact(set
						.getString("Globle_Cluster_Delivery_Manager_Contact"));
				db.setSIBSMName(set.getString("SI_BSM_Name"));
				db.setSIBSMEmail(set.getString("SI_BSM_Email"));
				db.setSIBSMContact(set.getString("SI_BSM_Contact"));
				// System.out.println(db.getCluster()+"..................."+db.getCount());

				lst.add(db);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			set.close();
			conn.close();
		}

		return lst;

	}
	
	public int getTotalPrioritycount(ArrayList<Dashboard> lst, int counter)
	{
		int totalP=0;
		try{
		
		
		if(counter==1)
		{
			for(int i=0;i<lst.size();i++)
			{	
				totalP=totalP+lst.get(i).getP1Count();
				
			}	
		}else if(counter==2)
		{
			for(int i=0;i<lst.size();i++)
			{	
				totalP=totalP+lst.get(i).getP2Count();
				
			}	
		}else if(counter==3)
		{
			for(int i=0;i<lst.size();i++)
			{	
				totalP=totalP+lst.get(i).getP3Count();
				
			}	
		}else
		{
			for(int i=0;i<lst.size();i++)
			{	
				totalP=totalP+lst.get(i).getP4Count();
				
			}	
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
		return totalP;	
	}

	@Override
	public int getTotalStatusCount(ArrayList<Dashboard> lst, String stat) {
		int totals=0;
		try{
		
		
		if(stat.equals("Assigned"))
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getAssignedCount();
				
			}	
		}else if(stat.equals("Work In Progress"))
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getWipCount();
				
			}
		}else if(stat.equals("New"))
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getNewCount();
				
			}
		}else
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getClosedCount();
				
			}
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
		return totals;	
		
		
	}

	@Override
	public int getTotalBkLogAndReopenCount(ArrayList<Dashboard> lst, String str) {
		int totals=0;
		try{
		
		
		if(str.equals("backlog"))
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getBklogCount();
				System.out.println(lst.get(i).getBklogCount()+"....................");
				
			}	
		}else if(str.equals("reopen"))
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getReopenCount();
			}
		}else
		{
			for(int i=0;i<lst.size();i++)
			{	
				totals=totals+lst.get(i).getOverdueCount();
			}
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
		return totals;	
	}
	

}

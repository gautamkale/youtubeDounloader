<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- bootstrap 3.0.2 -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<!-- font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Morris chart -->
<link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
<!-- jvectormap -->
<link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet"
	type="text/css" />

<!-- DATA TABLES -->
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/datatables/dataTables.tableTools.css" rel="stylesheet" type="text/css" />
<link href="css/datatables/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
<style>
/* Example Styles for Demo */
.etabs {
	margin: 0;
	padding: 0;
}

.tab {
	display: inline-block;
	zoom: 1;
	*display: inline;
	background: #eee;
	border: solid 1px #999;
	border-bottom: none;
	-moz-border-radius: 4px 4px 0 0;
	-webkit-border-radius: 4px 4px 0 0;
}

.tab a {
	font-size: 14px;
	line-height: 2em;
	display: block;
	padding: 0 10px;
	outline: none;
}

.tab a:hover {
	text-decoration: underline;
}

.tab.active {
	background: #fff;
	padding-top: 6px;
	position: relative;
	top: 1px;
	border-color: #666;
}

.tab a.active {
	font-weight: bold;
}

.tab-container .panel-container {
	background: #fff;
	border: solid #666 1px;
	padding: 10px;
	-moz-border-radius: 0 4px 4px 4px;
	-webkit-border-radius: 0 4px 4px 4px;
}

.panel-container {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<aside class="right-side"> <!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Backlog And Overdue Data <small>show all <s:property
				value="statusAction" /> data
		</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href='<s:url action="getTicket"/>'><i
				class="fa fa-dashboard"></i> Dashboard</a></li>
		<li class="active">Backlog And Overdue Tickets</li>
	</ol>
	</section>
	<div id="tab-container" class='tab-container'>
		<ul class='etabs'>
			<li class='tab'><a href="#backlogTb">Backlog</a></li>
			<li class='tab'><a href="#overdueTb">Overdue</a></li>

		</ul>
		<div class='panel-container'>
			<div id="backlogTb" class="box-body">
				<!-- Main content -->
				<section class="content">
				<div class="row">
					<div class="col-md-6">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Overdue tickets with
									corresponding Clusters</h3>
							</div>
							<!-- /.box-header -->


							<table class="table table-bordered">
								<tr>
									<th style="width: 10px">#</th>
									<th>Cluster Name</th>
									<th>Backlog</th>
								</tr>
								<%
									int i = 0;
								%>
								<s:iterator value="backlogCount">
									<tr>
										<td><%=i++%></td>
										<td><s:property value="cluster" /></td>
										<td><s:property value="bklogCount" /></td>


									</tr>
								</s:iterator>
							</table>
						</div>
						<!-- /.box-body -->

					</div>
					<!-- /.box -->
				


				<!-- /.col -->
				<div class="col-md-6">
					<!-- DONUT CHART -->
					<div class="box box-danger">
						<div class="box-header">
							<h3 class="box-title">Pie Chart</h3>
						</div>
						<div class="box-body chart-responsive">
							<div class="chart" id="backlog-chart"
								style="height: 300px; position: relative;"></div>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->

				</div></div>
				<!-- /.col --> <!-- /.row -->


				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">All Backlog Tickets</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive">
								<table id="backlogticket"
									class="table table-bordered table-striped">
									<thead>


										<tr>
											<th>Ticket_Number</th>
											<th>Caller Name</th>
											<th>Caller State</th>
											<th>Application</th>
											<th>Cluster Name</th>
											<th>RequestType</th>
											<th>Priority</th>
											<th>ArrivalDate</th>
											<th>Incident Number</th>
											<th>Status</th>

											<th>SLATargetDate</th>

											<th>Resolved Date</th>
											<th>Breached Ticket</th>
											<th>Open Since</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="backlogTicketLst">
											<tr>
												<td><s:property value="ticketNumber" /></td>
												<td><s:property value="caller" /></td>
												<td><s:property value="callState" /></td>
												<td><s:property value="itServiceName" /></td>
												<td><s:property value="cluster" /></td>
												<td><s:property value="requestType" /></td>
												<td><s:property value="priority" /></td>
												<td><s:property value="arrivalDate" /></td>
												<td><s:property value="incidentNumber" /></td>
												<td><s:property value="status" /></td>
												<td><s:property value="itslaTargetDate" /></td>
												<td><s:property value="resolveDate" /></td>
												<td><s:property value="breached" /></td>
												<td><s:property value="openSinceDays" /></td>

											</tr>
										</s:iterator>
									</tbody>
									<tfoot>
										<tr>
											<th>Ticket_Number</th>
											<th>Caller Name</th>
											<th>Caller State</th>
											<th>Application</th>
											<th>Cluster Name</th>
											<th>RequestType</th>
											<th>Priority</th>
											<th>ArrivalDate</th>
											<th>Incident Number</th>
											<th>Status</th>

											<th>SLATargetDate</th>

											<th>Resolved Date</th>
											<th>Breached Ticket</th>
											<th>Open Since</th>
										</tr>
									</tfoot>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
				</div>










				</section>
			</div>
			<div id="overdueTb" class="box-body">
				<!-- Main content -->
				<section class="content">
				<div class="row">
					<div class="col-md-6">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Overdue tickets with
									corresponding Clusters</h3>
							</div>
							<!-- /.box-header -->


							<table class="table table-bordered">
								<tr>
									<th style="width: 10px">#</th>
									<th>Cluster Name</th>
									<th>Backlog</th>
								</tr>
								<%
									int j = 0;
								%>
								<s:iterator value="overdueCountlst">
									<tr>
										<td><%=j++%></td>
										<td><s:property value="cluster" /></td>
										<td><s:property value="overdueCount" /></td>


									</tr>
								</s:iterator>
							</table>
						</div>
						<!-- /.box-body -->

					</div>
					<!-- /.box -->
				


				<!-- /.col -->
				<div class="col-md-6">
					<!-- DONUT CHART -->
					<div class="box box-danger">
						<div class="box-header">
							<h3 class="box-title">Pie Chart</h3>
						</div>
						<div class="box-body chart-responsive">
							<div class="chart" id="overdue-chart"
								style="height: 300px; position: relative;"></div>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->

				</div></div>
				<!-- /.col --> <!-- /.row -->


				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">All Backlog Tickets</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive">
								<table id="overdueticket"
									class="table table-bordered table-striped">
									<thead>


										<tr>
											<th>Ticket_Number</th>
											<th>Caller Name</th>
											<th>Caller State</th>
											<th>Application</th>
											<th>Cluster Name</th>
											<th>RequestType</th>
											<th>Priority</th>
											<th>ArrivalDate</th>
											<th>Incident Number</th>
											<th>Status</th>

											<th>SLATargetDate</th>

											<th>Resolved Date</th>
											<th>Breached Ticket</th>
											<th>Open Since</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="overdueTicketLst">
											<tr>
												<td><s:property value="ticketNumber" /></td>
												<td><s:property value="caller" /></td>
												<td><s:property value="callState" /></td>
												<td><s:property value="itServiceName" /></td>
												<td><s:property value="cluster" /></td>
												<td><s:property value="requestType" /></td>
												<td><s:property value="priority" /></td>
												<td><s:property value="arrivalDate" /></td>
												<td><s:property value="incidentNumber" /></td>
												<td><s:property value="status" /></td>
												<td><s:property value="itslaTargetDate" /></td>
												<td><s:property value="resolveDate" /></td>
												<td><s:property value="breached" /></td>
												<td><s:property value="openSinceDays" /></td>

											</tr>
										</s:iterator>
									</tbody>
									<tfoot>
										<tr>
											<th>Ticket_Number</th>
											<th>Caller Name</th>
											<th>Caller State</th>
											<th>Application</th>
											<th>Cluster Name</th>
											<th>RequestType</th>
											<th>Priority</th>
											<th>ArrivalDate</th>
											<th>Incident Number</th>
											<th>Status</th>

											<th>SLATargetDate</th>

											<th>Resolved Date</th>
											<th>Breached Ticket</th>
											<th>Open Since</th>
										</tr>
									</tfoot>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
				</div>










				</section>
			</div>
		</div>
	</div>
	<!-- /.content --> </aside>
	<!-- /.right-side -->
	<!-- ./wrapper -->
	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<!-- DATA TABES SCRIPT -->
	<script src="js/jquery-ui-1.7.1.complete.min.js"type="text/javascript"></script>
	<%-- <script src="js/plugins/datatables/jquery.js"  type="text/javascript"></script> --%>
	<script src="js/plugins/datatables/jquery.dataTables.js"  type="text/javascript"></script>
	<script src="js/plugins/datatables/dataTables.tableTools.js"  type="text/javascript"></script>
	<script src="js/plugins/datatables/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="js/AdminLTE/app.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="js/AdminLTE/demo.js" type="text/javascript"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="js/jquery.hashchange.min.js" type="text/javascript"></script>
	<script src="js/jquery.easytabs.min.js" type="text/javascript"></script>

	<script src="http://code.highcharts.com/modules/data.js"></script>
	<script src="http://code.highcharts.com/modules/exporting.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#backlogticket").dataTable( {
                "sDom": 'T<"clear">lfrtip',
                "oTableTools": {
                    "sSwfPath": "js/plugins/datatables/copy_csv_xls_pdf.swf"
                    }
          
		    } );
		
			$("#overdueticket").dataTable({
                "sDom": 'T<"clear">lfrtip',
                "oTableTools": {
                    "sSwfPath": "js/plugins/datatables/copy_csv_xls_pdf.swf"
                    }
          
		    });
			
		
		"use strict";
			//DONUT CHART

			$('#backlog-chart')
					.highcharts(
							{
								data : {
									table : document
											.getElementById('backlogData')
								},

								chart : {
									type : 'pie',
									plotBackgroundColor : null,
									plotBorderWidth : null,
									plotShadow : false
								},
								title : {
									text : 'Cluster Ratio'
								},
								tooltip : {
									pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
								},
								plotOptions : {
									pie : {
										size : '100%',
										allowPointSelect : true,
										cursor : 'pointer',
										dataLabels : {
											enabled : true,
											color : '#000000',
											connectorColor : '#000000',
										/* format: '<b>{point.name}</b>: {point.percentage:.1f} %' */
										}
									}
								}

							});
			
			$('#overdue-chart')
			.highcharts(
					{
						data : {
							table : document
									.getElementById('overdueData')
						},

						chart : {
							type : 'pie',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : 'Cluster Ratio'
						},
						tooltip : {
							pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
						},
						plotOptions : {
							pie : {
								size : '100%',
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
								/* format: '<b>{point.name}</b>: {point.percentage:.1f} %' */
								}
							}
						}

					});
			$('#tab-container').easytabs();
			
		});
	</script>
	<table id="backlogData" style="visibility: hidden">
		<thead>
			<tr>
				<th></th>
				<th>Count</th>


			</tr>
		</thead>
		<tbody>
			<s:iterator value="backlogCount">
				<tr>
					<th><s:property value="cluster" /></th>
					<td><s:property value="bklogCount" /></td>

				</tr>
			</s:iterator>


		</tbody>
	</table>
	<table id="overdueData" style="visibility: hidden">
		<thead>
			<tr>
				<th></th>
				<th>Count</th>


			</tr>
		</thead>
		<tbody>
			<s:iterator value="overdueCountlst">
				<tr>
					<th><s:property value="cluster" /></th>
					<td><s:property value="overdueCount" /></td>

				</tr>
			</s:iterator>


		</tbody>
	</table>
</body>
</html>
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
        <link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        
        <!-- DATA TABLES -->
       <link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
		<link href="css/datatables/dataTables.tableTools.css" rel="stylesheet" type="text/css" />
		<link href="css/datatables/jquery.dataTables.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
</head>
<body>
         <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                       <s:property value="statusAction"/> Data
                        <small>show all <s:property value="statusAction"/> data</small>
                    </h1>
                     <ol class="breadcrumb">
                        <li><a href='<s:url action="getTicket"/>'><i class="fa fa-dashboard"></i> Dashboard</a></li>
                        <li class="active"><s:property value="statusAction"/></li>
                    </ol>
               </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title"><s:property value="statusAction"/> tickets with corresponding Clusters</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Cluster Name</th>
                                            <th><s:property value="statusAction"/></th>
                                           </tr><%int i=0; %>
                                           <s:iterator value="statusCounter">
                                        <tr>
                                           <td><%=i++ %></td>
                                            <td><s:property value="cluster"/></td>
                                            <s:if test="statusAction=='Assigned'">
										   <td><s:property value="assignedCount"/></td>
										</s:if>
										<s:elseif test="statusAction=='Work In Progress'">
										   <td><s:property value="wipCount"/></td>
										</s:elseif>
										<s:elseif test="statusAction=='New'">
										   <td><s:property value="newCount"/></td>
										</s:elseif>
										                                       
                                                                                      
                                        </tr>
                                     </s:iterator>
                                    </table>
                                </div><!-- /.box-body -->
                                 </div><!-- /.box -->

                            

                        </div><!-- /.col -->
                        <div class="col-md-6">
                             <!-- DONUT CHART -->
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">Pie Chart</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="status-chart" style="height: 300px; position: relative;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->

                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    <div class="row">
                        <div class="col-xs-12">
                             <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">All <s:property value="statusAction"/>Tickets</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="statusTicket" class="table table-bordered table-striped">
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
                                        <s:iterator value="statusDetaillst">
                                            <tr>
                                                <td><s:property value="ticketNumber"/></td>
                                                <td><s:property value="caller"/></td>
                                                <td><s:property value="callState"/></td>
                                                <td><s:property value="itServiceName"/></td>
                                                <td><s:property value="cluster"/></td>
                                                <td><s:property value="requestType"/></td>
                                                <td><s:property value="priority"/></td>
                                                <td><s:property value="arrivalDate"/></td>
                                                <td><s:property value="incidentNumber"/></td>
                                                <td><s:property value="status"/></td>
                                                <td><s:property value="itslaTargetDate"/></td>
                                                 <td><s:property value="resolveDate"/></td>
                                                  <td><s:property value="breached"/></td>
                                                   <td><s:property value="openSinceDays"/></td>
                                              
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
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
                            <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="js/plugins/datatables/jquery.dataTables.js"  type="text/javascript"></script>
	<script src="js/plugins/datatables/dataTables.tableTools.js"  type="text/javascript"></script>
	<script src="js/plugins/datatables/dataTables.bootstrap.js"	type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="js/AdminLTE/demo.js" type="text/javascript"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
        <script type="text/javascript">
            $(function() {
                $("#statusTicket").dataTable({
                    "sDom": 'T<"clear">lfrtip',
                    "oTableTools": {
                        "sSwfPath": "js/plugins/datatables/copy_csv_xls_pdf.swf"
                        }
              
    		    });
               
            });
            
            
            $(function() {
                "use strict";
                //DONUT CHART
               
                $('#status-chart').highcharts({
                	data: {
                        table: document.getElementById('statusData')
                    },
                    
                    chart: {
                    	type: 'pie',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: 'Cluster Ratio'
                    },
                    tooltip: {
                	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                        	size:'100%',
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                color: '#000000',
                                connectorColor: '#000000',
                              /* format: '<b>{point.name}</b>: {point.percentage:.1f} %' */
                            }
                        }
                    } 
                    
                });
            });
        </script>
        <table id="statusData" style="visibility:hidden">
								<thead>
									<tr>
										 <th></th>
										<th>Count</th>
										 
										 
									</tr>
								</thead>
								<tbody>
									<s:iterator value="statusCounter">
									<tr>
										<th><s:property value="cluster"/></th>
									    <s:if test="statusAction=='Assigned'">
										   <td><s:property value="assignedCount"/></td>
										</s:if>
										<s:elseif test="statusAction=='Work In Progress'">
										   <td><s:property value="wipCount"/></td>
										</s:elseif>
										<s:elseif test="statusAction=='New'">
										   <td><s:property value="newCount"/></td>
										</s:elseif>
											 
									</tr>
									</s:iterator>
									
									 
								</tbody>
							</table>
</body>
</html>
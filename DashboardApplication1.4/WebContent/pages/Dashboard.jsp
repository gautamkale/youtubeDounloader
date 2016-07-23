<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript' src='//cdn.jsdelivr.net/jquery.marquee/1.3.1/jquery.marquee.min.js'></script>

      <style type="text/css">
      #marquee {
  width: 300px;
  overflow: hidden;
  border: 1px solid #ccc;
  background: #ccc;
}

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
	border-radius: 4px 4px 0 0;
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
	border-radius: 0 4px 4px 4px;
}

.panel-container {
	margin-bottom: 10px;
}



</style>
      
</head>
<body>

 <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Dashboard
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Dashboard</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
				<div class="row">
			<marquee id="marquee_list">
    <div onMouseOver="document.getElementById('marquee_list').stop();" onMouseOut="document.getElementById('marquee_list').start();"> 
    	</div></marquee>
				
				</div>
                    <!-- Small boxes (Stat box) -->
                    <div class="row">
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">
                                    <h3>
                                    <s:url action="getPriorityDetail" var="urlTag1" >
    								<s:param name="priority">1</s:param>
    								</s:url>

                                  <s:property value="totalP1"/>
                                    </h3>
                                    <p>
                                    Today's P1
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag1" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3>
                                     <s:url action="getPriorityDetail" var="urlTag2" >
    								<s:param name="priority">2</s:param>
										</s:url>
                                      <s:property value="totalP2"/>
                                    </h3>
                                    <p>
                                        Today's P2
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag2" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3>
                `                      <s:url action="getPriorityDetail" var="urlTag3" >
    								<s:param name="priority">3</s:param>
										</s:url>
										 <s:property value="totalP3"/>
                                    </h3>
                                    <p>
                                        Today's P3
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag3" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-aqua">
                                <div class="inner">
                                    <h3>
                                      <s:url action="getPriorityDetail" var="urlTag4" >
    								<s:param name="priority">4</s:param>
										</s:url>
                                    <s:property value="totalP4"/>
                                    </h3>
                                    <p>
                                       Today's P4
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag4" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                    </div><!-- /.row -->
						
					   <!-- Small boxes (Stat box) for status -->
                    <div class="row">
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-aqua">
                                <div class="inner">
                                    <h3>
                                    <s:url action="getStatusDetail" var="urlTag5" >
    								<s:param name="statusAction">Assigned</s:param>
    								</s:url>

                                     <s:property value="assignedTotal"/>
                                    </h3>
                                    <p>
                                       Today's Assigned Tickets
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag5" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3>
                                     <s:url action="getStatusDetail" var="urlTag6" >
    								<s:param name="statusAction">Work In Progress</s:param>
    								</s:url>
                                      <s:property value="wipTotal"/>
                                    </h3>
                                    <p>
                                        Today's WIP Tickets
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag6" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3>
                                      <s:url action="getStatusDetail" var="urlTag7" >
    								<s:param name="statusAction">New</s:param>
    								</s:url>
										 <s:property value="newTotal"/>
                                    </h3>
                                    <p>
                                        Today's New Tickets
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag7" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-blue">
                                <div class="inner">
                                    <h3>
                                      <s:url action="getBacklogDetail" var="urlTag8" >
    								<s:param name="blrepenAction">blrepenAction</s:param>
    								</s:url>
										 <s:property value="totalBacklog"/> / <s:property value="totalOverdue"/>
                                    </h3>
                                    <p>
                                         Breached And Overdue Tickets
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="<s:property value="#urlTag8" />" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        </div><!--
                        </div><!-- /.row -->	
						
                    <!-- Main row -->
                    <div class="row">
                                           


                            <!-- Custom tabs (Charts with tabs)-->
                            <div id="tab-container" class="nav-tabs-custom">
                               
                                <ul class="etabs">
                                    <li class='tab'><a href="#cluster-piechart">Pie</a></li>
							       <li class='tab'><a href="#cluster-ticket">Column</a></li>
                                  
                                </ul>
                                <div class="panel-container">
                                  
                                   <div id="cluster-piechart"  style="position: relative; height: 300px;"></div>
                                    <div  id="cluster-ticket" style="position: relative;min-width: 310px; height: 400px; margin: 0 auto"></div>
                                </div>
                            </div>

                            

                       <!-- right col -->
                    </div><!-- /.row (main row) -->

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
       

 <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
     <script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
      <script src="js/bootstrap.min.js" type="text/javascript"></script>
       <script src="js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="js/AdminLTE/demo.js" type="text/javascript"></script>
<script src="js/jquery.hashchange.min.js" type="text/javascript"></script>
	<script src="js/jquery.easytabs.min.js" type="text/javascript"></script>
 
       <script type="text/javascript">
$(function () {
	
    $('#cluster-ticket').highcharts({
        data: {
            table: document.getElementById('cluster-data')
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Cluster Tickets '
        },
        yAxis: {
        	 min: 10,
            allowDecimals: false,
            title: {
                text: 'No. of Tickets'
            }
        
        },
        tooltip: { 
             
        	headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
             bar: { 
            	 size:'100%',
                dataLabels: {
                    enabled: true
                }
            } 
            /* column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                }
            } */
        }
    });
    $('#cluster-piechart').highcharts({
    	data: {
            table: document.getElementById('cluster-data')
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
                  format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        } 
        
    }); 
    $('#tab-container').easytabs();
});
</script>

        <table id="cluster-data" style="visibility:hidden">
								<thead>
									<tr>
										 <th></th>
										<th>Count</th>
										 
										 
									</tr>
								</thead>
								<tbody>
									<s:iterator value="clusterChartLst">
									<tr>
										<th><s:property value="cluster"/></th>
									     <td><s:property value="count"/></td>
										
											 
									</tr>
									</s:iterator>
									
									 
								</tbody>
							</table>
</body>
</html>
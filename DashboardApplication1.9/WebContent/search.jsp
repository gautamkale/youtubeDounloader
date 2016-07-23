<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" 	href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="css/datatables/dataTables.tableTools.css" rel="stylesheet"
	type="text/css" />
<link href="css/datatables/jquery.dataTables.css" rel="stylesheet"
	type="text/css" />
<!-- Ionicons -->
<link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
<link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Morris chart -->

<!--   Theme style
         <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" /> -->
<style type="text/css">



</style>
<script>
	$(function() {
		$("#fromdate").datepicker({
			 defaultDate: "+1w",
			dateFormat : 'yy-mm-dd',
			onClose: function( selectedDate ) {
		        $( "#todate" ).datepicker( "option", "minDate", selectedDate );
		      }
						});
		$("#todate").datepicker({
			defaultDate: "+1w",
			dateFormat : 'yy-mm-dd',
				onClose: function( selectedDate ) {
			        $( "#fromdate" ).datepicker( "option", "maxDate", selectedDate );
			      }}).val();

		$("#search").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "getCompletList",
					type : "POST",
					data : {
						term : request.term

					},
					dataType : "json",
					success : function(jsonResponse) {

						response(jsonResponse.termlist.slice(0, 10));
					}

				});
			}
		});

		$(".table-responsive").hide();

	});
	function check() {
		$(".table-responsive").hide();
		var s=document.getElementById("search").value;
		var f= document.getElementById("fromdate").value;
		var t=document.getElementById("todate").value;
	
		if(s=='' && f=='' && t== '')
			{
			alert("Atleast one Field value is required");
			return false;
			}
		else{	
		
		$("#searchresult").dataTable({
			"sPaginationType" : "full_numbers",
			"bProcessing" : false,
			"bServerSide" : false,
			"sAjaxSource" : "getSearchData",
			"fnServerParams" : function(aoData) {

				aoData.push({
					"name" : "tno",
					"value" : document.getElementById("search").value
				}, {
					"name" : "fromDate",
					"value" : document.getElementById("fromdate").value
				}, {
					"name" : "toDate",
					"value" : document.getElementById("todate").value
				}

				);

			},

			//"bJQueryUI" : true,
			"aoColumns" : [ {
				"mData" : "ticketNumber"
			}, {
				"mData" : "businessServiceName"
			}, {
				"mData" : "itServiceName"
			}, {
				"mData" : "caller"
			}, {
				"mData" : "callState"
			}, {
				"mData" : "assignmentGroup"
			}, {
				"mData" : "arrivalDate"
			}, {
				"mData" : "incidentDesc"
			}, {
				"mData" : "incidentNumber"
			}, {
				"mData" : "itslaTargetDate"
			}

			],
			"bDestroy" : true,
			"sDom" : 'T<"clear">lfrtip',
			"oTableTools" : {
				"sSwfPath" : "js/plugins/datatables/copy_csv_xls_pdf.swf"
			}

		});
		$(".table-responsive").show();

	}
	}
</script>





</head>
<body>
	<!-- <table>
<tr>
<td>Ticket No.</td>
<td><input type="text" name="tno"></td>
</tr>
<tr>
<td>
</table> -->
  <aside class="right-side">
  
   <section class="content-header">
                    <h1>
                      Search Data
                        
                    </h1>
                     <ol class="breadcrumb">
                        <li><a href='<s:url action="getTicket"/>'><i class="fa fa-dashboard"></i> Dashboard</a></li>
                        <li class="active">Search</li>
                    </ol>
               </section>
	<section class="content">
	<div id="wide" style="height: 570px;" align="center">
		<center>
			
			<table style="padding-left: 50px">
				<tr style="height: 20px;"></tr>
				<tr>
					<td style="width: 15%"></td>
					<td align="center" style="width: 15%"><span
						class="filter-label" style="margin-left: 0px; font-size: 12px;"><b><s:textfield  value= "%{tno}" 
									name="tno" label="Ticket no." id="search" /> </b></span></td>
					<td style="width: 30%"></td>
					<td style="width: 20%"><span class="filter-label"
						style="margin-left: 0px; font-size: 12px;"><b><s:textfield
									 name="fromDate" label="From Date" id="fromdate" /> </b></span></td>
					<td style="width: 20%"><span
						style="margin-left: 0px; font-size: 12px;"><b><s:textfield
									name="toDate" label="To Date" id="todate"
									cssClass="filter-label" /> </b></span></td>
				</tr>
				<tr style="height: 50px;"></tr>
				<tr>
					<td><button id="searchbutton" class="btn btn-success btn-lg"
							onclick="check();">Search</button></td>
				</tr>
			</table>
		   <div class="box">
		    <div class="box-header">
                                    <h3 class="box-title">Search Result</h3>
                                </div>
			<div   class="box-body table-responsive" >
				<table id="searchresult" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Ticket Number</th>
							<th>Application</th>
							<th>IT Service Name</th>
							
							<th>Caller Name</th>
							<th>Caller State</th>
							<th>Assignment Group</th>
							<th>ArrivalDate</th>
							<th>Incident Desc</th>
								
							
							<th>Incident Number</th>
							

							<th>SLATargetDate</th>

						
							
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Ticket Number</th>
							<th>Application</th>
							<th>IT Service Name</th>
							
							<th>Caller Name</th>
							<th>Caller State</th>
							<th>Assignment Group</th>
							<th>ArrivalDate</th>
							<th>Incident Desc</th>
								
							
							<th>Incident Number</th>
							

							<th>SLATargetDate</th>
						</tr>
					</tfoot>
				</table>
			</div>
			</div>
		</center>
	</div>
	
	</section>
	</aside>
	
	<script src="js/plugins/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="js/plugins/datatables/dataTables.tableTools.js"
		type="text/javascript"></script>
	<script src="js/plugins/datatables/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="js/AdminLTE/app.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="js/AdminLTE/demo.js" type="text/javascript"></script>


</body>
</html>
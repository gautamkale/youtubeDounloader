<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<HEAD>
<TITLE>upload form</TITLE>

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
<link href="css/datatables/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
<link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type="text/javascript">
/* function ch()
{
	//alert("helo"+name);

    // Get the Login Name value and trim it
 var x=document.forms["validate"]["filname"].value;
    alert("helo"+x);
    // Check if empty of not
    if (name  === '') {
        alert('Select Valid File.');
        return false;
    }
    return false;
    } */
    
$(document).ready(function(){
	$("#bstable").hide();
	$("#UpdateValue").hide();
	var list;
	var getVal=null;
	//alert("hi")
	$("#searchbutton").click(function() {
		$("#bstable").find("tr:gt(0)").remove();
	
								
								var clName=		$('#clvalue option:selected').text();					
															
								$.post('showTable', { clName: clName}, 
									    function(returnedData){
									         getval=returnedData.clusterDetailsList1.length;
									         alert("in  value"+getVal);
for(var i=0;i<returnedData.clusterDetailsList1.length;i++)
	    	  {
	$("#bstable tbody")
				.append(
						"<tr>"	+"<td id='bs_"+i+"'>"+returnedData.clusterDetailsList1[i].businessServiceName+"</td>"
								 
								+ "<td><input type='text' name='p1p2' id='p1p2_"+i+"' value="+returnedData.clusterDetailsList1[i].p1P2+"></td>"
								+ "<td><input type='text' name='p3p4' id='p3p4_"+i+"' value="+returnedData.clusterDetailsList1[i].p3P4+"></td>"
								+ "<td><input type='text' name='sr' id='sr_"+i+"' value="+returnedData.clusterDetailsList1[i].sr+"></td>"
								+ "<td><input type='text' name='fpr' id='fpr_"+i+"' value="+returnedData.clusterDetailsList1[i].fpr+"></td>"
								+ "<td><input type='button' id='UpdateValue_"+i+"'onclick='getId(this)' class='btn btn-success btn-lg' value='Update'></td>"
															
								+ "</tr>");
	    	  }
$("#bstable").show();


									});
	
										
																
											}); 
	

	

	
	
	
	});
    function getId(ide)
    {
    	//alert(ide.id);
    	var text=ide.id;
    	
    	var c=text.slice(-1);
    	alert("values r"+$("#p1p2_"+c).val());
    	$.post('updateTable',{ bsName: (document.getElementById("bs_"+c)).innerHTML, p1p2:$("#p1p2_"+c).val(),p3p4:$("#p3p4_"+c).val(),sr:$("#sr_"+c).val(),fpr:$("#fpr_"+c).val()}, 
    		    function(returnedData){
    		alert(returnedData.rs);
    		if(returnedData.rs=="updated")
    			{
    				
    				$("#"+ide.id).prop("disabled",true);
    		
    			}
    		
    	});

    	}
   
</script>

</HEAD>


<BODY>
	<%-- <aside class="right-side">
   	<section class="content">
<s:form namespace="/" action="up" method="post" enctype="multipart/form-data"  >
    <center>
   
    <table border="2" >
	<tr><center><td colspan="2"><p align="center"><B>UPLOAD THE FILE</B><center></td></tr>
	<tr><td><b>Choose the file To Upload:</b>
	</td>
<td>  <s:file name="myFile" label="myFile" /></td></tr>
 <s:iterator value="fieldErrors.uploadFile"><s:property/></s:iterator>
<tr><td colspan="2">
<p align="right"> <s:submit value="Upload" /> </p></td></tr>
</table>
</center>
</s:form>
</section> --%>
	<%-- <section class="content-header">
                    <h1>
                      Search Data
                        
                    </h1>
                     <ol class="breadcrumb">
                        <li><a href='<s:url action="getTicket"/>'><i class="fa fa-dashboard"></i> Dashboard</a></li>
                        <li class="active">Search</li>
                    </ol>
               </section> --%>
                <aside class="right-side">
	<section class="content">
	<div id="wide"  align="center">
		<center>

			<table >
				<tr style="height: 20px;"></tr>
				<tr>
					<td style="width: 15%"></td>
					<td align="left" style="width: 15%"><span
						class="filter-label" ><b>
								<s:select label="cluster Name" headerKey="-1"
									headerValue="Select Cluster Name"
									list="#{'1':'08 CFO Capabilities', '2':'05 Deliver Capabilities', '3':'07 People Management and Support Capabilities', '4':'10 NSN Wide Capabilities'
				,'5' :'04 Service Capabilities','6' :'01 Sales and Marketing Capabilities','7' :'11 IT Infrastructure Capabilities'}"
									name="clName" value="1" cssClass="filter-label"
									id="clvalue" />
						</b></span></td>
					</tr>
				<tr style="height: 50px;"></tr>
				<tr>
					<td ><button id="searchbutton" class="btn btn-success btn-lg"
							>Search</button></td>
							
							</tr>
							<tr><td align="center" style="width: 15%"><span
						class="filter-label" ><s:form namespace="/" action="up" method="post" enctype="multipart/form-data"  >
  
   
      <s:file name="myFile" label="myFile" />
<s:iterator value="fieldErrors.uploadFile"><s:property/></s:iterator>

 <s:submit value="Upload" cssClass="btn btn-success btn-lg" />
</s:form>
</td></tr>
							
							

				
			</table>
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">
						<b style="color: #FF6D00;">Overdue Incidents </b>
					</h3>
					<div class="box-tools">
						<!-- <div class="input-group">
                                            <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                                            </div>
                                        </div> -->
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body table-responsive no-padding"
					style="position: relative; overflow: hidden; width: auto; height: 305px;">
					<form id="theForm">
					<table class="table table-hover" style="height: 175px;" id="bstable">
						<thead>
							<tr style="color: #F9EFEF; background-color: #FF6D00;">

							
                                            <th >Business Service </th>
                                            <th>P1 / P2</th>
                                            <th>P3 / P4</th>
                                            <th>SR</th>
                                            <th>FPR</th>
                                           
                                       
							</tr>
						</thead>

						<tbody >

						
						</tbody>

					</table></form>
					<td style="padding-left: 500px;"><button id="UpdateValue" class="btn btn-success btn-lg"
							>Update</button></td>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
	</section>
	</aside>



	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/AdminLTE/app.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="js/AdminLTE/demo.js" type="text/javascript"></script>
</BODY>
</HTML>

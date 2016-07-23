<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
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
        <!-- Date Picker -->
        <link href="css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
     
        
</head>
<body class="skin-blue">
         
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                <!--     <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div> -->
                    <!-- search form -->
                  
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                       
                           <a href='<s:url action="getTicket"/>'>
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">Dashboard</span>
                            </a>
                        </li> 
                        <li>
                       		
                           <a href='<s:url action="searchform"/>'>
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">Search</span>
                            </a>
                        </li> 
                         <li>
                       		 <s:url action="getClusterData" var="delivery" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@DELIVER"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@SALES"/></s:param>
    								</s:url>
                          <s:a href="%{delivery}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">Delivery Cluster</span>
                           </s:a>
                        </li> 
                        <li>
                       		 <s:url action="getClusterData" var="service" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@SERVICE"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@CFOSTRING"/></s:param>
    								</s:url>
                          <s:a href="%{service}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">Service Cluster</span>
                           </s:a>
                        </li> 
                        <li>
                       		 <s:url action="getClusterData" var="CFO" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@SERVICE"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@CFOSTRING"/></s:param>
    								</s:url>
                          <s:a href="%{CFO}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">CFO Cluster</span>
                           </s:a>
                        </li> 
                        <li>
                       		 <s:url action="getClusterData" var="People" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@PEOPLEMGMT"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@NSNWIDE"/></s:param>
    								</s:url>
                          <s:a href="%{People}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">People Management and Support  Cluster</span>
                           </s:a>
                        </li> 
                         <li>
                       		 <s:url action="getClusterData" var="IT" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@NSNWIDE"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@ITINFRA"/></s:param>
    								</s:url>
                          <s:a href="%{IT}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">IT Infrastructure Cluster</span>
                           </s:a>
                        </li> 
                         <li>
                       		 <s:url action="getClusterData" var="Sales" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@DELIVER"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@SALES"/></s:param>
    								</s:url>
                          <s:a href="%{Sales}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">Sales and Marketing Cluster</span>
                           </s:a>
                        </li> 
                         <li>
                       		 <s:url action="getClusterData" var="NSN" >
    								<s:param name="clusterName1"><s:property value="@Util.ConstantString@NSNWIDE"/></s:param>
    								<s:param name="clusterName2"><s:property value="@Util.ConstantString@ITINFRA"/></s:param>
    								</s:url>
                          <s:a href="%{NSN}">
                                <i class="fa fa-dashboard"></i> <span style=" color: #FF6D00;">NSN Wide Cluster</span>
                           </s:a>
                        </li> 
                           
                    </ul>
                    
                </section>
                <!-- /.sidebar -->
            </aside>
		
               <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- jQuery UI 1.10.3 -->
        <script src="js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <!-- datepicker -->
        <script src="js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="js/AdminLTE/dashboard.js" type="text/javascript"></script>

        <!-- AdminLTE for demo purposes -->
        <script src="js/AdminLTE/demo.js" type="text/javascript"></script>
            

</body>
</html>
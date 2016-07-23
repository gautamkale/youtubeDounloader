<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
        <meta charset="UTF-8">
        <title>NSN Dashboard</title>
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
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
   <script type="text/javascript">
 $(function() {
	         				
				$.ajax({
					url : "UploadDate",
					type : "POST",
					dataType : "json",
					success : function(jsonResponse) {
						{
						    $("#date").html(jsonResponse.timeStr);
						  }
					}

				});
			
		});

        
        
        </script>
    </head>
</head>
<body class="skin-blue"> 
   <header class="header">
            <a href='<s:url action="getTicket"/>' class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
          NOKIA 
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
               
                    <ul class="nav navbar-nav">
                    	<li> <p  style="padding-top: 9px;font-size: larger;color: #F9EFEF;">Uploaded On :</p></li>
                      <li><p id="date" style="padding-top: 9px;padding-right: 20px;font-size: larger;color: #F9EFEF;"> </p></li>
                     <li>
                      <a href='<s:url action="getTicket"/>' class="logo" style="background-color :#1570A6; color :#FFFFFF ">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
             AtoS
            </a>
                     
                     </li>
                        <!-- Messages: style can be found in dropdown.less-->
                      <%--   <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope"></i>
                                <span class="label label-success"></span>
                            </a>
                            <ul class="dropdown-menu">
                           
                            </ul>
                        </li>  --%>
                    </ul>
                </div>
            </nav>
        </header>
   <!-- jQuery 2.0.2 -->
 
         <script src="js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="js/AdminLTE/dashboard.js" type="text/javascript"></script>

        <!-- AdminLTE for demo purposes -->
        <script src="js/AdminLTE/demo.js" type="text/javascript"></script>
</body>
</html>
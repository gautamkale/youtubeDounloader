<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><tiles:insertAttribute name="title" ignore="true" />
</title>
 <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
</head>
<body >

<tiles:insertAttribute name="header" />

<!-- 			
<table>
		<tr> -->
			 <div class="wrapper row-offcanvas row-offcanvas-left">
			<tiles:insertAttribute name="menu" />

			<tiles:insertAttribute name="body" />
			</div>
		<!-- </tr>

		

	</table> -->
   
</body>
</html>
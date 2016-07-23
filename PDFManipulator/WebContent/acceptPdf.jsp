<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload file</title>
</head>
<body>
<s:form namespace="/" action="updloadPdf" method="post" enctype="multipart/form-data"  >
    <center>
   
    <table border="2" >
	<tr><center><td colspan="2"><p align="center"><B>UPLOAD THE FILE</B><center></td></tr>
	<tr><td><b>Choose the file To Upload:</b>
	</td>
<td>  <s:file name="upload" label="Upload File" /></td></tr>

<tr><td colspan="2">
<p align="right"> <s:submit value="Upload" /> </p></td></tr>
</table>
</center>
</s:form>
</body>
</html>
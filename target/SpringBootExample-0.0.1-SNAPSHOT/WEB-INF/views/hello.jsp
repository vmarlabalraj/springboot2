<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
    <head>
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Lato:400,700,700i,900" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
		<meta charset="utf-8" />
		<title>Document Management System</title>
		<link rel="stylesheet" href="css/admin.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script> 
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.jqueryui.min.js"></script>
<script src="https://cdn.datatables.net/scroller/2.0.1/js/dataTables.scroller.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css">	
<link rel="stylesheet" href="https://cdn.datatables.net/scroller/2.0.1/css/scroller.jqueryui.min.css">	
  <script src="js/temptable.js"></script>
</head>
<body>
<div id="document">
<div id="header" style="background-color: lightslategrey">
 <jsp:include page="common/header.jsp"/>
</div>
<div id="main" >
	<div class="main-container">
	<div class="container-fluid">
		<div class="main-content-wrapper">
		<div class="row ">
			<h2>Documents</h2>
			<a href="/uploaddoc"><button class="btn btn-primary" onclick=""  id="uploaddoc">Upload</button> </a>
			<button class="btn btn-primary" onclick="javascript:deleteFiles()">Delete Files</button>
		   </div>
		   <br>
			<div id="templateTableContainer">
			<jsp:include page="documenttable.jsp"></jsp:include>
			</div>
			<br>
		</div>		
	</div>
</div>
   </div>
<div style="background-color: lightslategrey">
		<footer >
			<div class="container-fluid">
				<span class="copyright" style="color: black">&copy; <c:out value="2019 Milestone Utilities. All Rights Reserved"></c:out></span>
			</div>
		</footer>
		</div>
</div>
</body>
</html>


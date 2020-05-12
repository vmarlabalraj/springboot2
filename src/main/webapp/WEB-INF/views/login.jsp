<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
    <head>
	    <meta charset="utf-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
	    <title>Document</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Lato:400,700,700i,900" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
	</head>
    <body>
		<header style="background-color: lightslategrey">
			<div class="logo-container">
				<a class="logo" href="home.htm"> <c:out value="${companyName}"></c:out></a>
			</div>
			<div class="header-title" style="display:block;padding-left:200px;">Document Management Module</div>
	
		</header>
		<div class="container back-image col-md-12 img-responsive">
				<div class="login-wrapper "  style="float: right">
					<div class="login-container">
						<div class="login-pic"><i class="fa fa-user" aria-hidden="true"></i></div>
						<div class="login-header">Document Administrator Login</div>
						<div class="login">
							<form name="loginForm" action="login.htm" method="post">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<c:if test="${not empty error}">
									<div class="error" >${error}</div>
								</c:if>
								<c:if test="${not empty message}">
									<div class="error">${message}</div>
								</c:if>
								<div class="form-group">
									<label for="username">Username:</label>
									<input type="text" class="form-control" id="username" placeholder="Username" name="username" size="20">
								</div>
								<div class="form-group">
									<label for="password">Password:</label>
									<input type="password" class="form-control" id="password" placeholder="Password" name="password" size="20">
								</div>
								<div class="actions">
									<!-- <a href="#">Forgot Password?</a>  -->
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</form>
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
    </body>
</html>
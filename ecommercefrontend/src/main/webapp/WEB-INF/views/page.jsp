
<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="resources/css" />
<spring:url var="js" value="resources/js" />
<spring:url var="images" value="resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Shopping cart - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<link href="${css}/shop-homepage.css" rel="stylesheet">
<link href="${css}/myapp.css" rel="stylesheet">
<script>
	window.menu = '${title}';
</script>
<!-- Custom theme -->
<!-- <link href="${css}/bootstrap-custom-theme.css" rel="stylesheet"> -->
</head>

<body>
	<div class="wrapper">

		<!-- Navigation Section -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Page Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="./home.jsp"%>
			</c:if>
			<c:if test="${userClickAbout == true}">
				<%@include file="./about.jsp"%>
			</c:if>
			<c:if test="${userClickContact == true}">
				<%@include file="./contact.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- JavaScript -->
		<script src="${js}/jquery-1.10.2.js"></script>
		<script src="${js}/bootstrap.js"></script>

		<!-- This js file is not responding -->
	<!--  	<script src="${js}/myapp.js"></script>-->
	</div>
</body>

</html>


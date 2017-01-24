<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List Page</title>
</head>
<body>

	<div class="container">
		<c:forEach items="${customers}" var="customer">
			<div>
				<h3>${ customer.username }</h3>
				<p>${ customer.address }</p>
				<p>${ customer.dateOfBirth }</p>
				<%-- <p><a href="<c:url value="/editCustomer" /> ">Edit</a></p> --%>
			</div>
		</c:forEach>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.horizontal-line {
	width: 100%;
	border: 1px solid green;
	height: 1px;
}

body {
	background-color: blue;
	border-radious:20px;
}

.content {
	text-align: center;
	display: inline;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<p>${product.name}</p>
		<p><h1>${product.productId}</h1></p>
		<p>${product.category}</p>
		<p>${product.unitsInStock}</p>
	</div>

	<div class="horizontal-line"></div>

	<p></p>
	<p></p>
	<p></p>
	<p></p>

</body>
</html>
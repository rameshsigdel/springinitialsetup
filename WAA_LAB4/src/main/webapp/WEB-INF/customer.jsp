<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Entry Form</title>
</head>
<body>
	<div class="container">
		  <h2>Add Customer</h2>
		  <a href="?language=en_US">Click to set English Language</a><br>
		  <a href="?language=np_NP">Click to set Nepali Language</a><br>
		  <form:form modelAttribute = "newCustomer" method = "post">
		  <table>
		  		<tr>
		  			<td><spring:message code="label.username" /></td>                    
                    <td><form:input path = "username" class = "form-control"/></td>
                    <td><form:errors path=  "username" cssStyle="color: red"/></td>
                </tr>
                <tr>
                    <td><spring:message code="label.address" text="default text"/></td>
                    <td><form:input path = "address" class = "form-control"/></td>
                    <td><form:errors path= "address" cssStyle="color: red"/></td>
                </tr>
                <tr>
                    <td><spring:message code="label.dateOfBirth" text="default text"/></td>
                    <td><form:input path = "dateOfBirth" class = "form-control"/></td>
                    <td><form:errors path= "dateOfBirth" cssStyle="color: red"/></td>
                </tr>
                <tr>
                    <td><spring:message code="label.password" text="default text"/></td>
                    <td><form:password path = "password" class = "form-control"/></td>
                    <td><form:errors path= "password" cssStyle="color: red"/></td>
                </tr>
                <tr>
                    <td><spring:message code="label.sex" text="default text"/></td>
                    <td>
	                    <form:radiobutton path= "sex" value="male"/>Male
	                    <form:radiobutton path= "sex" value="female"/>Female
	                    <form:errors path= "sex" cssStyle="color: red"/>
                    </td>
                </tr>  
          </table>   
          <input type="submit" value="Add Customer"/>   
		      
	    </form:form>
	</div>
</body>
</html>
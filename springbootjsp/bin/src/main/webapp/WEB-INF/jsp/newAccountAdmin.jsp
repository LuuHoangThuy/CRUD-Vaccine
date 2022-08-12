<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.errors {
	color: red;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Add new Product Page</h1>
		<form:form method="POST" action="/accountAdmin/save"
			modelAttribute="accountAdmin">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="user" /></td>
					<td><form:errors cssClass="errors" path="user" /></td>
				</tr>

				<tr>
					<td>Color</td>
					<td><form:input path="password" /></td>
					<td><form:errors cssClass="errors" path="password" /></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><form:input path="email" /></td>
					<td><form:errors cssClass="errors" path="email" /></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><form:input path="email" /></td>
					<td><form:errors cssClass="errors" path="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add New"></td>
				</tr>
				<form:hidden path="id" />
			</table>
		</form:form>
	</div>
</body>
</html>
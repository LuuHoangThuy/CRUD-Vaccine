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
<title>Thêm vaccine</title>
</head>
<body>
	<div align="center">
		<h1>Thêm mới</h1>
		<form:form method="POST" action="/vaccinepackage/save" modelAttribute="vaccinepackage">
			<table>
				<tr>
					<td>Tên:</td>
					<td><form:input path="name" /></td>
					<td><form:errors cssClass="errors" path="name" /></td>
				</tr>
				
				<tr>
					<td>Giá:</td>
					<td><form:input path="price" /></td>
					<td><form:errors cssClass="errors" path="price" /></td>
				</tr>
				
				<tr>
					<td>Ghi chú:</td>
					<td><form:input path="note" /></td>
					<td><form:errors cssClass="errors" path="note" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Thêm mới"></td>
				</tr>
				<form:hidden path="id" />
			</table>
		</form:form>
	</div>
</body>
</html>
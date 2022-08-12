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

form:select {
	width: 300px;
}

form:input {
	width: 300px;
}
</style>
<title>Thêm địa điểm</title>
</head>
<body>
	<div align="center">
		<h1>Thêm mới</h1>
		<form:form method="POST" action="/location/save"
			modelAttribute="location">
			<table>
				<tr>
					<td>Tên:</td>
					<td><form:input path="name" /></td>
					<td><form:errors cssClass="errors" path="name" /></td>
				</tr>

				<tr>
					<td>Quận:</td>
					<td><form:select path="districtID">
							<c:forEach items="${districts}" var="d">
								<option value="${d.id}">${d.name}</option>
							</c:forEach>
						</form:select></td>
					<td><form:errors cssClass="errors" path="districtID" /></td>
				</tr>
				
				<tr>
					<td>Phường:</td>
					<td><form:select path="wardID">
							<c:forEach items="${wards}" var="w">
								<option value="${w.id}">${w.name}</option>
							</c:forEach>
						</form:select></td>
					<td><form:errors cssClass="errors" path="wardID" /></td>
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
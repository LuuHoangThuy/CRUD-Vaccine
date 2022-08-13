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
<title>Thêm vaccine</title>
</head>
<body>
	<div align="center">
		<h1>Thêm mới</h1>
		<form:form method="POST" action="/vaccine/save"
			modelAttribute="vaccine">
			<table>
				<tr>
					<td>Tên:</td>
					<td><form:input path="name" /></td>
					<td><form:errors cssClass="errors" path="name" /></td>
				</tr>

				<tr>
					<td>Nhà sản xuất:</td>
					<td><form:input path="supplier" /></td>
					<td><form:errors cssClass="errors" path="name" /></td>
				</tr>

				<tr>
					<td>Quốc gia:</td>
					<td><form:input path="nation" /></td>
					<td><form:errors cssClass="errors" path="name" /></td>
				</tr>

				<tr>
					<td>Đơn giá (VND):</td>
					<td><form:input path="price" /></td>
					<td><form:errors cssClass="errors" path="price" /></td>
				</tr>

				<tr>
					<td>Bệnh:</td>
					<td>
						<form:select path="sick" >
							<c:forEach items="${sicks}" var="s">
								<option value="${s.name}">${s.name}</option>
							</c:forEach>
						</form:select> 
					</td>
					<td><form:errors cssClass="errors" path="sick" /></td>			
				</tr>
				
				<tr>
					<td>Url ảnh:</td>
					<td><form:input path="imgurl" /></td>
					<td><form:errors cssClass="errors" path="imgurl" /></td>
				</tr>
				
				<tr>
					<td>Tên ảnh:</td>
					<td><form:input path="imgtitle" /></td>
					<td><form:errors cssClass="errors" path="imgtitle" /></td>
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
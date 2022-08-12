<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
<meta charset="ISO-8859-1">
<title>Trang quản lý gói vaccine</title>
</head>
<body>

	<div align="center">
		<h1>Danh sách gói vaccine</h1>
		<c:if test="${not empty message }">
		${message}<br>
		</c:if>
		<a href="/vaccinepackage/addnew">Thêm mới</a><br />
		<form action="/vaccinepackage/search" method="get">
			<input type="text" name="keySearch">
			<button type="submit">Tìm kiếm</button>
		</form>
		<table border="1" style="width: 700px; text-align: center">
			<tr>
				<td>Tên</td>
				<td>Giá tiền</td>
				<td>Ghi chú</td>
				<td>Chi tiết</td>
				<td>Chỉnh sửa</td>
				<td>Xóa</td>
			</tr>
			<c:forEach items="${vaccinepackages}" var="vaccinepackage">
				<tr>
					<td>${vaccinepackage.name}</td>
					<td>${vaccinepackage.price}</td>
					<td>${vaccinepackage.note}</td>
					<td><a href="/vaccinepackage/details/${vaccinepackage.id}">Chi tiết</a></td>
					<td><a href="/vaccinepackage/edit/${vaccinepackage.id}">Chỉnh sửa</a></td>
					<td><a href="/vaccinepackage/delete/${vaccinepackage.id}">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="pagination">
			<c:if test="${currentPage > 1}">
				<a href="/vaccine?page=${currentPage - 1}">Previous</a>
			</c:if>

			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<a class="active">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="/vaccine?page=${i}">${i}></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage lt totalPages}">
				<a href="/vaccine?page=${currentPage + 1}">Next</a>
			</c:if>
		</div>
	</div>
</body>
</html>
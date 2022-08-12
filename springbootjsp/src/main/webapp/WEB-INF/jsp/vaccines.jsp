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
<title>Trang quản lý vaccine</title>
</head>
<body>
	
	<div align="center">
		<h1>Danh sách vaccine</h1>
		<c:if test="${not empty message }">
		${message}<br>
		</c:if>
		<a href="/vaccine/addnew">Thêm mới</a>
		<a href="/vaccine/addnew">Nhập vaccine</a><br />
		<form action="/vaccine/search" method="get">
			<input type="text" name="keySearch">
			<button type="submit">Tìm kiếm</button>
		</form>
		<table border="1" style="width: 700px; text-align: center">
			<tr>
				<td>Tên</td>
				<td>Nhà sản xuất</td>
				<td>Quốc gia</td>
				<td>Đơn giá (VND)</td>
				<td>Bệnh</td>
				<td>Ghi chú</td>
				<td>Chỉnh sửa</td>
				<td>Xóa</td>
			</tr>
			<c:forEach items="${vaccines}" var="vaccine">
				<tr>
					<td>${vaccine.name}</td>
					<td>${vaccine.supplier}</td>
					<td>${vaccine.nation}</td>
					<td>${vaccine.price}</td>
					<td>${vaccine.sick}</td>
					<td>${vaccine.note}</td>
					<td><a href="/vaccine/edit/${vaccine.id}">Chỉnh sửa</a></td>
					<td><a href="/vaccine/delete/${vaccine.id}">Xóa</a></td>
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
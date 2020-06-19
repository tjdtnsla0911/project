<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>꿀잼</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<br />
	<div class="justify-content-center">
		<div class="container">
			<button class="btn btn-secondary" onclick="first()">처음으로</button>
			<button class="btn btn-secondary" onclick="priceSort()">가격순</button>
			<button class="btn btn-secondary" onclick="countSort()">판매순</button>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>종류</th>
						<th>가격</th>
						<th>판매수</th>
					
					</tr>
				</thead>
				<tbody id="table">
					<c:forEach var="product" items="${products}">
						<tr class="productitem__${product.id}">
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.type}</td>
							<td>${product.price}</td>
							<td>${product.count}</td>
							<td><button onclick="itemDelete(${product.id})">삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<script src="/fruit/js/product.js"></script>

</body>


</html>
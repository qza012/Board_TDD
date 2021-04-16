<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<style></style>
	</head>
	<body>
	<h1>Hell</h1>
		<table class="table table-hover">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
				<td>${board.idx }</td>
				<td><a href="detail?idx=${board.idx}">${board.subject }</a></td>
				<td>${board.user_name }</td>
				<td>${board.bhit }</td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="location.href='writeForm'">글 쓰기</button>
	</body>
	<script></script>
</html>
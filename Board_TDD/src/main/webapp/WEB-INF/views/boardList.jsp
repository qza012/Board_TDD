<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style></style>
	</head>
	<body>
		<table>
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
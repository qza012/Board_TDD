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
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.user_name}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.content }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.bhit }</td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="location.href='updateForm?idx=${board.idx }'">수정</button></td>
			</tr>
		</table>
		<button onclick="location.href='/board'">목록</button>
	</body>
	<script></script>
</html>
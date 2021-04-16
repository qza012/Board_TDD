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
		<form action="write" method="POST">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject"/></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="user_name"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><button>저장</button></td>
				</tr>
			</table>
		</form>
		<button onclick="location.href='/board'">목록</button>
	</body>
	<script></script>
</html>
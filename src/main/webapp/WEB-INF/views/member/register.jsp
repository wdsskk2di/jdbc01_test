<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="/WEB-INF/views/default/header.jsp"/>		

<div style="margin: 0 auto;">
	<h3>회원등록</h3>
	<form action="save">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="text" name="pw" placeholder="비밀번호">
			<hr style="width: 200px;">
		<input type="submit" value="회원가입">
	</form>
</div>

<c:import url="/WEB-INF/views/default/footer.jsp"/>		

</body>
</html>
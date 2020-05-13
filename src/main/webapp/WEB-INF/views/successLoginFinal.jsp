<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.div_login{margin-bottom: 500px;}
</style>

</head>
<body>

<c:import url="/WEB-INF/views/default/header.jsp"/>

	<div class=".div_login">
		<h3>로그인 성공! 유저: ${UserID }</h3>
	</div>
	
<c:import url="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>
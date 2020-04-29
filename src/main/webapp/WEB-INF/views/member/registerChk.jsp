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

<c:choose>
	<c:when test="${result == 1 }">
		<script type="text/javascript">alert("회원가입 성공"); location.href="login";</script>
	</c:when>
	
	<c:otherwise>
		<script type="text/javascript">alert("회원가입 실패"); location.href="register";</script>
	</c:otherwise>
</c:choose>

</body>
</html>
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

<script type="text/javascript">
	function loginChk() {
		if("${result}" != 0)	{<%session.setAttribute("loginSuccess", "Yes");%>}
	}
</script>

</head>
<body onload="loginChk()">

<c:import url="/WEB-INF/views/default/header.jsp"/>

<c:choose>
	<c:when test="${result != 0 }">
	<c:set scope="session" var="UserID" value="${userID }"/>
	<script type="text/javascript">location.href="successLoginFinal?id=${userID}"</script>
	</c:when>
	
	<c:otherwise>
		<script type="text/javascript">location.href="login"</script>
	</c:otherwise>
</c:choose>

<c:import url="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>
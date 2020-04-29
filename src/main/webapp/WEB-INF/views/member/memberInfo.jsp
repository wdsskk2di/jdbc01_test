<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.table_memberInfo{margin: 0 auto;}
</style>

</head>
<body>

<c:import url="/WEB-INF/views/default/header.jsp"/>
<table class="table_memberInfo" border="1">
		<tr><th>아이디</th><th>비밀번호</th></tr>
		
		<c:forEach items="${list }" var="dto">
		<tr>
			<td><a href="modify?id=${dto.id }">${dto.id }</a></td><td>${dto.pw }</td>
		</tr>
		</c:forEach>
	</table>
<c:import url="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>
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
	<div style="margin: 0 auto;">
		<h3>${list.id } 정 보</h3>
		<table class="table_memberInfo" border="1">
		<tr><th>아이디</th> <th>${list.id }</th> </tr>
		<tr><th>비밀번호</th> <th>${list.pw }</th> </tr>
		</table>
		<br>
		<button onclick="location.href='memberInfo'">뒤로</button>
	</div>	
<c:import url="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>
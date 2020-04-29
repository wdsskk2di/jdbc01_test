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
		<h3>${list.id } 정 보 수 정</h3>
		<form action="modifySave">
		아이디: <input type="text" name="id" value="${list.id }" readonly="readonly"><br>
		비밀번호: <input type="text" name="pw" value="${list.pw }"><br><br>
		<input type="submit" value="수정"> &nbsp;&nbsp; 
		<a href="memberInfo">목록보기</a> &nbsp;&nbsp; 
		<a href="delete?id=${list.id }">삭제하기</a>
		</form>
	</div>	

<c:import url="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>
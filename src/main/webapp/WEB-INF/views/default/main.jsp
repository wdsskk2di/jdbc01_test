<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 .div_main{height: 150px;  text-align: center; text-align: center;}
 span{position:absolute; margin-left: 50px;}
</style>

</head>
<body>

<c:import url="../default/header.jsp"/>

<div class=".div_main">
<b>내 사전에 불가능은 없다.<br>
불가능은 소극적인 자의 환영이며<br>
비겁한 자의 도피처이다.</b><br><br>

<span><b>-나폴레옹</b></span>
<br>
</div>

<c:import url="../default/footer.jsp"/>

</body>
</html>
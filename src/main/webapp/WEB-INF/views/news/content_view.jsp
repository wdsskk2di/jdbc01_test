<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/*기본 CSS 및 모바일*/
	#wrap_newsDetail{display: flex; flex-flow: column; margin: 0 auto; width: 80%; max-width: 1200px;}
	form {margin: 0 auto;}
	/*테이블 내부 선*/
	#intableHr{background-color: black;}
	/*테이블 내부 제목 링크*/
	#intableA{text-decoration: none; color: black; font-weight: bold;}
	
	/*PC용 CSS*/
	@media all and (min-width:960px){		
	#wrap_newsDetail{position:relative; width:80%;}/*위에서 설정하고 아래서 따로 설정안하면 그 설정 유지. 새로 설정하면 새로 설정한값 적용*/
	
</style>
</head>
<body>

<c:import url="/WEB-INF/views/default/header.jsp"/>	

	<div id="wrap_newsDetail" align="center">
		<form action="modify.jsp" method="post">
			<input type="hidden" name="id" value="${list.num }">
			<table>
			<tr><td><hr id="intableHr" noshade="noshade"></td></tr>
			<tr>
				<td>${list.title }</td>		
			</tr>
			<tr><td><hr id="intableHr" noshade="noshade"></td></tr>
			<tr>
				<td>
				<textarea readonly="readonly" name="content" rows="10" cols="50" style="resize: none;">${list.content }</textarea>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;"><a id="intableA" href="news">목록이동</a></td>
			</tr>	
			</table>
		</form>
	</div>
	
<c:import url="/WEB-INF/views/default/footer.jsp"/>	

</body>
</html>























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
	#wrap_news{display: flex; flex-flow: column; margin: 0 auto; width: 80%; max-width: 1200px;}
	.table_fram{text-align: center; table-layout: 80%; width:90%; font-size: 13px; margin: 0 auto;}
	
	/*테이블 내부 선*/
	#intableHr{background-color: black; height: 1px;}
	/*테이블 내부 제목 링크*/
	#intableA{text-decoration: none; color: black; }
	
	/*PC용 CSS*/
	@media all and (min-width:960px){		
	#wrap_news{position:relative; width:80%;}/*위에서 설정하고 아래서 따로 설정안하면 그 설정 유지. 새로 설정하면 새로 설정한값 적용*/
	.table_fram{text-align: center; table-layout: 80%; width:70%; font-size: 15px;}
	
</style>
</head>
<body>

<c:import url="/WEB-INF/views/default/header.jsp"/>
<div id="wrap_news">

<h2>공지사항</h2>
<table class="table_fram">
		<tr><td colspan="2"><hr id="intableHr"  noshade="noshade"></td></tr>
		<tr>	<th>No</th><th>제목</th></tr>
		<tr><td colspan="2"><hr id="intableHr"  noshade="noshade"></td></tr>	
		
		<c:forEach var="dto" items="${list }">
		<tr>
			<td id="td_center">${dto.num }</td>
			<td style="text-align: center;"><a id="intableA" href="content_view?num=${dto.num }">${dto.title }</a></td>
		</tr>
		<tr><td colspan="2"><hr></td></tr>
		</c:forEach>		
	</table>

</div>
<c:import url="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>




















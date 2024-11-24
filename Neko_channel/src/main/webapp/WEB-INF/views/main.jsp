<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nekoちゃんねる</title>
</head>
<body>
<h1>Nekoちゃんねる</h1>

<h2>🐾猫のたまり場🐾</h2>
<p>${loginUser.name}猫がログイン中...🐾</p>

<a href="Logout">退出</a><a href="Main">更新</a>

<form method="post" action="Main">
<input type="tect" name="text" placeholder="なんでもいいにゃ">
<input type="submit" value="にゃ～">
</form>

<c:if test="${not empty errorMsg}">
  <p><c:out value="${errorMsg}" /></p>
 </c:if>

<c:forEach var="mutter" items="${mutterList}">
	<p><c:out value="${mutter.userName}" />猫 :
	   <c:out value="${mutter.text}" /></p>
</c:forEach>

</body>
</html>
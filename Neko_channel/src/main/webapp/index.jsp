<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Neko channel</title>
</head>
<body>
<h1>Nekoちゃんねる</h1>

<h2>🐾Nekoちゃんねるへようこそ🐾</h2>

<p>
    ここは気軽に自由につぶやける、ゆる～い掲示板だよ！<br>
    「お腹すいた～」「今日は何食べようかな？」「週末はゴロゴロしたい...」<br>
    そんな気ままなつぶやきを猫みたいにポンっと残してみてね。
</p>

<p>
    深いことは考えず、のんびり気軽に。<br>
    つぶやいているうちに、ちょっと楽しくなるかも🐾<br>
    さぁ、あなたの「にゃー！」を届けてみよう！
</p>

<c:if test="${not empty errorMsg}">
    <p style="color: red;">${errorMsg}</p>
</c:if>
<form action="Login" method="post">
    <label for="name">猫ID</label>
    <input type="text" name="name" placeholder="Your name">
    <br>
    <label for="password">パスワード</label>
    <input type="password" name="pass" placeholder="Your password">
    <br>
    <input type="submit" value="ログイン"> 
</form>
</body>
</html>
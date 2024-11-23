<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Neko channel</title>
</head>
<body>
<h1>Nekoちゃんねる</h1>

<P>ようこそNekoちゃんねるへ<br>
    猫のように気ままに日々の何気ない物事をつぶやく為だけのシンプルで自由な掲示板です。<br>
    お腹へったな～。今日は何を食べたい！週末は何をしよう。。<br>
    どんな些細なことでもかまいません。<br>

    猫になった気分になって、気軽に猫仲間たちと会話を始めましょう。
</P>

<form action="Login" method="post">
    <label for="name">猫ID</label>
    <input type="text" name="name" placeholder="Your name">

    <label for="password">パスワード</label>
    <input type="password" name="pass" placeholder="Your password">
</form>
</body>
</html>
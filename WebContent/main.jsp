<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset="UTF-8" />
	<link rel="stylesheet" href="/css/main.css">
	<link rel="stylesheet" href="css/lightbox.css">
	<script type="text/javascript" src="js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<title>メインページ</title>
	</head>
<body>
	<h1 align="center">ようこそ！</h1>
	<script src="js/lightbox.js" type="text/javascript"></script>
	<a href="mainimages/hanabi01.jpg" data-lightbox="group"><img src="mainimages/hanabi01.jpg" width="156" /></a>
	<a href="mainimages/hanabi02.jpg" data-lightbox="group"><img src="mainimages/hanabi02.jpg" width="156" /></a>
	<a href="mainimages/hanabi03.jpg" data-lightbox="group"><img src="mainimages/hanabi03.jpg" width="156" /></a>

<s.form action="main">
<form action="Main"><input class="btn" type="submit" value="ユーザー情報"/></form>
<form action="Main-insert"><input class="btn" type="submit" value="登録情報"/></form>
<form action="Main-d3"><input class="btn" type="submit" value="グラフ"/></form>
<form action="Main-user"><input class="btn" type="submit" value="戻る"/></form>
</s.form>

<div class="iframe">
	<iframe
		src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d51828.537923993805!2d139.73790965!3d35.719242699999995!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f1!5e0!3m2!1sja!2sjp!4v1464079496419"allowfullscreen></iframe>
</div>
</body>
</html>
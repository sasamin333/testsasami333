<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<br>
	<br>
	<!-- ユーザー名とパスワードを入力 -->
	<s:form action="LoginAction">
		<s:textfield name="name" value=""
			label="%{getText('login.user')}" />
		<s:textfield name="password" value=""
			label="%{getText('login.password')}" />
		<s:submit align="left" value="%{getText('login.signIn')}" />
	</s:form>
	<br>
	<!-- 新規登録ボタン -->
	<s:form action="NewUser" theme="simple">
		<s:submit style="position: relative; left: 2px;" value="%{getText('login.new')}" />
	</s:form>
	<br>
	<s:url var="twitter" action="LoginTwitter" />
	<s:url var="facebook" action="LoginFacebook" />
	<s:url var="google" action="LoginGoogle" />

	<s:a href="%{twitter}" >
		<img src="images/twitter-j.png">
	</s:a>
	<s:a href="%{facebook}">
		<img src="images/facebook-j.png">
	</s:a>
	<s:a href="%{google}">
		<img src="images/google-j.png">
	</s:a>
</body>
</html>
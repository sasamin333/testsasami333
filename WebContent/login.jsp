<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="Login">
		<BR>
		<BR>
		<s:textfield name="name" value=""
			label="%{getText('login.user')}" />
		<s:textfield name="password" value=""
			label="%{getText('login.password')}" />
		<s:submit value="%{getText('login.signIn')}" />
		<s:submit value="%{getText('login.new')}" />
	</s:form>
	<BR>

	<s:url var="twitter" action="login-twitter" />
	<s:url var="facebook" action="login-facebook" />
	<s:url var="google" action="login-google" />

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
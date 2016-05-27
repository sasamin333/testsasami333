<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mysql</title>
</head>
<body>
	<label>追加</label>
	<s:form action="UserInsert">
		<label for="user">ユーザー名：</label>
		<Input type="text" name="user" />
		<s:property value="errorUser" />
		<br>
		<label for="password">パスワード：</label>
		<Input type="text" name="password" />
		<s:property value="errorPassword" />
		<s:submit label="追加" type="button" />
	</s:form>
	<br>
	<s:form action="NewUserBack">
		<s:submit value="ログイン画面へ戻る"/>
	</s:form>
</body>
</html>
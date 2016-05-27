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
	<s:form action="UserSelect">
		<label for="user">ユーザー名：</label>
		<Input type="text" name="user"  />
		<s:submit label="検索" type="button" />
		<s:property value="errorSelect" />
	</s:form>
	<table>
		<tr>
			<th>ID</th>
			<th>ユーザー名</th>
			<th>パスワード</th>

		</tr>
		<s:iterator value="list">
			<tr>
				<td><s:property value="id"></s:property></td>
				<td><s:property value="user"></s:property></td>
				<td><s:property value="password"></s:property></td>

			</tr>
		</s:iterator>
	</table>
	<br>
	<br>

	<label>追加</label>
	<s:form action="UserInsert">
		<label for="id">ID：</label>
		<Input type="text" name="id"  /><BR>
		<label for="user">ユーザー名：</label>
		<Input type="text" name="user"  />
		<s:property value="errorUser" /><br>
		<label for="password">パスワード：</label>
		<Input type="text" name="password"/>
		<s:property value="errorPassword" />
		<s:submit label="追加" type="button" />
	</s:form>
	<br>
	<br>


	<label>削除</label>
	<s:form action="UserDelete">
		<label for="user">ユーザー名：</label>
		<Input type="text" name="user"  />
		<s:property value="errorUser" />

		<s:submit label="削除" type="button" /><s:property value="errorDelete" />
	</s:form>
	<br>
	<br>


	<label>更新</label>
	<s:form action="UserUpdate">
		更新するIDを指定して下さい
		<s:textfield name="id" value=""
			label="　　　　　　ID"/>
		<s:textfield name="user" value=""
			label="ユーザー名"/>
		<s:textfield name="password" value=""
			label="パスワード"/>
		<br>
		<s:submit value="更新" />
		<s:property value="errorUpdate" />
	</s:form>
<BR>
<BR>
<s:form action="UserBack">
	<s:submit value="メインへ戻る"/>
</s:form>
</body>
</html>
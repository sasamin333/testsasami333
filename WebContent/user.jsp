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
	<s:form action="UserSelectAction">
		<s:submit label="データの表示" type="button" />
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
	<s:form action="UserInsertAction">
		<label for="user">ユーザー名：</label>
		<Input type="text" name="user"  />
		<s:property value="errorUser" /><br>
		<label for="password">パスワード</label>
		<Input type="text" name="password"/>
		<s:property value="errorPassword" />
		<s:submit label="追加" type="button" />
	</s:form>
	<br>
	<br>


	<label>削除</label>
	<s:form action="UserDeleteAction">
		<label for="user">ユーザー名：</label>
		<Input type="text" name="user"  />
		<s:property value="errorUser" />

		<s:submit label="削除" type="button" /><s:property value="errorDelete" />
	</s:form>
	<br>
	<br>


	<label>更新</label>
	<s:form action="UserUpdateAction">
		<label for="id">ID</label>
		<Input type="text" name="id"  /><br>
		<label for="user">ユーザー名</label>
		<Input type="text" name="user"  />
		<s:property value="errorUser" /><br>
		<label for="password">パスワード</label>
		<Input type="text" name="password"  />
		<s:property value="errorPassword" />
		<br>
		<s:submit label="更新" type="button" /><s:property value="errorUpdate" />
	</s:form>


</body>
</html>
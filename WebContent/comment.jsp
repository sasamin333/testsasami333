<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>

<meta charset="utf-8">

</head>
<body>

	<s:form name="send" action="MongoInsertAction">
		<s:textfield name="name" placeholder="名前"></s:textfield>
		<s:textarea name="comment" rows="30" cols="50" wrap="hard" />
		<s:submit  value="送信"/>
		<div>
		<s:reset  value="リセット"/>
		</div>
		</s:form>




</body>
</html>
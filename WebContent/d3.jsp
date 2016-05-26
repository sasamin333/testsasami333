<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>D3</title>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<style>
svg {
	width: 320px;
	height: 240px;
	border: 1px solid black;
}

.bar {
	fill: orange;
}
</style>
</head>
<form>
	<select onChange="top.location.href=value">
		<option value="#">MENU</option>
		<option value="main.jsp">main</option>
		<option value="d3.jsp">D3</option>
		<option value="sql.jsp">MySQL</option>
		<option value="mongo.jsp">Mongo</option>
		<option value="login.jsp">ログアウト</option>
	</select>
</form>
<body>
	<h1>データに応じてグラフを表示</h1>
	<div>
		<button data-svc="mydata1.csv">mydata1.csvを読み込み</button>
		<button data-svc="mydata1.csv">mydata2.csvを読み込み</button>
		<button data-src="mydata3.csv">mydata3.csvを読み込み</button>
	</div>
	<svg id="myGraph"></svg>
	<script src="js/d3.js"></script>

	<div class="form" align="right"></div>
	<s:form action="GoD3Action">
		<input type="text" />
		<input type="submit" value="トップページへ戻る" />
	</s:form>

</body>
</html>


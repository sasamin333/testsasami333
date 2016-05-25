<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<!-- 国際化の判別、取得-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 国際化の読み取り、設定 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CSSで書式を指定する -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="mongo.css" media="all">
<!-- bootstrapCSSを入れる -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>comment</title>
<!-- bootstrapJSを入れる -->
<script src="js/bootstrap.min.js"></script>
</head>
<body>


	<!-- コメント一覧でbootstrapによる水平・集約・色の設定 -->
	<s:div cssClass="form-holizontal form-group text-success">
		<h1>
		<!-- コメント一覧の国際化 -->
		<s:text name="comment.list"/>
		</h1>
		<!-- コメント一覧の表示設定 -->

	<!-- select表示ボタン -->
	<table>
    <s:iterator value="commentList"></s:iterator>
	</table>

    <!-- select画面表示設定 -->
<s:form action="MongoSelectAction">
		<s:submit class="btn btn-success" value="select" />
	</s:form>

	<table>
		<tbody>

			<s:iterator value="selectList">
				<tr>

					<td><s:property value="name" /></td>

					<td><s:property value="comment" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:div>
	<!--入力フォームでbootstrapによる水平処理・集約・色の設定  -->

	<!-- 送信ボタンの表示設定＆国際化 -->
	<s:div cssClass="form-holizontal form-group text-info">
	<h1>
		<s:text name="comment.form"/>
	</h1>
		<!-- 入力フォームの表示設定 -->
	</s:div>
	<s:form name="send" id="btn2" action="MongoInsertAction">
		<s:textfield name="name" placeholder="名前" onchange="wupBtn()"></s:textfield>
		<s:textarea name="comment" rows="30" cols="50" wrap="hard" onchange="wupBtn()"/>
		<s:submit class="btn btn-success" value="%{getText('comment.send')}" disabled="true"/>
		<div>
		<s:reset class="btn btn-success" value="%{getText('comment.reset')}"/>
		</div>
		</s:form>




	<br>
	<s:form id="btn2" action="MongoSelectAction">
		<!-- top.jspへのリンク -->
		<s:submit value="%{getText('comment.back')}"/>
	</s:form>
	<script type="text/javascript">


function wupBtn(){


  var name = document.send.elements[0].value;
  var comment = document.send.elements[1].value;


  if (!name || !comment) {
    document.send.elements[2].disabled=true;
  }else if (!name && !comment) {
	    document.send.elements[2].disabled=true;
  }
  else{

    document.send.elements[2].disabled=false;
  }
}



</script>
</body>
</html>
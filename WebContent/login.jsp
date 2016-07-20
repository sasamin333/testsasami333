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

<span class="yconnectLogin"></span>

<script type="text/javascript">
window.yconnectInit = function() {
    YAHOO.JP.yconnect.Authorization.init({
        button: {
            format: "image",
            type: "a",
            textType:"a",
            width: 196,
            height: 38,
            className: "yconnectLogin"
        },
        authorization: {
            clientId: " dj0zaiZpPTU4YVRpbE9tYVF3diZzPWNvbnN1bWVyc2VjcmV0Jng9MTE-",
            redirectUri: "http://www.internousdev-a.com/prototype1605/CallbackAction",
            scope: "openid email profile address",
            state: "1234",
            nonce: "456",
            windowWidth: "500",
            windowHeight: "400"
        },
        onError: function(res) {
            // エラー発生時のコールバック関数
        },
        onCancel: function(res) {
            // 同意キャンセルされた時のコールバック関数
        }
    });
};
(function(){
var fs = document.getElementsByTagName("script")[0], s = document.createElement("script");
s.setAttribute("src", "https://s.yimg.jp/images/login/yconnect/auth/1.0.3/auth-min.js");
fs.parentNode.insertBefore(s, fs);
})();
</script>
</body>
</html>
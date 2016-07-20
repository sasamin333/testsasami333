package com.internousdev.prototype1605.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import jp.co.yahoo.yconnect.YConnectExplicit;

public class CallbackAction {

	HttpServletRequest request;
	//HttpServletResponse response;
	String clientId = "dj0zaiZpPTU4YVRpbE9tYVF3diZzPWNvbnN1bWVyc2VjcmV0Jng9MTE-";
	String clientSecret = "96f5a173568783f82177883fd21b63bb53ae5255";
	String redirectUri = "http://www.internousdev-a.com/prototype1605/CallbackAction2";



	public String execute(){

		// YConnectインスタンス取得

		YConnectExplicit yconnect = new YConnectExplicit();

		/*Map<String,Object> request2 = ActionContext.getContext().getParameters();
		String value = ActionContext.getContext().getParameters().get("code").toString();*/

		HttpServletRequest request = ServletActionContext.getRequest();
		String state = (String)request.getParameter("state");// post/getパラメターの出力
		String query = request.getQueryString();
		System.out.println(query);
		// コールバックURLから各パラメーターを抽出
		System.out.println(state);



		try{
			boolean hasAuthorizationCode = yconnect.hasAuthorizationCode(query);
			System.out.println(hasAuthorizationCode);
			if(yconnect.hasAuthorizationCode(query)) {
			    // 認可コードを取得
			    /*String code = yconnect.getAuthorizationCode(state);
			    yconnect.requestToken(code, clientId, clientSecret, redirectUri);
			    // アクセストークン、リフレッシュトークン、IDトークンを取得
			    String accessTokenString = yconnect.getAccessToken();
			    String refreshToken = yconnect.getRefreshToken();*/
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


}

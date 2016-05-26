/**googleで認証を確認する為のクラス
 *
 */
package com.internousdev.prototype1605.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1605.dao.LoginOauthDAO;
import com.internousdev.prototype1605.dto.LoginOauthDTO;
import com.internousdev.prototype1605.util.GoogleOauth;
import com.opensymphony.xwork2.ActionSupport;

public class LoginGoogleAction extends ActionSupport implements
	ServletRequestAware, SessionAware {


	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = -8029318298651929295L;

	/*
	 * ネットワークネーム
	 */
	static final String NETWORK_NAME = "google";

	/*
	 * セッション
	 */
	private Map<String, Object> session;

	/*
	 * リクエスト
	 */
	private HttpServletRequest request;

	/*
	 * Google認証の実行メソッド
	 */
	public String execute(){
		String rtn = ERROR;

		GoogleOauth googleOauth = new GoogleOauth();
		Map<String,String>userMap = googleOauth.getAccessToken(request);

		if (userMap == null){
			return rtn;
		}
		String uniqueId = userMap.get("id");
		String userName = userMap.get("name");
		System.out.println(uniqueId);
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(uniqueId,NETWORK_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			session.put("loginId",dto.getUserId());
			session.put("userName",dto.getUserName());
			rtn = SUCCESS;
			return rtn;
		}

		boolean result = dao.insert(uniqueId, userName, NETWORK_NAME);
		if (!result) {
			return rtn;
		}

		dao.select(uniqueId, NETWORK_NAME);
		LoginOauthDTO dto = dao.getLoginOauthDTO();
		session.put("loginId",dto.getUserId());
		session.put("userName",dto.getUserName());
		rtn =SUCCESS;
		return rtn;
	}
	// セッションを格納するためのメソッド
	public void setSession (Map<String,Object> session){
		this.session = session;
	}
	//セッションを取得するためのメソッド
	public Map<String,Object> getSession(){
		return session;
	}
	// リクエストを取得するためのメソッド
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	/**
	 * リクエスト取得メソッド
	 */
	//public HttpServletRequest getRequest() {
	//	return request;
	//}

}

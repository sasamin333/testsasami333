package com.internousdev.prototype1605.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1605.dao.LoginOauthDAO;
import com.internousdev.prototype1605.dto.LoginOauthDTO;
import com.internousdev.prototype1605.util.FacebookOauth;
import com.opensymphony.xwork2.ActionSupport;



public class LoginFacebookAction extends ActionSupport implements SessionAware, ServletResponseAware,ServletRequestAware{

	private static final long serialVersionUID = 3914321832907213697L;

	/*
	 * ネットワーク
	 */
	static final String NETWORK_NAME = "Facebook";

	/*
	 * レスポンス
	 */
	private HttpServletRequest request;

	/*リクエスト
	 *
	 */
	private HttpServletResponse response;

	/*セッション
	 *
	 */
	private Map<String,Object> session;

	/*Facebbokの実行メソッド
	 *
	 */
	public String execute(){
		String rtn = ERROR;
		FacebookOauth FacebookOauth = new FacebookOauth();
		Map<String,String> userMap = null;
		userMap = FacebookOauth.getAccessToken(request,response);
		if(userMap == null){
			return rtn;
		}
		String uniqueId = userMap.get("id");
		String userName = userMap.get("name");
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(uniqueId, NETWORK_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			session.put("loginId", dto.getUserId());
			session.put("userName", dto.getUserName());
			rtn = SUCCESS;
			return rtn;
		}
		boolean result = dao.insert(uniqueId, userName, NETWORK_NAME);
		if (!result) {
			return rtn;
		}

		dao.select(uniqueId, NETWORK_NAME);
		LoginOauthDTO dto = dao.getLoginOauthDTO();
		session.put("loginId", dto.getUserId());
		session.put("userName", dto.getUserName());
		rtn = SUCCESS;
		return rtn;
	}
	/*
	 * リクエスト格納メソッド
	 */
			public void setServletRequest(HttpServletRequest request) {
				this.request = request;
			}
	/*
	 * レスポンス格納メソッド
	 */
			public void setServletResponse (HttpServletResponse response) {
				this.response = response;
			}
	/*
	 * セッション取得メソッド
	 */
			public Map<String, Object> getSession() {
				return session;
			}
	/*
	 * セッション格納メソッド
	 */
			public void setSession(Map<String, Object> session) {
				this.session = session;
			}
	}

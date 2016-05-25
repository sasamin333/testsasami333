/*
 * タイトル：twitterで認証を確認する為のクラス
 * 説明    ：twitterで認証を行い、セッションに情報を格納する。
 */
package com.internousdev.prototype1605.action;

import java.util.Map;

/**
 * @author MORITA NAOMI
 * @since 1.0
 * @version 1.0
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1605.dao.LoginOauthDAO;
import com.internousdev.prototype1605.dto.LoginOauthDTO;
import com.internousdev.prototype1605.util.TwitterOauth;
import com.opensymphony.xwork2.ActionSupport;

public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware
{
	/**
	 * シリアルバージョンIDの生成
	 */
	private static final long serialVersionUID = 5105580689826821879L;
	/**
	 * ネットワークネーム
	 */
	static final String NETWORK_NAME = "Twitter";
	/**
	 * セッション
	 */
	public Map<String, Object> session;
	/**
	 * レスポンス
	 */
	private HttpServletResponse response;
	/**
	 * リクエスト
	 */
	private HttpServletRequest request;
	/**
	 * Twitter認証の実行メソッド
	 */
	public String execute()
	{
		String rtn = ERROR;
		TwitterOauth twitterOauth = new TwitterOauth();
		String[] userData = new String[2];
		userData = twitterOauth.getAccessToken(request,response);

		if(userData == null)
		{
			return rtn;
		}

		String uniqueId = userData[0];
		String userName = userData[1];
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(uniqueId, NETWORK_NAME))
		{
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			session.put("userId", dto.getUserId());
			session.put("userName", dto.getUserName());
			rtn = SUCCESS;
			return rtn;
		}

		boolean result = dao.insert(uniqueId, userName, NETWORK_NAME);
		if (!result)
		{
			return rtn;
		}

		dao.select(uniqueId, NETWORK_NAME);
		LoginOauthDTO dto = dao.getLoginOauthDTO();
		session.put("userId", dto.getUserId());
		session.put("userName", dto.getUserName());
		rtn = SUCCESS;
		return rtn;
	}
	/**
	 * レスポンス格納メソッド
	 */
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}
	/**
	 * リクエスト格納メソッド
	 */
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	/**
	 * セッション格納メソッド
	 */
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
	/**
	 * セッション取得メソッド
	 */
	public Map<String, Object> getSession()
	{
		return session;
	}
	/**
	 * リクエスト取得メソッド
	 * @return request リクエスト
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * レスポンス取得メソッド
	 * @return response レスポンス
	 */
	public HttpServletResponse getResponse() {
		return response;
	}
}

/*
 * タイトル：twitterでログインする為のクラス
 * 説明    ：twitterからTokenを取得
 */

package com.internousdev.prototype1605.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.internousdev.prototype1605.util.TwitterOauth;
import com.opensymphony.xwork2.ActionSupport;

public class GoTwitterAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	/**
	 *
	 */

	/*
	 * シリアルID
	 */
	private static final long serialVersionUID = -8846984357944631780L;
	/*
	 * セッション
	 */
	private Map<String, Object> session;
	/*
	 * レスポンス
	 */
	private HttpServletResponse response;
	/*
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * TwitterリクエストToken取得メソッド
	 */
	public String execute() {
		TwitterOauth twitterOauth = new TwitterOauth();
		System.out.println(request);
		System.out.println(response);
		if (!twitterOauth.getRequestToken(request, response)) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * セッションを格納するためのメソッド
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * セッションを取得するためのメソッド
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * レスポンスを格納するためのメソッド
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * リクエストを格納するためのメソッド
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * リクエスト取得メソッド
	 *
	 * @return request リクエスト
	 */
//	public HttpServletRequest getRequest() {
//		return request;
//	}

	/**
	 * レスポンス取得メソッド
	 *
	 * @return response レスポンス
	 */
//	public HttpServletResponse getResponse() {
//		return response;
//	}
}
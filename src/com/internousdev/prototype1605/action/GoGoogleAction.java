/**googleでログインする為のクラス
 *
 */
package com.internousdev.prototype1605.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1605.util.GoogleOauth;
import com.opensymphony.xwork2.ActionSupport;

public class GoGoogleAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{


	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = -7619711528878401546L;


	/**
	 * セッション
	 */
	private Map<String,Object> session;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;
	/**
	 * GoogleからリクエストTokenを取得メソッド
	 * @return SUCCESS ERROR
	 */
	public String execute() {
		GoogleOauth googleOauth = new GoogleOauth();
		if(!googleOauth.getRequestToken(request,response)) {
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * セッションを格納するためのメソッド
     * @param session セッション
	 */

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * セッションを取得するためのメソッド
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * レスポンス格納メソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * リクエストを格納するためのメソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
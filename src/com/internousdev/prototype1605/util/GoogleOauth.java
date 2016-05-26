/**Googleとoauth認証でのやりとりを行うクラス
 *
 */
package com.internousdev.prototype1605.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author haruna
 *
 */
public class GoogleOauth extends ActionSupport {

	/**
	 *  生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 2056178004412461362L;

	/*スコープのURL
	 *
	 */
	private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.profile";

	/*レスポンスURL
	 *
	 */
	private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v1/userinfo";

	/*空のトークン
	 *
	 */
	private static final Token EMPTY_TOKEN = null;

	/*
	 * ユーザー情報を取得するメソッド
	 */
	public boolean getRequestToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			String apiKey = "1063579920963-dqqe7m2b0nu1lphsgniukeec3v3bl6fu.apps.googleusercontent.com";
			String apiSecret = "4Wr33TzamAxv4neFUzv8PRUO";
			String callbackUrl = "http://localhost:8080/prototype1604/login-google-action";
//			String callbackUrl = "http://www.internousdev-b.com/prototype1604/LoginGoogleAction";

			OAuthService service = new ServiceBuilder()
					.provider(GoogleApi.class)
					.apiKey(apiKey)
					.apiSecret(apiSecret)
					.callback(callbackUrl)
					.scope(SCOPE)
					.build();

			@SuppressWarnings("unused")
			Token accessToken = new Token("ACCESS_TOKEN", "REFRESH_TOKEN");
			String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
			HttpSession session = request.getSession();
			session.setAttribute("SERVICE", service);
			response.sendRedirect(authorizationUrl);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*ユーザー情報の取得するメソッド
	 *
	 */
	public Map<String, String> getAccessToken(HttpServletRequest request) {
		Map<String, String> map;
		try {
			String verifier1 = request.getParameter("code");

			Verifier verifier = new Verifier(verifier1);
			Token accessToken = new Token("ACCESS_TOKEN", "REFRESH_TOKEN");

			HttpSession session = request.getSession();
			OAuthService service = (OAuthService) session.getAttribute("SERVICE");

			accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);

			OAuthRequest requestOauth = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
			service.signRequest(accessToken, requestOauth);
			Response response = requestOauth.send();
			map = new LinkedHashMap<>();
			ObjectMapper mapper = new ObjectMapper();

			map = mapper.readValue(response.getBody(), new TypeReference<LinkedHashMap<String, String>>(){});
		} catch (Exception e) {
			return null;
		}
		return map;
	}
}
package com.internousdev.prototype1605.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.yahoo.yconnect.YConnectExplicit;

/**
 * Servlet implementation class Callback
 */
@WebServlet("/Callback")
public class Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
	HttpServletResponse respons;
	String clientId = "dj0zaiZpPTU4YVRpbE9tYVF3diZzPWNvbnN1bWVyc2VjcmV0Jng9MTE-";
	String clientSecret = "96f5a173568783f82177883fd21b63bb53ae5255";
	String redirectUri = "http://example.com/CallbackAction";

	// YConnectインスタンス取得
	YConnectExplicit yconnect = new YConnectExplicit();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Callback() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String execute(){
    	System.out.println("abc");
    	try{
		    // 認可コードを取得
		    String code = yconnect.getAuthorizationCode("1234567");
		    //yconnect.requestToken(code, clientId, clientSecret, redirectUri);
		    // アクセストークン、リフレッシュトークン、IDトークンを取得
		    //String accessTokenString = yconnect.getAccessToken();
		    //String refreshToken = yconnect.getRefreshToken();
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
    	return "success";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("a");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("b");
	}

}

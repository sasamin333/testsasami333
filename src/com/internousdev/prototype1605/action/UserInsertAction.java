package com.internousdev.prototype1605.action;

import java.sql.SQLException;

import com.internousdev.prototype1605.dao.UserInsertDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserInsertAction extends ActionSupport {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -4995201444411491737L;

	/**
	 * ユーザー名
	 */
	private String user;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザー名エラー
	 */
	private String errorUser;

	/**
	 * パスワードエラー
	 */
	private String errorPassword;

	public String execute() throws SQLException {

		//ユーザー名のヴァリデーション
	   if(!user.matches(".{1,255}")){
		   errorUser = (getText("文字列を入力し下さい"));
		   return ERROR;
	   }

	   //パスワードのヴァリデーション
	   if(!password.matches(".{1,255}")){
		   errorPassword = (getText("文字列を入力し下さい"));
		   return ERROR;
	   }

	   //追加の判定
	   String result = ERROR;
	   UserInsertDAO dao = new UserInsertDAO();
	   int count = 0;
	   count = dao.insert(user, password);
	   System.out.println("ここおおおおおおおおおお");
	   if(count > 0){
		   System.out.println("ここおおおおおおおおおおかなあああああああああ");
		      return SUCCESS;
	    }

	   return result;
   }

	/**
	 * ユーザー名を取得する為メソッド
	 * @return user
	 */
	public String getUser(){
		return user;
	}

	/**
	 * ユーザー名を格納する為のメソッド
	 * @param user
	 */
	public void setUser(String user){
		this.user = user;
	}

	/**
	 * パスワードを取得する為のメソッド
	 * @return password
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * パスワードを格納するためのメソッド
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * ユーザー名エラーを取得する為のメソッド
	 * @return errorUser
	 */
	public String getErrorUser(){
		return errorUser;
	}

	/**
	 * ユーザー名エラーを格納する為のメソッド
	 * @param errorUser
	 */
	public void setErrorUser(String errorUser){
		this.errorUser = errorUser;
	}

	/**
	 * パスワードエラーを取得する為のメソッド
	 * @return errorPassword
	 */
	public String getErrorPassword(){
		return errorPassword;
	}

	/**
	 * パスワードエラーを格納する為のメソッド
	 * @param errorPassword
	 */
	public void setErrorPassword(String errorPassword){
		this.errorPassword = errorPassword;
	}

}

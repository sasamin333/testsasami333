package com.internousdev.prototype1605.action;

import java.sql.SQLException;

import com.internousdev.prototype1605.dao.UserUpdateDAO;
import com.opensymphony.xwork2.ActionSupport;
//データベースにユーザー情報を削除させる為のクラス
public class UserUpdateAction extends ActionSupport  {
	/**
	 * 	シリアルID
	 */
	private static final long serialVersionUID = -3541224046836562290L;

	/**
	 * ID
	 */
	private int id;

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

	/**
	 * 更新エラー
	 */
	private String errorUpdate;


	/**
	 * ユーザー情報を更新できたか否か判定するメソッド
	 * @result ERROR ヴァリデーションによるエラーメッセージ
	 * @return result データベースのuser,passwordを更新できたか否か
	 * @throws SQLException
	 */
	public String execute() throws SQLException{

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

		   //更新の判定
		  String result =ERROR;
		  UserUpdateDAO dao = new UserUpdateDAO();
		  int count = 0;
		  count = dao.select(user,password,id);
			if(count > 0){
				   result = SUCCESS;
			}else{
				errorUpdate = (getText("IDまたはユーザー名、パスワードが間違っています"));
			}

		   return result;
	}

	/**
	 * ユーザー名を取得するメソッド
	 * @return user
	 */
	public String getUser(){
		return user;
	}

	/**
	 * ユーザー名を格納するメソッド
	 * @param user
	 */
	public void setUser(String user){
		this.user = user;
	}

	/**
	 * パスワードを取得するメソッド
	 * @return password
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * パスワードを格納するメソッド
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * IDを取得するためのメソッド
	 * @return id
	 */
	public int getId(){
		return id;
	}

	/**
	 * IDを格納するためのメソッド
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * ユーザー名エラーを取得する為のメソッド
	 * @return errorUser
	 */
	public String getErrorUser(){
		return errorUser;
	}

	/**
	 * ユーザー名エラーを格納するためのメソッド
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

	/**
	 * 更新エラーを取得するためのメソッド
	 * @return errorUpdate
	 */
	public String getErrorUpdate(){
		return errorUpdate;
	}

	/**
	 * 更新エラーを格納するためのメソッド
	 * @param errorUpdate
	 */
	public void setErrorUpdate(String errorUpdate){
		this.errorUpdate = errorUpdate;
	}
}

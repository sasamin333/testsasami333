package com.internousdev.prototype1605.action;

import java.sql.SQLException;

import com.internousdev.prototype1605.dao.UserDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserDeleteAction extends ActionSupport {

	private static final long serialVersionUID = -3097877496894754662L;

	/**
	 * ユーザー名
	 */
	private String user;

	/**
	 * ユーザー名エラー
	 */
	private String errorUser;

	/**
	 * 削除エラー
	 */
	private String errorDelete;

	/**
	 * ユーザー情報を削除できたか否か判定するメソッド
	 *@return error ヴァリデーションによるエラーメッセージ
	 * @return result　データベースのuser,passwordを削除できたか否か
	 * @throws SQLException
	 */
	public String execute() throws SQLException{

		   //ユーザー名のヴァリデーション
		   if(!user.matches(".{1,255}")){
			   errorUser = (getText("文字列を入力し下さい"));
			   return ERROR;
		   }

		   //削除の判定
		   String result =ERROR;
		   UserDeleteDAO dao = new UserDeleteDAO();
		   int count = 0;
		   count = dao.delete(user);

			if(count > 0){
				   result = SUCCESS;
			}else{
				errorDelete = (getText("そのユーザー名は該当しません"));
			}

		   return result;
	   }


	/**
	 * ユーザー名を取得する為のメソッド
	 * @return user
	 */
	public String getUser(){
		return user;
	}

	/**
	 * ユーザー名を格納するためのメソッド
	 * @param user
	 */
	public void setUser(String user){
		this.user = user;
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
	 * 削除エラーを取得する為のメソッド
	 * @return errorDelete
	 */
	public String getErrorDelete(){
		return errorDelete;
	}

	/**
	 * 削除エラーを格納するためのメソッド
	 * @param errorDelete
	 */
	public void setErrorDelete(String errorDelete){
		this.errorDelete = errorDelete;
	}
}

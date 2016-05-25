package com.internousdev.prototype1605.dto;
//ユーザー情報一覧を格納の処理
public class UserSelectDTO {

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
	 * IDを取得する為のメソッド
	 * @return id
	 */
	public int getId(){
		return id;
	}

	/**
	 * IDを格納する為のメソッド
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * ユーザー名を取得する為のmメソッド
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
	 * パスワードを取得する為のメソッド
	 * @return password
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * パスワードを格納する為のメソッド
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}
}

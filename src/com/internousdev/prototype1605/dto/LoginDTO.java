package com.internousdev.prototype1605.dto;

/**
 * データーベースのデータを一時的に保持するクラス
 */
public class LoginDTO{
	// ID
    private int id;

    // ユーザー名
    private String user_name;

    // パスワード
    private String password;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return user_name;
    }

    public void setName(String name){
        this.user_name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
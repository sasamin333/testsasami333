package com.internousdev.prototype1605.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	public String id;
	public String password;

    public String execute(){
    	return "success";
    }

    public String getID(){
    	return id;
    }

    public void setID(String id){
    	this.id = id;
    }

    public String getPassword(){
    	return password;
    }

    public void setPassword(String password){
    	this.password = password;
    }
}

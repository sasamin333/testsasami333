package com.internousdev.prototype1605.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1605.dao.LoginDAO;
import com.internousdev.prototype1605.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -8957391474053205643L;
	private String user_name;
    private String password;
    private Map<String,Object> session;

    public String execute(){
        String ret = ERROR;

        LoginDAO dao = new LoginDAO();
        LoginDTO dto = new LoginDTO();

        dto = dao.select(user_name,password);

        String dtoName = dto.getName();
        String dtoPassword = dto.getPassword();

        if(dtoName != null){
	        if(user_name.equals(dtoName)){
	            if(dtoPassword.equals(dto.getPassword())){
	                ret = SUCCESS;
	            }
	        }
        }
        session.put("user_name",dto.getName());

        return ret;
    }

    public String newUser(){
    	return SUCCESS;
    }

    public String getName(){
        return user_name;
    }

    public void setName(String name){
        this.user_name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Map<String, Object> getSession(){
        return session;
    }

    public void setSession(Map<String, Object> session){
        this.session = session;
    }
}

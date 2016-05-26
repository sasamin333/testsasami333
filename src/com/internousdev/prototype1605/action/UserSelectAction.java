package com.internousdev.prototype1605.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.prototype1605.dao.UserSelectDAO;
import com.internousdev.prototype1605.dto.UserSelectDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserSelectAction extends ActionSupport {


		private static final long serialVersionUID = 4842734552571381537L;


		private ArrayList<UserSelectDTO> list = new ArrayList<UserSelectDTO>();


	  	private String errorSelect;


	  	private int id;


	  	private String user;


		  	private String password;

		  	public String execute() throws SQLException {
		 	   String result =ERROR;
		 	   UserSelectDAO dao = new UserSelectDAO();
		 	   if(dao.select()){
		 		   list = dao.getUserSelect();
		 		   result = SUCCESS;
		 	   }else{
		 		   errorSelect = (getText("データがありません"));
		 	   }
		 	   return result;
		  	}



		public ArrayList<UserSelectDTO> getList(){
			return list;
		}


		public void setList(ArrayList<UserSelectDTO> list){
			this.list = list;
		}


		public String getErrorSelect(){
			return errorSelect;
		}

	public void setErrorSelect(String errorSelect){
		this.errorSelect = errorSelect;
	}


	public int getId(){
	return id;
	}


	public void setId(int id){
		this.id = id;
	}


	public String getUser(){
		return user;
	}


	public void setUser(String user){
		this.user = user;
	}


	public String getPassword(){
		return password;
	}


	public void setPassword(String password){
		this.password = password;
	}

	}

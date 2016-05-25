package com.internousdev.prototype1605.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internous
 *
 */
public class MongoInsertAction extends ActionSupport {


	private static final long serialVersionUID = -8776608656821772942L;
	//ユーザーID

	private String name;
	private String comment;

	public String execute(){
		String result = SUCCESS;
		MongoInsertDAO dao = new MongoInsertDAO();
		boolean ret = dao.insert(name,comment);
		System.out.println(ret);


		return result;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}



}

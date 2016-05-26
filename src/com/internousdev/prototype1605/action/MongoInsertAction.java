package com.internousdev.prototype1605.action;

import com.internousdev.prototype1605.dao.MongoInsertDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internous
 *
 */
public class MongoInsertAction extends ActionSupport {




	/**
	 *
	 */
	private static final long serialVersionUID = 271445535291743501L;
	private String name;
	private String comment;

	public String execute(){
		String result = SUCCESS;
		MongoInsertDAO dao = new MongoInsertDAO();
		boolean ret = dao.insert(name,comment);
		System.out.println(ret);

		System.out.println("1");
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

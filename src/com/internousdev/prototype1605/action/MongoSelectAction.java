package com.internousdev.prototype1605.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype1605.dao.MongoSelectDAO;
import com.internousdev.prototype1605.dto.MongoSelectDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MongoSelectAction extends ActionSupport implements SessionAware {




	/**
	 *
	 */
	private static final long serialVersionUID = 2369684767000330152L;

	private Map<String, Object> session;

	private List<MongoSelectDTO> ticketList = new ArrayList<MongoSelectDTO>();

	private List<MongoSelectDTO> nameList = new ArrayList<MongoSelectDTO>();

	private String nameDetail;

	private String commentDetail;

	public String execute() {
		String result = ERROR;
		MongoSelectDAO dao = new MongoSelectDAO();
		System.out.println("List");
		dao.selectMongo();
		nameList =dao.getSelectList();
		ticketList.addAll(dao.getSelectList());
		result = SUCCESS;
		System.out.println(nameList);
		return result;


	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return ticketList
	 */
	public List<MongoSelectDTO> getTicketList() {
		return ticketList;
	}
	/**
	 * @return nametList
	 */
	public List<MongoSelectDTO> getNametList() {
		return nameList;
	}

	/**
	 * @return nameDetail
	 */
	public String getNameDetail() {
		return nameDetail;
	}

	/**
	 * @return commentDetail
	 */
	public String getCommentDetail() {
		return commentDetail;
	}

	/**
	 * @return nameList
	 */
	public List<MongoSelectDTO> getNameList() {
		return nameList;
	}

}
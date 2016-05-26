package com.internousdev.prototype1605.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.internousdev.prototype1605.dto.MongoSelectDTO;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author internous
 *
 */
public class MongoSelectDAO {


	ArrayList<MongoSelectDTO> selectList = new ArrayList<MongoSelectDTO>();

	public ArrayList<MongoSelectDTO> selectMongo(){

		DB db = null;

		MongoClient mongo = null;

		try {
			mongo = new MongoClient("localhost",27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		db = mongo.getDB("prototype1605");
		DBCollection col = db.getCollection("test");
		DBCursor cursor = col.find();
		System.out.println("1");
		try {
			while (cursor.hasNext()){
				MongoSelectDTO dto = new MongoSelectDTO();
				DBObject dbs = cursor.next();
				dto.setName((String) dbs.get("name"));
				dto.setComment((String) dbs.get("comment"));
				selectList.add(dto);
				System.out.println("2");
			}
		}finally {
			System.out.println(selectList);
			cursor.close();
		}
		return selectList;
	}

	/**
	 * @return selectList
	 */
	public ArrayList<MongoSelectDTO> getSelectList() {
		return selectList;
	}

}
package com.internousdev.prototype1605.dao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author internous
 *
 */
public class MongoInsertDAO {

	/**
	 * Mongoにデータを追加する為のメソッド
	 *
	 * @return result 追加できたらtrue,できなかったらfalse
	 */

	public boolean insert(String name, String comment) {
		DB db = null;
		boolean result = false;

		MongoClient mongo = null;
		try {
			System.out.println("mongoDAO");
			mongo = new MongoClient("localhost", 27017);

			db = mongo.getDB("prototype1605");
			DBCollection colls = db.getCollection("test");
			BasicDBObject input = new BasicDBObject();

			input.put("name", name);
			System.out.println(name);
			input.put("comment", comment);
			System.out.println(comment);
			colls.insert(input);

			return true;

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

}

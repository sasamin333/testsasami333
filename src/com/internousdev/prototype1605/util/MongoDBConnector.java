/**
 *
 */
package com.internousdev.prototype1605.util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * @author internous
 *
 */
public class MongoDBConnector {

	private MongoClient client = null;



	public DB getConnection(){
		DB db = null;
		try{
			client = new MongoClient("localhost",27017);
			db = client.getDB("prototype1605");
		}
		catch(UnknownHostException e){
			e.printStackTrace();
		}
		return db;
	}
}

package com.internousdev.prototype1605.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.prototype1605.util.DBConnector;

public class UserInsertDAO {

	//ユーザー情報を追加させる為のメソッド
	public int insert(int id, String user, String password) throws SQLException{
		int count = 0;
		DBConnector db = new DBConnector();
        Connection conn =  db.getConnection();
        String sql = "INSERT INTO user (user_id,user_name,password) VALUES (?,?,?)";
         try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,user);
            ps.setString(3,password);
            count = ps.executeUpdate();


         }catch (SQLException e) {
        	 e.printStackTrace();
 	     }finally{
 	    	 try{
 	    		 conn.close();
 	         }catch (SQLException e){
 	          	  e.printStackTrace();
 	         }
 	     }
         return count;
	}
}
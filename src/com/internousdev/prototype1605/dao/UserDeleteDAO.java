
package com.internousdev.prototype1605.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.prototype1605.util.DBConnector;


public class UserDeleteDAO {
	//ユーザー情報を削除させる為のメソッド
	public int delete(String user) throws SQLException{
		int count = 0;
		DBConnector db = new DBConnector();
        Connection conn =  db.getConnection();
        String sql = "Delete from user WHERE user_name= ?";

         try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            count =ps.executeUpdate();

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

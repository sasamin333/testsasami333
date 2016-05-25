package com.internousdev.prototype1605.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.prototype1605.util.DBConnector;

public class UserInsertDAO {

	//ユーザー情報を追加させる為のメソッド
	public int insert(String user, String password) throws SQLException{
		int count = 0;
        Connection conn =  DBConnector.getConnection();
        String sql = "INSERT INTO user (user,password) VALUES (?,?)";
         try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password);
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

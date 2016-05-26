package com.internousdev.prototype1605.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.prototype1605.util.DBConnector;

public class UserUpdateDAO {
	public int select(String user,String password,int id) throws SQLException{
	int count = 0;
	DBConnector db = new DBConnector();
    Connection conn =  db.getConnection();
    String sql = "UPDATE user SET user=?, password=? WHERE id=?";

    	try{
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,user);
    		ps.setString(2,password);
    		ps.setInt(3,id);
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

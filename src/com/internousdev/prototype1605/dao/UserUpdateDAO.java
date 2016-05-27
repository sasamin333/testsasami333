package com.internousdev.prototype1605.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.prototype1605.util.DBConnector;

public class UserUpdateDAO {

	private DBConnector dbc;

	private Connection con;

	/**
	 * UserUpdateDAOのオブジェクトを生成
	 */
	public UserUpdateDAO(){
		dbc = new DBConnector();
		con = dbc.getConnection();
	}

	public int select(String user, String password, int id) throws SQLException{
	int count = 0;
    String sql = "UPDATE user SET user_name=?, password=? WHERE user_id=?";

    	try{
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1,user);
    		ps.setString(2,password);
    		ps.setInt(3,id);
    		count =ps.executeUpdate();

    	}catch (SQLException e) {
    		e.printStackTrace();
    	}finally{
    		try{
    			con.close();
    		}catch (SQLException e){
    			e.printStackTrace();
    		}
    	}
    	return count;
	}
}

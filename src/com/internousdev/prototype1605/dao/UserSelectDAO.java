package com.internousdev.prototype1605.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.prototype1605.dto.UserSelectDTO;
import com.internousdev.prototype1605.util.DBConnector;

public class UserSelectDAO {
	/**
	 * ユーザー一覧情報を格納するリスト
	 */
	private ArrayList<UserSelectDTO> list = new ArrayList<UserSelectDTO>();

	/**
	 * 画面にユーザー情報一覧を表示させる為のメソッド
	 *
	 * @return result データベースからのユーザー一覧情報を格納できたか否か
	 * @throws SQLException
	 */
	public boolean select() throws SQLException {
		boolean result = false;

		DBConnector db = new DBConnector();
		Connection conn = db.getConnection();
		String sql = "select * from user";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserSelectDTO dto = new UserSelectDTO();
				dto.setId(rs.getInt("user_id"));
				dto.setUser(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				list.add(dto);
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * リストを取得する為のメソッド
	 *
	 * @return list
	 */
	public ArrayList<UserSelectDTO> getUserSelect() {
		return list;
	}

	/**
	 * リストを格納する為のメソッド
	 *
	 * @param list
	 */
	public void setList(ArrayList<UserSelectDTO> list) {
		this.list = list;
	}
}

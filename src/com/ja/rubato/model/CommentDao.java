package com.ja.rubato.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.ja.rubato.vo.CommentVo;

public class CommentDao {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";
	
	public ArrayList<CommentVo> select(int no) {
		
		ArrayList<CommentVo> list = new ArrayList<CommentVo>();

		String query = "SELECT * FROM fb_comment WHERE b_no=? ORDER BY c_no DESC";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			// 맨처음 한번 오라클을 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, no);
			rs = pstm.executeQuery(); // 익스큐트 업데이트는 인서트 업데이트 구문에 사용

			// 로직

			while (rs.next()) {
				int c_no = rs.getInt("c_no");
				int b_no = rs.getInt("b_no");
				int m_no = rs.getInt("m_no");
				String c_content = rs.getString("c_content");
				Date c_writedate = rs.getDate("c_writedate");
				CommentVo commentVo = new CommentVo(c_no, b_no, m_no, c_content, c_writedate);
				list.add(commentVo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public void insert(int b_no, int m_no, String content) {

		String query = "INSERT INTO fb_comment VALUES (fb_comment_seq.nextval,?,?,?,SYSDATE) ";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// oracle.jdbc.driver.OracleDriver d; 동적으로 로드가 가능
			// 한번 꺼내야 되기 때문에 Class.forName을 작성함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 자체내의 프로토콜을 사용하여 오라클과 연동하는 과정 이클립스가 활용됨
			// URL이 들어가는데
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, b_no);
			pstm.setInt(2, m_no);
			pstm.setString(3, content);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

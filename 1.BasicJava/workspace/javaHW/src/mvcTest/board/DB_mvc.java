package mvcTest.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_mvc {

	Connection c = null;
	Statement s = null;
	ResultSet rs = null;
	
	private DB_mvc() {
	}

	private static DB_mvc uniqueInstance = new DB_mvc();

	public static DB_mvc getInstance() { return uniqueInstance; }
	
	public int read_menu(int num)
	{
		String sql = "select board_no, board_title, board_writer, board_content from jdbc_board";
		return 0;
	}
	
	public int cud(String sql) {
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			if (s.executeUpdate(sql) < 1) {
				System.out.println("업데이트 실패");
				return 0;
			}
			System.out.println("업데이트 성공!");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public int duplChk(String sql) {
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String printall(String sql) {
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(sql);
			String list = "";
			while (rs.next()) {
				list+=rs.getString(1);
				list+=rs.getString(2);
				list+=rs.getString(3);
				list+=rs.getString(4);
				list+="\n";
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return "SQL Exception";
		}finally{
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

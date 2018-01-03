package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest05 {
	public static void main(String[] args) {
		int[] id = new int[] { 909, 908, 907 };
		String[] gu = new String[] { "N101", "N102", "N103" };
		String[] nm = new String[] { "농", "축", "수" };

		Connection c = null;
		Statement s = null;
		PreparedStatement ps = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"pc07",
					"java"
					);
			// 1. statement 객체를 이용한 처리
//			s = c.createStatement();
//			for (int i = 0; i < id.length; i++) {
//				String sql = "insert into lprod (lprod_id, lprod_gu,lprod_nm) values ("
//						+ id[i] + ", \'" + gu[i] + "\',\'" + nm[i] + "\')";
//				int cnt = ps.executeUpdate(sql);
//				System.out.println(cnt);
//			}
			//2. preparedStatment객체를 이용한 처리
			String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values (?,?,?)";
			
			//preparedStatment객체생성 -> SQL문 인수로 넣어줌
			ps = c.prepareStatement(sql);
			
			for (int i = 0; i < id.length; i++) {
				ps.setInt(1, id[i]);
				ps.setString(2, gu[i]);
				ps.setString(3, nm[i]);
				
				int cnt = ps.executeUpdate();
				System.out.println(cnt);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}

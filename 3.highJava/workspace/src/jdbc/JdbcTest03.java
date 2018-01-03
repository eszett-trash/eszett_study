package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest03 {

	/*
	 * 자료추가 : insert연습 lprod_id : 101, lprod_gu:N101, lprod_nm :농산물 lprod_id :
	 * 102, lprod_gu:N102, lprod_nm :수산물 lprod_id : 103, lprod_gu:N103, lprod_nm
	 * :축산물
	 */
	public static void main(String[] args) {
		Connection c = null;
		Statement s = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
					c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"pc07",
					"java"
					);
					String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values (101,'N101','농산물')";
					s = c.createStatement();
					
					//ExecuteUpdate()의 반환값은 작업을 성공한 레코드 수
					int cnt = s.executeUpdate(sql);
					
					System.out.println(cnt);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (c!=null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
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

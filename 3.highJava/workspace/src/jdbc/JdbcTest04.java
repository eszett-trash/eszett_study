package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest04 {

	/*
	 * 자료추가 : insert연습 lprod_id : 101, lprod_gu:N101, lprod_nm :농산물 lprod_id :
	 * 102, lprod_gu:N102, lprod_nm :수산물 lprod_id : 103, lprod_gu:N103, lprod_nm
	 * :축산물
	 */
	public static void main(String[] args) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
					c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"pc07",
					"java"
					);
					String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values (?,?,?)";
					
					//preparedStatment객체생성 -> SQL문 인수로 넣어줌
					ps = c.prepareStatement(sql);

					//SQL문의 ?에들어갈 데이터를 셋팅
					ps.setInt(1, 701);
					ps.setString(2,"N202");
					ps.setString(3, "농산물");
					
					//ExecuteUpdate()의 반환값은 작업을 성공한 레코드 수
					int cnt = ps.executeUpdate();
					
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
			if(ps!=null)
			{
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
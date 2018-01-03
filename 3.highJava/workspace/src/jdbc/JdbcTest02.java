package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest02 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection객체 생성 및 접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "pc07";
			String password = "java";

			conn = DriverManager.getConnection(url, user, password);
			// statement객체 생성 -->connection객체를 이용한다.
			stmt = conn.createStatement();
			// SQL문을 작성하여STatementㅅ객체를 이용하여 실행하고 결과를 ResultSet객체에 저장
			Scanner s = new Scanner(System.in);
			System.out.println("작은 숫자입력");
			int i = s.nextInt();
			System.out.println("큰숫자입력");
			int j = s.nextInt();
			String sql = "select * from lprod where lprod_id >=" + i + " and lprod_id <=" + j ;
			rs = stmt.executeQuery(sql);
			// 받아온 데이터는 ResultSet객체에 저장되어있으므로
			// 이 객체에 저장된 값을들 반복문과 next()메서드등을 이용하여 처리한다.
			while (rs.next()) {
					System.out.println(rs.getInt("lprod_id"));
					// System.out.println(rs.getString("lprod_gu"));
					System.out.println(rs.getString(2)); // 컬럼 번화이기때문이 lprod_gu와 동일
					System.out.println(rs.getString("lprod_nm"));
					System.out.println("-----------------------------------------");
			}
			System.out.println("작업완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원반납
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

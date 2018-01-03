package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {
	// 자바를 이용한 데이터베이스 처리 순서
	// -> 드라이버 로딩 --> 해당 DBMS 접속 --> 질의 (SQL명령 수행)
	// ->작업이 모두 종료되만 사용한 자원을 반납한다.

	// 드라이버 로딩
	// Class.forName("oracle.jdbc.driver.OracleDriver");

	// 접속하기 : connection 객체가 생성된다.
	// drivermanaver.getConnection()메서드 사용

	// 질의 : Connection객체를 이용하여 Statement객체나 PrepareStatement객체를
	// 생성하고 이 객체를 이용하여 SQL명령을 실행한다.

	// 질의결과
	// 1)sql명령이 'select'일 경우
	// 2)sql명령이 'insert, update, delete, create'등일경우
	// ->처리된 결과가 정수값으로 반환된다
	// (정수값은 보통 실행에 성공한 레코드 수를 의미한다.)

	// 자원 반납
	// Connection객체, statement객체, PreparedStatement객체, ResultSet객체등 사용한 객체를
	// 닫아준다.
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
			String sql = "select * from lprod";
			rs = stmt.executeQuery(sql);
			// 받아온 데이터는 ResultSet객체에 저장되어있으므로
			// 이 객체에 저장된 값을들 반복문과 next()메서드등을 이용하여 처리한다.
			
			//excuteQuery()-> select일때
			//excuteUpdate() -> insert,update,delete,create일때
			while (rs.next()) {
				System.out.println(rs.getInt("lprod_id"));
//				System.out.println(rs.getString("lprod_gu"));
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

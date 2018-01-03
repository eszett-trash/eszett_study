package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 lprod테이블에 새로운 데이터 추가하기

 lprod_gu와 lprod_nm은 사용자가 직접 입력한 값을 받아서 처리하고,
 lprod_id는 현재 lprod_id중 제일 큰 값보다 1 증가된 값으로 한다,
 */
public class JdbcTest06 {

	public static void main(String[] args) {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		int id_max = 0;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
//			String sql = "select * from lprod";
			String sql = "select max(lprod_id) from lprod";
			rs = s.executeQuery(sql);

//			while (rs.next()) {
//				if (id_max < rs.getInt("lprod_id")) {
//					id_max = rs.getInt("lprod_id");
//				}
//			}
			
			rs.next();
			id_max = rs.getInt(1);

			Scanner scan = new Scanner(System.in);
			String gu = "";
			do {
				System.out.println("gu");
				gu = scan.next();
				sql = "select count (*) from lprod where lprod_gu ='"+ gu + "'";
			} while (s.executeQuery(sql)!=null);
			
			String nm = scan.next();
			//lprod_gu가 기본 키이기때문에 저장 전 중복여부 확인을 해야함
			
			sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values ("
					+ (id_max + 1) + ",'" + gu + "','" + nm + "')";
			s = c.createStatement();
			System.out.println(s.executeUpdate(sql));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

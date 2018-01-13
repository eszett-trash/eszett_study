package jdbc;

import hw_score.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 DB를 이용하여 회원을 관리하는 프로그램을 작성하시오.
 (table name : mymember)

 아래의 메뉴를 모두 구현하시오 (crud기능 구현)

 */
public class JdbcTest07 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			String sql = "\0";
			dbCon d = new dbCon();
			String id = null;
			String name;
			String tel;
			String addr;

			System.out.println(d.c);
			System.out.println("=========================");
			System.out.println("--작업선택--");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 작업 끝");
			System.out.println("=========================");

			switch (s.next()) {
			case "1":
				while (true) {
					System.out.println("아이디");
					id = s.next();
					sql = "select count (*) from mymember where mem_id ='" + id
							+ "'";
					if (d.duplChk(sql) < 1) {
						break;
					}
					System.out.println("중복된 id입니다. ");
				}
				System.out.println("이름");
				name = s.next();
				System.out.println("번호");
				tel = s.next();
				System.out.println("주소");
				addr = s.next();
				sql = "insert into mymember(mem_id,mem_name,mem_tel,mem_addr) values ( '"
						+ id + "','" + name + "','" + tel + "','" + addr + "')";
				d.cud(sql);
				break;
			case "2":
				System.out.println("삭제할 자료의 id를 입력하시오");
				id = s.next();
				sql = "delete from mymember where mem_id = '" + id + "'";
				d.cud(sql);
				System.out.println(d.c);
				break;
			case "3":
				System.out.println("수정할 자료의 id를 입력하시오");
				id = s.next();
				sql = "update mymember set " + udt() + "' where mem_id = '"
						+ id + "'";
				d.cud(sql);
				break;
			case "4":
				sql = "select * from mymember";
				d.printall(sql);
				break;
			case "5":
				System.out.println("종료");
				System.exit(0);
				break;
			default:
				System.out.println("재입력");
				break;
			}
		}
	}

	private static String udt() {
		while (true) {
			System.out.println("업데이트 할 자료 선택");
			System.out.println("1. 이름");
			System.out.println("2. 전화번호");
			System.out.println("3. 주소");
			String temp = "";
			switch (s.next()) {
			case "1":
				System.out.println("바꿀 자료 입력");
				temp = s.next();
				return "mem_name = '" + temp;
			case "2":
				System.out.println("바꿀 자료 입력");
				temp = s.next();
				return "mem_tel = '" + temp;
			case "3":
				System.out.println("바꿀 자료 입력");
				temp = s.next();
				return "mem_addr = '" + temp;
			default:
				break;
			}
		}
	}
}

class dbCon {

	Connection c = null;
	Statement s = null;
	ResultSet rs = null;

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

	public int printall(String sql) {
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("이름 : " + rs.getString(2));
				System.out.println("전화번호 : " + rs.getString(3));
				System.out.println("주소 : " + rs.getString(4));
				System.out.println("-----------------------------------------");
			}
			System.out.println("*********************");
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
}
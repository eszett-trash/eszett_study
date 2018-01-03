package ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	public static void main(String[] args) {
		// 작업순서

		// 1. ibatis의 환경설정파일을 읽어와(sqlMapConfig.xml) 실행시킨다.

		try {
			// 1-1 : xml파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			// 1-2 : 실제 작업을 진행 할 객체(SqlMapClient 생성)
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			// 2. 원하는 작업에 필요한 처리를 수행한다.
			// //2-1. insert작업 예
			// //2-1-1.insert할 데이터를 VO에 담는다
			// LprodVO lvo = new LprodVO();
			// lvo.setLprod_id(109);
			// lvo.setLprod_gu("N102");
			// lvo.setLprod_nm("농산물");
			// //2-1-2 sqlMapClient객체를 이용하여 해당 쿼리문을 실행한다.
			// //smc.insert("namespace값.실행활 쿼리문의 ID값, 파라미터 클래스");
			// //ibatis의 insert()메서드는 insert가 성공했을 때 null이 반환된다.
			// if(smc.insert("lprodTest.lprodInsert",lvo)==null)
			// {
			// System.out.println("Insert 작업 성공");
			// }else{
			// System.out.println("작업실패");
			// }

			// //2-2.update 작업 예
			// LprodVO lvo = new LprodVO();
			// lvo.setLprod_id(200);
			// lvo.setLprod_gu("N102");
			// lvo.setLprod_nm("축산물");
			// int cnt = smc.update("lprodTest.lprodUpdate",lvo);
			// if (cnt>0) {
			// System.out.println("작업성공");
			// } else {
			// System.out.println("작업실패");
			// }

//			// 2-3.delete 작업 예
//			int cnt = smc.delete("lprodTest.lprodDelete", "N102");
//			if (cnt > 0) {
//				System.out.println("delete 성공");
//			} else {
//				System.out.println("실패");
//			}

			// 2-4 select 작업 예
//			// 2-4-1. 응답결과가 여러개일 경우 queryForList메소드를 사용
//			System.out.println("select 작업 시작..");
//			System.out.println("응답결과가 여러개일 경우");
//			ArrayList<LprodVO> lprodList;
//
//			lprodList = (ArrayList<LprodVO>) smc
//					.queryForList("lprodTest.getAllData");
//			for (LprodVO lprodVO : lprodList) {
//				System.out.println(lprodVO.getLprod_id() + "  "
//						+ lprodVO.getLprod_gu() + "  " + lprodVO.getLprod_nm());
//			}
			//2-4-2 응답결과가 1개일 경우
			System.out.println("응답결과가 1개일 경우");
			LprodVO lvo;
			lvo = (LprodVO) smc.queryForObject("lprodTest.getLprodData","P102");
			
			System.out.println(lvo.getLprod_id() + "  "
					+ lvo.getLprod_gu() + "  " + lvo.getLprod_nm());
			
			int cnt = (int) smc.queryForObject("lprodTest.getAllCount");
			
			System.out.println(cnt);
			
		} catch (IOException e) {
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

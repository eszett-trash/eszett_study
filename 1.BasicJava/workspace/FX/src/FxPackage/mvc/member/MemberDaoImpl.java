package FxPackage.mvc.member;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resources;

public class MemberDaoImpl implements MemberDaoInf {
	private static MemberDaoImpl dao;
	private SqlMapClient smc;

	private MemberDaoImpl() { // 생성자
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MemberDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();

		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		Object resultObj;
		try {
			resultObj = smc.insert("mymember.memInsert", memVo);
			if (resultObj == null) { // insert()메서드는 작업이 성공하면 null반환
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.memDelete", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.memUpdate", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 전체 회원 정보를 가져오는 메서드
	@Override
	public List<MemberVO> getAllMember() {
		ArrayList<MemberVO> memList = null;
		try {
			memList = (ArrayList<MemberVO>) smc
					.queryForList("mymember.getAllMember");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}

		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("mymember.getMemberCount", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {

		ArrayList<MemberVO> memList = null;
		try {
			memList = (ArrayList<MemberVO>) smc.queryForList(
					"mymember.getSearchMember", searchMap);
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

}

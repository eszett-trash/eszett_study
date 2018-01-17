package FxPackage.mvc.member;

import java.util.List;
import java.util.Map;

public interface MemberServiceInf {
	/**
	 * insertMember - MemberVO에 담긴 데이터를 DB에 insert하는 메서드
	 * @param memVo - DB에 저장할 데이터가 담긴 객체
	 * @return 성공하면 정수 1, 실패하면 0을 반환
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 이용해 삭제하는 메서드
	 * @param memId
	 * @return
	 */
	public int deleteMember(String memId);
	
	/**
	 * 회원 정보를 수정하는 메서드
	 * @param memVo
	 * @return
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 회원 전체 데이터를 가져오는 메서드
	 * @return
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원ID의 인원수를 가져오는 메서드
	 * @param memId
	 * @return
	 */
	public int getMemberCount(String memId);
	
	/**
	 * Map에 설정된 검색 조건에 맞는 데이터를 가져오는 메서드
	 * @param searchMap
	 * @return
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
}









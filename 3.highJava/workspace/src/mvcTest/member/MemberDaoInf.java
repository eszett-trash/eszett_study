package mvcTest.member;

public interface MemberDaoInf {
	/**
	 * cud - MemberVO에 담긴 데이터를 DB에 insert하는 메서드
	 * @param db에 저장항 데이터가 담긴 객체
	 * @return 성공시 1, 실패시 -1반환
	 */
	public int cud(MemberVO mv);
	
}

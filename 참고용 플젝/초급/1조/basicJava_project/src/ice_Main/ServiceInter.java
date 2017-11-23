package ice_Main;

import java.util.List;
import java.util.Map;

import ice_VO.RecordVO;
import ice_VO.IceCreamVO;
import ice_VO.MemberVO;
import ice_VO.SizeVO;

/**
 * @Class serviceInterface
 * @Description 아이스크림 판매 서비스 클래스
 * @author 가게주인(아이스크림 판매자)
 * @since 2017-09-04
 * @version 0.1
 * @see
 * <pre>
 *   수정일             수정자               수정내용      
 *   -------		-------     -------------------            
 *  2017.09.04		       		최초생성      
 *  							ServiceInterface 생성
 *  							ServiceIplement 생성
 *  							DBclass 생성
 *  2017.09.05		원용선		ServiceInterface 수정	     
 * </pre>
 */
public interface ServiceInter {
	
	/**
	 * 회원가입
	 * @param MemberVO newMember
	 * @return 가입성공(true) 실패(false)
	 */
	public boolean memberCreate(MemberVO newMember);

	/**
	 * 아이디 중복체크
	 * @param memberId
	 * @return 있는 아이디 이면(true) 아니면(false)
	 */
	public boolean memberCheckId(String memberId);

	/**
	 * 로그인 체크
	 * 멤버리스트에 값이 존재하면 리스트로 반환(뷰클래스의 멤버리스트에 저장하기위해)
	 * 값이 존재하지 않으면 null값을 반환한다.
	 * @param loginInfo
	 * @return 멤버리스트
	 */
	public MemberVO loginCheck(Map<String, String> loginInfo);
	
	/**
	 * 컵구매 후 아이스크림을 하나씩 정할 때마다 아이스크림의 갯수를 하나씩 뺴준다.
	 * @param order
	 * @return 
	 */
	public boolean Order(int order);
	
	/**
	 * 아이스크림 리스트 출력용
	 */
	public List<IceCreamVO> memberGetIcecream();
	
	/**
	 * 컵 사이즈 리스트 출력용
	 */
	public List<SizeVO> getSize();
	   
	/**
	 * 멤버아이디를 받아서 해당 아이디의 영수증을 리스트로 출력해준다.
	 * @param memberId
	 * @return
	 */
	public List<SizeVO> memberGetSummary(String memberId);
	
	/**
	 * 멤버의 비밀번호 변경용
	 * @param updateSend
	 * @return	변경성공시(true) 실패시(false)
	 */
	public boolean updateMemberInfo(Map<String, String> updateSend);
	
	/**
	 * 해당멤버의 현금충전용
	 * @param id 해당 멤버아이디
	 * @param money 충전하고자 하는 금액
	 * @return	
	 */
	public int chargeMoney(String id, int money);
	
	/**
	 * 회원삭제용
	 * @param memberId
	 * @return 성공시(true) 실패시(false)
	 */
	public boolean deleteMember(String memberId);
	
	
	/**
	 * 회원조회용
	 * @return
	 */
	public List<MemberVO> memberAll();
	
	/**
	 * 관리자가 아이스크림의 재고주문을 위해 사용
	 * @param productAdd
	 * @return
	 */
	public boolean productAdd(Map<String, Integer> productAdd);
	
	/**
	 * 컵(상품)의 가격변동시 사용
	 * @param productChg
	 * @return
	 */
	public boolean productChg(Map<String, Integer> productChg);
	
	
	/**
	 * 매출 조회용
	 * @return
	 */
	public List<RecordVO> recordSale();

	/**
	 * 관리자의 매출관리용
	 * @param newRecord
	 * @return
	 */
	public boolean recordAdd(RecordVO newRecord);

	/**
	 * 멤버의 영수증용
	 * @param summarySave
	 * @return
	 */
	public boolean memberSummaryVO(Map<String, SizeVO> summarySave);

	/**
	 * 영수증에서 총 구매한 가격을 반환
	 * @param string
	 * @return
	 */
	public int allSum(String string);

	/**
	 * 관리자 로그인용
	 * @param adminLogin
	 * @return 성공시(true) 실패시(false)
	 */
	public boolean adminLoginCheck(Map<String, String> adminLogin);
	

	
}

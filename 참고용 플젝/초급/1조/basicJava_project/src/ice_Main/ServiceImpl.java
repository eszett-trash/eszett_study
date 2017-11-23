package ice_Main;

import ice_DB.DBClass;
import ice_VO.IceCreamVO;
import ice_VO.MemberVO;
import ice_VO.RecordVO;
import ice_VO.SizeVO;

import java.util.List;
import java.util.Map;


public class ServiceImpl implements ServiceInter {
	DBClass db = new DBClass();

	//회원
	//회원가입
	@Override
	public boolean memberCreate(MemberVO newMember) {
		return db.memberCreate(newMember);
	}

	//Id중복체크
	@Override
	public boolean memberCheckId(String memberId) {
		return db.memberCheckId(memberId);
	}

	//로그인
	@Override
	public MemberVO loginCheck(Map<String, String> loginInfo) {
		return db.loginCheck(loginInfo);
	}

	//구매
	@Override
	public boolean Order(int order) {
		return db.Order(order);
	}

	//아이스크림 출력
	@Override
	public List<IceCreamVO> memberGetIcecream() {
		// TODO Auto-generated method stub
		return db.memberGetIcecream();
	}
	
	//영수증 출력
	@Override
	public List<SizeVO> memberGetSummary(String memberId) {
		return db.memberGetSummary(memberId);
	}

	//정보수정
	@Override
	public boolean updateMemberInfo(Map<String, String> updateSend) {
		return db.updateMemberInfo(updateSend);
	}

	//현금충전
	@Override
	public int chargeMoney(String id, int money) {
		return db.inputMoney(id, money);
	}

	//회원탈퇴
	@Override
	public boolean deleteMember(String memberId) {
		return db.deleteMember(memberId);
	}

	//회원조회
	@Override
	public List<MemberVO> memberAll() {
		return db.memberAll();
	}

	//재고주문
	@Override
	public boolean productAdd(Map<String, Integer> productAdd) {
		return db.productAdd(productAdd);
	}

	//상품가격변동
	@Override
	public boolean productChg(Map<String, Integer> productChg) {
		return db.productChg(productChg);
	}

	
	//매출조회
	@Override
	public List<RecordVO> recordSale() {
		return db.recordSale();
	}

	//사이즈리스트
	@Override
	public List<SizeVO> getSize() {
		return db.getSize();
	}

	//구매내역추가
	@Override
	public boolean recordAdd(RecordVO newRecord) {
		return db.recordAdd(newRecord);
	}

	//회원 영수증
	@Override
	public boolean memberSummaryVO(Map<String, SizeVO> summarySave) {
		return db.memberSummaryVO(summarySave);
	}

	@Override
	public int allSum(String string) {
		return db.allSum(string);
	}

	@Override
	public boolean adminLoginCheck(Map<String, String> adminLogin) {
		return db.adminLoginCheck(adminLogin);
	}	

}

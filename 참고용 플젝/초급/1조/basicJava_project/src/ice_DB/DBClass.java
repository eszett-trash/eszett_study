package ice_DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ice_VO.MemberVO;
import ice_VO.IceCreamVO;
import ice_VO.RecordVO;
import ice_VO.SizeVO;

public class DBClass {
	//멤버 리스트
	private List<MemberVO> memberList = new ArrayList<MemberVO>(); 
	//아이스크림 리스트
	private List<IceCreamVO> icecreamList = new ArrayList<IceCreamVO>(); 
	//컵 사이즈리스트
	private List<SizeVO> sizeList = new ArrayList<SizeVO>(); 
	//매출관리리스트
	private List<RecordVO> recordList = new ArrayList<RecordVO>(); 
	// 관리자 아이디
	private String masterId = "123"; 
	// 관리자 비밀번호
	private String masterPw = "123"; 
	// 영수증용 맵
	private Map<String, List<SizeVO>> summaryDB = new HashMap<String, List<SizeVO>>(); 

	public DBClass() {

		IceCreamVO pro1 = new IceCreamVO();
		pro1.setIcecreamName("민트초코칩");
		pro1.setIcecreamNum(10);
		pro1.setIcecreamId("mint");

		IceCreamVO pro2 = new IceCreamVO();
		pro2.setIcecreamName("베리베리 스트로베리");
		pro2.setIcecreamNum(10);
		pro2.setIcecreamId("be");

		IceCreamVO pro3 = new IceCreamVO();
		pro3.setIcecreamName("아몬드봉봉");
		pro3.setIcecreamNum(10);
		pro3.setIcecreamId("bon");

		IceCreamVO pro4 = new IceCreamVO();
		pro4.setIcecreamName("망고탱고");
		pro4.setIcecreamNum(10);
		pro4.setIcecreamId("mango");

		IceCreamVO pro5 = new IceCreamVO();
		pro5.setIcecreamName("슈팅스타");
		pro5.setIcecreamNum(10);
		pro5.setIcecreamId("star");

		icecreamList.add(pro1);
		icecreamList.add(pro2);
		icecreamList.add(pro3);
		icecreamList.add(pro4);
		icecreamList.add(pro5);

		SizeVO size1 = new SizeVO();
		size1.setSizeName("싱글(한가지 맛)");
		size1.setSizeNum(1);
		size1.setSizePrice(3000);

		SizeVO size2 = new SizeVO();
		size2.setSizeName("더블(두가지 맛)");
		size2.setSizeNum(2);
		size2.setSizePrice(5000);

		SizeVO size3 = new SizeVO();
		size3.setSizeName("쿼터(네가지 맛)");
		size3.setSizeNum(4);
		size3.setSizePrice(7000);

		sizeList.add(size1);
		sizeList.add(size2);
		sizeList.add(size3);

		RecordVO re1 = new RecordVO();
		re1.setGoods("싱글(한가지 맛)");
		re1.setPrice(3000);

		RecordVO re2 = new RecordVO();
		re2.setGoods("더블(두가지 맛)");
		re2.setPrice(5000);

		RecordVO re3 = new RecordVO();
		re3.setGoods("쿼터(네가지 맛)");
		re3.setPrice(7000);

		recordList.add(re1);
		recordList.add(re2);
		recordList.add(re3);
	}

	/**
	 * 회원가입
	 * 영수증에서 사용하기 위해 리스트와 summaryDB에 멤버아이디와 리스트를 넣어준다.
	 * 받아온 아이디와 패스워드를 멤버리스트에 추가해준다.
	 * @param newMember
	 * @return
	 */
	public boolean memberCreate(MemberVO newMember) {
		List<SizeVO> size = new ArrayList<SizeVO>();
		summaryDB.put(newMember.getMemberId(), size);
		return memberList.add(newMember);
	}

	/**
	 * 멤버리스트에 저장되어 있는 아이디와 받아온 멤버아이디를 비교해준다.
	 * @param memberId
	 * @return 같은아이디가 있으면(true) 아니면(false)
	 */
	public boolean memberCheckId(String memberId) {
		boolean result = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				return true;
			}
		}
		return result;
	}

	/**
	 * 관리자로그인 체크를 위함
	 * @param loginInfo
	 * @return 동일하면 true 아니면 false
	 */
	public boolean adminLoginCheck(Map<String, String> loginInfo) {
		String memId = loginInfo.get("masterId");
		String memPw = loginInfo.get("masterPw");
		if (memId.equals(masterId) && memPw.equals(masterPw)) {
			return true;
		}
		return false;
	}

	/**
	 * 회원로그인
	 * 받아온 아이디와 패스워드를 멤버리스트의 아이디와 패스워드와 비교함
	 * @param loginInfo
	 * @return 동일하면 true 아니면 false
	 */
	public MemberVO loginCheck(Map<String, String> loginInfo) {
		MemberVO mv = null;
		for (int i = 0; i < memberList.size(); i++) {
			if(loginInfo.get("id").equals(memberList.get(i).getMemberId()) && loginInfo.get("pw").equals(memberList.get(i).getMemberPassword())){
				mv = memberList.get(i);
			}
		}
		return mv;
	}

	/**
	 * 아이스크림 선택시 아이스크림 리스트에서 수량을 하나씩 빼줌
	 * @param order
	 * @return 
	 */
	public boolean Order(int order) {
		// 아이스크림종류
		int num = icecreamList.get(order).getIcecreamNum();
		icecreamList.get(order).setIcecreamNum(num - 1);
		return true;
	}

	/**
	 * 아이스크림 리스트 출력용
	 * @return
	 */
	public List<IceCreamVO> memberGetIcecream() {
		return icecreamList;
	}

	/**
	 * 받아온 아이디에 해당하는 영수증 출력용
	 * @param memberId
	 * @return
	 */
	public List<SizeVO> memberGetSummary(String memberId) {
		return summaryDB.get(memberId);
	}

	/**
	 * 회원의 패스워드를 수정할 시 사용
	 * 아이디와 변경할 패스워드를 받아온 후 멤버리스트에서 해당하는
	 * 아이디를 검색하여 패스워드를 변경할 패스워드로 바꿔줌
	 * @param updateSend
	 * @return 성공시 true 아니면 false
	 */
	public boolean updateMemberInfo(Map<String, String> updateSend) {
		String id = updateSend.get("id");
		String password = updateSend.get("pw");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberId().equals(id)) {
				memberList.get(i).setMemberPassword(password);
				;
				return true;
			}
		}
		return false;
	}

	/**
	 * 회원의 현금충전용
	 * 아이디와 충전하고자하는 현금을 받아와 멤버리스트에 해당하는 아이디의
	 * 현금을 받아온 현금금액으로 저장해 준다.
	 * @param id
	 * @param money
	 * @return
	 */
	public int inputMoney(String id, int money) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberId().equals(id)) {
				memberList.get(i).setMbUserMoney(money);
				return memberList.get(i).getMbUserMoney();
			}
		}
		return -1;
	}

	/**
	 * 회원탈퇴,삭제시 사용
	 * 삭제하고자 하는 아이디를 받아와 멤버리스트에 해당하는 아이디를 삭제해준다
	 * @param memberId
	 * @return 성공시 true 아니면 false
	 */
	public boolean deleteMember(String memberId) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberId().equals(memberId)) {
				memberList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 관리자가 회원을 조회하기위해 사용
	 * @return memberList
	 */
	public List<MemberVO> memberAll() {
		return memberList;
	}

	/**
	 * 아이스크림의 재고주문을 위해 사용
	 * 아이스크림리스트의 인덱스값과 주문하고자 하는 수량을 받아와
	 * 아이스크림리스트의 인텍스값의 수량에 주문한 수량을 추가해주고
	 * 최종수량을 set해준다(저장해준다).
	 * @param productAdd
	 * @return
	 */
	public boolean productAdd(Map<String, Integer> productAdd) {
		int index = productAdd.get("iceIndex");
		int num = productAdd.get("icenum");
		int total = icecreamList.get(index).getIcecreamNum() + num;
		icecreamList.get(index).setIcecreamNum(total);
		return true;
	}

	/**
	 * 컵사이즈별 가격이 변동시 사용
	 * 변경하고자하는 컵사이즈리스트의 인덱스값과 변경하고자하는 가격을 받온 후
	 * 사이즈리스트에서 가격을 변동해준다.
	 * @param productChg
	 * @return
	 */
	public boolean productChg(Map<String, Integer> productChg) {
		int index = productChg.get("Size");
		int num = productChg.get("Price");
		sizeList.get(index).setSizePrice(num);

		return true;
	}

	/**
	 * 매출조회를 위해 사용
	 * 리스트로 반환해준다.
	 * @return recordList
	 */
	public List<RecordVO> recordSale() {
		return recordList;
	}

	/**
	 * 컵 사이즈의 가격등 정보를 리스트 형태로 반환
	 * @return sizeList
	 */
	public List<SizeVO> getSize() {
		return sizeList;
	}

	/**
	 * 레코드형태로 받아와 구매가 이루어 질때마다 레코드리스트에 구매가 이루어진 품목 가격 수량을
	 * 추가해준다.
	 * 품목이름과 리스트의 품목이름이 같으며 그 품목의 가격과 리스트품목의 가격이 같으면 정보를 추가해주고,
	 * 품목이름은 같으나 가격이 변동되어 이전 가격과 다를 시 레코드리스트에 새로이 추가해서 반환해준다.
	 * @param recordvo
	 * @return 가격변동이 없을시 true 가격변동이 있을 시 recordList.add(recordvo)
	 */
	public boolean recordAdd(RecordVO recordvo) {
		for (int i = 0; i < recordList.size(); i++) {
			if (recordvo.getGoods().equals(recordList.get(i).getGoods())) {
				if (recordvo.getPrice() == recordList.get(i).getPrice()) {
					recordList.get(i).setCount(
							recordList.get(i).getCount() + recordvo.getCount());
					recordList.get(i).setTotalincome(
							recordList.get(i).getTotalincome()
									+ recordvo.getTotalincome());
					return true;
				}
			}
		}
		return recordList.add(recordvo);
	}

	/**
	 * 회원 구매내역
	 * 멤버아이디와 그아이디가 구매한 품목이 저장되어 있는 sizeVO를 Map형태로 받아온다
	 * 영수증리스트에 해당아이디가 있는지 확인후 없으면 추가하고 있으면 받아온 구매목록리스트를 이용하여
	 * 품목이나 수량을 추가해준후 그 결과값을 영수증 리스트에 원래있던 해당아이디의 구매리스트를 삭제 후 
	 * 새로이 영수증 리스트에 저장해준다
	 * @param summary
	 * @return
	 */
	public boolean memberSummaryVO(Map<String, SizeVO> summary) {
		//초기값 설정
		SizeVO sum = null;
		for (int i = 0; i < memberList.size(); i++) {
			//memberNumber에 멤버리스트의 해당인덱스의 아이디를 저장해줌
			String memberNumber = memberList.get(i).getMemberId();
			// 로그인할때 저장된 서머리디비의 회원정보에 해당하는 영수증을 불러와서 섬프로에 저장
			List<SizeVO> sumpro = summaryDB.get(memberNumber);
			try {
				//받아온 map에서 해당하는 아이디의 sizeVO(구매내역)을 sum에 저장한다.
				sum = summary.get(memberNumber);
			} catch (NullPointerException e) {
				//오류발생 시 해당하는 멤버의 리스트에 null값을 준다.
				summaryDB.put(memberNumber, null);
				return true;
			}
			//영수증리스트에 해당하는 아이디의 리스트정보가 없을 시 리스트를 새로 만들어서 영수증리스트에 추가해 준다.
			if (sumpro == null) {
				List<SizeVO> pr = new ArrayList<SizeVO>();
				summaryDB.put(memberNumber, pr);
				return true;
			}
			
			SizeVO sumList;
			//받아온 map=summary에 i번째 인덱스의 아이디가 해당되어있고 해당아이디의 구매내역이 저장되어있는
			//sumpro가 null이 아닐때 실행
			if (summary.containsKey(memberNumber) && sumpro != null) {
				//구매내역의 인덱스값만큼 반복
				for (int j = 0; j < sumpro.size(); j++) {
					try {
						//구매내역의 j번째 인덱스 정보를 저장
						sumList = sumpro.get(j);
						//구매내역의 j번째 인덱스에 들어있는 품목이름과 해당아이디의 구매내역의에 같은 품목이름이 존재시 실행
						if (sumList.getSizeName().equals(sum.getSizeName())) {
							//구매내역의 j번째 인덱스에 품목의 이름과,가격,구매갯수를 저장
							sumList.setSizeName(sum.getSizeName());
							sumList.setSizePrice(sum.getSizePrice()
									+ sumList.getSizePrice());
							sumList.setSizeNum(sumList.getSizeNum() + 1);
							//sumpro=로그인할때 저장 된 서머리디비의 회원정보에 해당하는 영수증을 불러와서 저장
							//j번째리스트를 삭제 후 j번쨰리스트에 새로 저장한 값의 리스트를 저장해준다.
							sumpro.remove(j);
							sumpro.add(j, sumList);
							//영수증리스트에 현재멤버아이디와 구매정보를 저장해 준다.
							summaryDB.put(memberNumber, sumpro);
							return true;
						}
					} catch (NullPointerException e) {
						//오류시 발생
						sum.setSizePrice(sum.getSizePrice());
						sumpro.remove(0);
						sumpro.add(sum);
						summaryDB.put(memberNumber, sumpro);
						return true;
					}
				}//for문 끝
				//sum = 받아온 map에서 해당하는 아이디의 sizeVO(구매내역)을 저장
				//구매내역에 원래값을 저장후 해당아이디의 영수증에 추가해준다. 영수증 리스트에 해당아이디의 구매내역을 추가해줌
				sum.setSizePrice(sum.getSizePrice());
				sumpro.add(sum);
				summaryDB.put(memberNumber, sumpro);
				return true;
			} else if (summary.containsKey(memberNumber)) {
				//받아온 map=summary에 i번째 인덱스의 아이디가 해당되어있고 해당아이디의 구매내역이 저장되어으면 실행
				//구매내역에 원래값을 저장후 해당아이디의 영수증에 추가해준다. 영수증 리스트에 해당아이디의 구매내역을 추가해줌
				sum.setSizePrice(sum.getSizePrice());
				sumpro.add(sum);
				summaryDB.put(memberNumber, sumpro);
				return true;
			}
		}
		return false;
	}

	/**
	 * 회원별 총 구매 내역
	 * 사이즈리스트형 변수에 받아온 멤버변수에 해당하는 영수증을 저장 후
	 * 반복문을 사용해 리스트의 해당하는 인덱스의 가격을 계속더해준후 그 값을 리턴해준다.
	 * @param memberId
	 * @return
	 */
	public int allSum(String memberId) {
		List<SizeVO> sizeL = summaryDB.get(memberId);
		int totalsum = 0;
		for (int i = 0; i < sizeL.size(); i++) {
			totalsum += sizeL.get(i).getSizePrice();
		}
		return totalsum;
	}

}

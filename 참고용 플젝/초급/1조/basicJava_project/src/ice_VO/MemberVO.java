package ice_VO;

import java.util.ArrayList;
import java.util.List;

import ice_VO.IceCreamVO;

public class MemberVO {
	private String memberId; // 아이디
	private String memberPassword; // pw
	private int mbUserMoney;   //충전된 금액
	
	public int getMbUserMoney() {
		return mbUserMoney;
	}

	public void setMbUserMoney(int mbUserMoney) {
		this.mbUserMoney += mbUserMoney;
	}

	// 멤버의 product 구매 내역을 저장하는 List
	private List<IceCreamVO> summary = new ArrayList<IceCreamVO>();

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public List<IceCreamVO> getSummary() {
		return summary;
	}

	public void setSummary(List<IceCreamVO> summary) {
		this.summary = summary;
	}
	
	
	
}


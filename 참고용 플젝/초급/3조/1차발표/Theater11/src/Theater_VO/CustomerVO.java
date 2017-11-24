package Theater_VO;

public class CustomerVO {
	
	private String cIndex; //index id
	private String cId; //아이디
	private String cPw; //패스워드
	private String cName;//이름
	private int cMoney;//고객 돈
	
	
	public final String getcIndex() {
		return cIndex;
	}
	public final void setcIndex(String cIndex) {
		this.cIndex = cIndex;
	}
	public final String getcId() {
		return cId;
	}
	public final void setcId(String cId) {
		this.cId = cId;
	}
	public final String getcPw() {
		return cPw;
	}
	public final void setcPw(String cPw) {
		this.cPw = cPw;
	}
	public final String getcName() {
		return cName;
	}
	public final void setcName(String cName) {
		this.cName = cName;
	}
	public final int getcMoney() {
		return cMoney;
	}
	public final void setcMoney(int cMoney) {
		this.cMoney = cMoney;
	}
	
	
	
	
}

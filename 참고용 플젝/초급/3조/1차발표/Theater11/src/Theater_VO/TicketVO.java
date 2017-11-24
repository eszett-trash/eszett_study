package Theater_VO;

public class TicketVO {
	
	private String tSeatNum; //좌석번호
	private String tPeoNum; //인원수
	//참조 
	private String cId; // 산 사람의 아이디
	private String mName; // 영화이름 참조
	private String mRuntime; //상영시간
	private String mDate;//날짜
	private String mRoom; //상영관
	
	
	public final String gettSeatNum() {
		return tSeatNum;
	}
	public final void settSeatNum(String tSeatNum) {
		this.tSeatNum = tSeatNum;
	}
	public final String gettPeoNum() {
		return tPeoNum;
	}
	public final void settPeoNum(String tPeoNum) {
		this.tPeoNum = tPeoNum;
	}
	public final String getcId() {
		return cId;
	}
	public final void setcId(String cId) {
		this.cId = cId;
	}
	public final String getmName() {
		return mName;
	}
	public final void setmName(String mName) {
		this.mName = mName;
	}
	public final String getmRuntime() {
		return mRuntime;
	}
	public final void setmRuntime(String mRuntime) {
		this.mRuntime = mRuntime;
	}
	public final String getmDate() {
		return mDate;
	}
	public final void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public final String getmRoom() {
		return mRoom;
	}
	public final void setmRoom(String mRoom) {
		this.mRoom = mRoom;
	}
	
	
}

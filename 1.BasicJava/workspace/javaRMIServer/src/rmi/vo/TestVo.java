package rmi.vo;

public class TestVo {
	
	/*
	 RMI에서 데이터 전달용으로 사용되는 클래스는 작렬화가 필요하기 떄문이 Serializable을 구현해서 작성한다, 
	 */
	private String testId;
	private int testNum;
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public int getTestNum() {
		return testNum;
	}
	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

}

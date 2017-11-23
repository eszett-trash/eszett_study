package ice_VO;

public class SizeVO {
	private String sizeName; // 사이즈 이름
	private int sizeNum; // 사이즈 별 가짓수 맛
	private int sizePrice; // 사이즈 별 가격
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public int getSizeNum() {
		return sizeNum;
	}
	public void setSizeNum(int sizeNum) {
		this.sizeNum = sizeNum;
	}
	public int getSizePrice() {
		return sizePrice;
	}
	public void setSizePrice(int sizePrice) {
		this.sizePrice = sizePrice;
	}
	
	@Override
	public String toString() {
		return "SizeVO [sizeName=" + sizeName + ", sizeNum=" + sizeNum
				+ ", sizePrice=" + sizePrice + "]";
	}
	
	
}

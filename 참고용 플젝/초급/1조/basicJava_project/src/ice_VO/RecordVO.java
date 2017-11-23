package ice_VO;

public class RecordVO {
	private String goods; // 컵 판매 물품 이름
	private int count; // 판매 수량
	private int price; // 판매당시금액
	private int totalIncome; //count* price

	public int getTotalincome() {
		return totalIncome;
	}

	public void setTotalincome(int totalincome) {
		this.totalIncome = totalincome;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RecordVO [goods=" + goods + ", count=" + count + ", income="
				+ price + ", totalincome=" + totalIncome + "]";
	}
}
package pizzaPrj;

public class MenuVO {
	/* 첫자리 : 기본메뉴 코드 :맨 뒤 세자리0000111 */
	/* 둘째자리 : 사이드메뉴 코드 : 0011000 */
	/* 셋째자리: 이벤트 메뉴 코드 : 1100000 */

	private int id; // 아이디 조건 위 볼것
	private String name;
	private String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

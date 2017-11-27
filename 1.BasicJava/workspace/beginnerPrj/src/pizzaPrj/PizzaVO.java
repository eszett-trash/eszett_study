package pizzaPrj;

public class PizzaVO {

}

class UserVO {
	String id;
	String pwd;
	String email;
	String addredd;
	int phone;
	int point;
	int sales;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddredd() {
		return addredd;
	}

	public void setAddredd(String addredd) {
		this.addredd = addredd;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}

class MenuVO {
	/* 첫자리 : 기본메뉴 코드 :맨 뒤 세자리0000111 */
	/* 둘째자리 : 사이드메뉴 코드 : 0011000 */
	/* 셋째자리: 이벤트 메뉴 코드 : 1100000 */

	int id; // 아이디 조건 위 볼것
	String name;
	String price;

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

class additionalVO {
	/* 2147483647 */
	/* 1~3 사이즈/8388607: 토핑 / 1~6 도우 */
	/* 첫자리 0 1 2 < 사이즈 */
	int id;
	String name;
	String price;
	
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
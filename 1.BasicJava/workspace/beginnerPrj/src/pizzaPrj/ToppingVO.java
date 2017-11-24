package pizzaPrj;

public class ToppingVO {
		/*https://dojang.io/mod/page/view.php?id=184*/
	private final int onion = 0x1;
	private final int piman = 0x2;
	private final int houren = 0x4;
	private final int spinach = 0x8;
	private final int fineapple = 0x10;
	private final int olive = 0x20;
	private final int mushroom = 0x40;
	private final int cornsalard = 0x80;
	private final int mayo = 0x100;
	private final int garlic = 0x200;
	private final int halapiona = 0x400;
	private final int camemvert = 0x800;
	private final int pepperonni = 0x1000;
	private final int rossham = 0x2000;
	private final int sausage = 0x4000;
	private final int italiansausage = 0x8000;
	private final int panzeta = 0x10000;
	private final int dblCheese = 0x20000;
	private final int bacon = 0x40000;
	private final int enchoubi = 0x80000;

	public int getOnion() {
		return onion;
	}
	public int getPiman() {
		return piman;
	}
	public int getHouren() {
		return houren;
	}
	public int getSpinach() {
		return spinach;
	}
	public int getFineapple() {
		return fineapple;
	}
	public int getOlive() {
		return olive;
	}
	public int getMushroom() {
		return mushroom;
	}
	public int getCornsalard() {
		return cornsalard;
	}
	public int getMayo() {
		return mayo;
	}
	public int getGarlic() {
		return garlic;
	}
	public int getHalapiona() {
		return halapiona;
	}
	public int getCamemvert() {
		return camemvert;
	}
	public int getPepperonni() {
		return pepperonni;
	}
	public int getRossham() {
		return rossham;
	}
	public int getSausage() {
		return sausage;
	}
	public int getItaliansausage() {
		return italiansausage;
	}
	public int getPanzeta() {
		return panzeta;
	}
	public int getDblCheese() {
		return dblCheese;
	}
	public int getBacon() {
		return bacon;
	}
	public int getEnchoubi() {
		return enchoubi;
	}
	

	
	
}

class UserVO{
	String id;
	String pwd;
	String email;
	String addredd;
	int phone;
	
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

class MenuVO
{
	/* 첫자리 : 기본메뉴 코드 001 = 1*/
	/* 둘째자리 : 사이드메뉴 코드 010 =2*/
	/* 셋째자리: 이벤트 메뉴 코드 100 = 4*/
	
	/*첫자리부*/
	
}

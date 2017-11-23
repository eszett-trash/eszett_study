package ice_Main;

import java.util.regex.Pattern;

public class RegClass {
	public boolean idRegEx(String mem_id) {// 영문 숫자 총 6자 이상 10자 이하
		return Pattern.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,10}$",mem_id);
	}

	public boolean idRegEx1(String mem_pw) {//  영문 숫자 특수문자 포함 총 8자 이상 20자 이하
		return Pattern.matches("^(?=.*[0-9])(?=.*[~`!@#$%^&*()-])(?=.*[a-zA-Z]).{8,20}$", mem_pw); 
	}
	
	public boolean amountCheck(String amount){
		return Pattern.matches("0|[1-9]{1}[0-9]*",amount);
	}
}

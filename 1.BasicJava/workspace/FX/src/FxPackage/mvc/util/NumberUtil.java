package FxPackage.mvc.util;

import java.util.regex.Pattern;

public class NumberUtil {

	public static boolean isInteger(String str) {
		if(str==null) return false;
		
		if(Pattern.matches("^[0-9]+$", str)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean isNumber(String str) {
		if(str==null) return false;
		
		if(Pattern.matches("^[0-9]+[.]?[0-9]*$", str)) {
			return true;
		}else {
			return false;
		}
	}
}










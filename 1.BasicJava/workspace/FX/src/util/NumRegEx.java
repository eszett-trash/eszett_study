package util;

import java.util.regex.Pattern;

public class NumRegEx {
	public static boolean isInteger(String str) {
		if (str.isEmpty()) {
			return false;
		}
		if (Pattern.matches("^[0-9]+$", str)) {
			return true;
		}
		return false;
	}

	public static boolean isNumber(String str) {
		if (str.isEmpty()) {
			return false;
		}

		if (Pattern.matches("^[0-9]+[.]?[0-9]*$", str)) {
			return true;
		}
		return false;
	}
}

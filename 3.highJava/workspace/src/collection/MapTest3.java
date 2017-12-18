package collection;

import java.util.HashMap;

public class MapTest3 {
	public static void main(String[] args) {
		String str = "An object that maps keys to values";

		HashMap<Character, Integer> dupl = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)!=' ') {
				if (dupl.containsKey(str.charAt(i))) {
					dupl.put(str.charAt(i), dupl.get(str.charAt(i)) + 1);
				} else {
					dupl.put(str.charAt(i), 1);
				}	
			}
		}
		for (Character string : dupl.keySet()) {
			System.out.println(string + "\t==>\t" + dupl.get(string));
		}
	}
}

public class Rot13 {
	public static void main(String[] args) {
		String rot13 = " VG'F ERAAR VG'F ERAAR VG'F ERAAR VG'F ERAAR";
		String tt = "";
		for (int i = 0; i < rot13.length(); i++) {
			if (rot13.charAt(i) != ' ') {
				tt = tt+(rot13.charAt(i)-'\n');
			} else {
				tt += " ";
			}
		}

		System.out.println(tt);
	}
}

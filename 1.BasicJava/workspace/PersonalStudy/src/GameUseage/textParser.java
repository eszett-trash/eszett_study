package GameUseage;

import java.io.IOException;


public class textParser {

	public static void main(String[] args) throws IOException {
		new Resource();
		
		ReadTxt rt = new ReadTxt();
		for (int i = 0; i < rt.getSize(); i++) {
			System.out.println(rt.PrintTxt(i));
		}
	}

}

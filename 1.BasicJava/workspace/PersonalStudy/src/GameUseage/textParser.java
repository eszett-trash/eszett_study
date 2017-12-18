package GameUseage;

import java.io.IOException;


public class textParser {

	public static void main(String[] args) throws IOException {
		ReadTxt rt = new ReadTxt();
		for (int i = 0; i < rt.getSize(); i++) {
			System.out.println(rt.PrintTxt(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

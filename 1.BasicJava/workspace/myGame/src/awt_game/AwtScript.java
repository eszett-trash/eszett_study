package awt_game;

import java.awt.Frame;
import java.io.IOException;

public class AwtScript extends Frame {
	public static void main(String[] args) {

		ConvScript cs = new ConvScript(10);
		
	
		
		
		
		
//		DataManagement dm = new DataManagement();
//		try {
//
//			dm.saveData(20, 10,"주인공 이름");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		// AwtScript as = new AwtScript();
	}

	// @Override
	// public void paint(Graphics g) {
	// // 여기가 드로잉
	// super.paint(g);
	// }
	//
	// public AwtScript() {
	// super("파일 입출력 연습");
	//
	// setVisible(true);
	// }

}

class ConvScript extends DataManagement {
	
	ConvScript(int line) {
		super.readLine = line;
	}

}
package awt_game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class DataManagement {
	final int MAX_GOLD = 9999999;
	final int MIN_GOLD = 0;

	int readLine;
	int gold;
	String charname;

	DataManagement() {
	}

	void saveData(int readLine, int gold, String charname) throws IOException {
		PrintWriter fos = new PrintWriter("saveData/out.txt");
		fos.write("charname=" + charname + "\r\n");
		fos.write("readLine=" + readLine + "\r\n");
		fos.write("gold=" + gold + "\r\n");
		fos.close();
	}

	void loadData() throws IOException {
		// 세이브 파일 열기(한글이 꺠지므로 한글 읽어들이기)
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("saveData/out.txt"), "euc-kr"));

		// 하나하나 출력
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			// 파일을 읽어오면서 각 값을 저장해온다.
			String[] a = line.split("=");
			if (a[0] == "charname") {
				DataManagement.this.charname = a[1];
			} else if (a[0] == "readLine") {
				DataManagement.this.readLine = (int) (a[1].charAt(1));
			} else if (a[0] == "gold") {
				DataManagement.this.gold = (int) (a[1].charAt(1));
			}
			// 임시
			System.out.println(a[0] + "=" + a[1]);
		}
	}
}
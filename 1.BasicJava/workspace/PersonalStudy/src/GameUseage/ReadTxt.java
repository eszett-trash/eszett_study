package GameUseage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 텍스트 파싱 클래스
 * @author yh.eszett@gmail.com
 *
 */
public class ReadTxt {
	private final int MAX_TEXT_PER_LINE = 40; 
	private ArrayList<String> text = new ArrayList<String>();
	private final int SIZE;
	
	public ReadTxt() throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(
						"D:\\eszett_study\\1.BasicJava\\workspace\\PersonalStudy\\text.txt"));
		while(true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			text.add(line);
		}
		br.close();
		this.SIZE = text.size(); // initialize size
	}
	/**
	 * 대사 텍스트를 화면에 맞게 자르는 함수.
	 * 
	 * @param parse text
	 * @return none
	 */
	private String splittxt(String txt) {
		String returnTxt = "";
		if (txt.length() > MAX_TEXT_PER_LINE) {
			String temp[] = new String[txt.length() / MAX_TEXT_PER_LINE + 1];
			for (int i = 0; i < temp.length - 1; i++) {
				if(!txt.substring(MAX_TEXT_PER_LINE * i,MAX_TEXT_PER_LINE * (i + 1)).isEmpty());{
					temp[i] = txt.substring(MAX_TEXT_PER_LINE * i,MAX_TEXT_PER_LINE * (i + 1)).trim();
				}//close if	
			}//close for loop
			temp[temp.length-1] = txt.substring((temp.length-1)*MAX_TEXT_PER_LINE,txt.length());
			for (int i = 0; i < temp.length; i++) {
				returnTxt += temp[i] + "\n";
			}//close for loop
		} else {
			returnTxt = txt;
		}//cloase if
		return returnTxt;
	}
	//시작하는게 대사인지 주석인지 판단
	//
	/**
	 *  getter of size
	 * @return size
	 */
	public int getSize() {
		return SIZE;
	}
	/**
	 * read text line of index
	 * 
	 * @param index
	 * @return text of index
	 */
	public String PrintTxt(int index) {	return splittxt(text.get(index));}
}
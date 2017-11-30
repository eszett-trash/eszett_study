package basic_171128;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression {
	public static void main(String[] args) {
//		Map<String, Integer> map = new HashMap<String,Integer>();
//		map.put("가",new Integer(110));
//		map.put("나",new Integer(150));
//		map.put("다",new Integer(110));
//		map.put("라",new Integer(120));
//		map.put("마",new Integer(100));
//		System.out.println(map.get("다"));
//		System.out.println(map);
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////정규식//////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////		
		//Pattern 이라는 클래스를 이용하여 정규식을 정의한다
		//Matcher클래스를 이용하여 pattern과데이터를 비교
		
		Pattern p = Pattern.compile("[a-z]*"); 
		Matcher m = p.matcher("asdfasdf");
		
		System.out.println(m.matches());
		/*
		 	^  : 문자열 시작
		 	$  : 문자열 끝
		 	.  : 임의의 한문자( \ 제외)
		 	*  : 문자가 없을수도 무한정 있을수도 있다.
		 	+  : 문자가 하나이상
		 	?  : 문자가 하나 이하
		 	[] : 문자의 집합이나 범위를 나타내며, 두 문자 사이는 =기호를 볌위로 나타낸다.
		 	 	 []내에서 ^이 존재하면 not의 의미를 가진다.
		 	{} : 횟수 또는 범위를 나타낸다.
		 	() : 소괄호 안의 문자를 하나의 문자로 인식한다.
		 	 | : or 연산
		 	\s : 공백문자
		 	\S : 공백을 제외한 모든 문자
		 	\w : 알파벳이나 숫자
		 	\W : 알파벳이나 숫자를 제외한 모든문자
		 	\d : 숫자
		 	\  : 확장문자		 
		 */
		//문자열 예제 : LV1
		String regEx01 ="[a-z]{2,3}";
		System.out.println(Pattern.matches(regEx01, "aaa"));
		
		String regEx02 = "^(01)[016-9]{1}-\\d{3,4}-\\d{4}$";
		System.out.println(Pattern.matches(regEx02, "010-9379-9431"));
		
		String regEx03 ="^((\\d){2}((0\\d)|(1[0-2]))((0[1-9])|([12]\\d)|(3[01]))){1}-?(([1-4]){1}(\\d){6}){1}$";
		System.out.println(Pattern.matches(regEx03, "9210227-1561111"));
		
		String regEx04 ="^[a-zA-Z][-_\\\\.\\w]*{3,}@\\w{1,5}[.][a-zA-Z]{2,3}([.][a-zA-Z]{2})?$";
		System.out.println(Pattern.matches(regEx04, "yheszett@gmail.com.kr"));

	}
}

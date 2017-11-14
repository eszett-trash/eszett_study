package rect_01;

import java.util.Iterator;

/*
 자료구조
 -큰 데이터를 편하게 관리하는 것이 주 목적.
 -
 */

//class Rect_01{
//	public static void firstRectEx(){
//	//배열
//	
//	/*******************************************************************/
//	int[] num1 = new int[4];
//	//배열생성
//	
//	num1[0]=10;
//	num1[1]=20;
//	num1[2]=30;
//	num1[3]=40;
//	
//	for(int i = 0;i<4;i++){
//		System.out.println(num1[i]);
//	}
//	
//	System.out.println(num1.length);
//	//배열 길이
//	
//	/*
//	 * iteration 반복
//	 * 
//	 * */
//	
//	int i = 0;
//	while (num1.length > i) {
//		
//		System.out.println(num1[i]);
//		i++;
//	}
//	
//	/*******************************************************************/
//	
//	//리스트
//	/*
//	  
//	  배열과 리스트
//	  
//	  	공통점
//		 	데이터가 순서대로 저장된다
//		 	중복 저장이 허용된다
//	 	
//	 	차이점
//	 		배열
//	 			-인덱스가 중요
//	 			
// 			리스트
// 				-처음 끝 중간에 엘리먼트를 추가/삭제하는 기능
// 				-삭제된 자리를 채우는 기능
// 				-리스트에 데이터가 있는지를 체크하는 기능
// 				-모든 데이터에 접근 할 수 있는 기능
// 					 
//	 */
//		
//	ArrayList<Integer> list = new ArrayList<>();
//	//<> <-제너릭 / 리스트안에 들어가는 변수들이 전부 인티저라는 선언
//	// ArrayList의 Attribute
//	// 추가 : add(변수);
//	// 삭제 : remove(인덱스);
//	// 특정 인덱스에 위치한 엘리먼트를 가져올 경우 : get(인덱스);
//	// 크기 확인 : size();
//	//
//	//
//	//
//	// 이터레이터
//	//  	: 자바의 데이터타입 / 인터페이스
//	Iterator it = list.iterator();
//		//1번
//		while (it.hasNext()) { //it가 가져올 다음 엘리먼트가 있는가에 대한 판단
//			int value = (int)it.next(); //value에 다음 엘리먼트값을 넣는다. 그렇게 쭉 넣다보면 마지막 엘리먼트를 뽑아낼 수 있다.
//										//object 데이터타입으로 저장되기때문에 int로 형변환해서 사용
//				if(value == 30){
//					it.remove(); 		//이런식으로 지우기도 함	
//				}
//			}
//		//2번
//		for(int value : list)
//		{
//			System.out.println(value);	//위랑 같은 경우
//		}
//		//3번
//		for (int j = 0; j < list.size(); j++) { //위랑 같은거임
//			System.out.println(list.get(i));
//		}
//		
//        ArrayList<String> my_arr_list = new ArrayList<String>();
//
//        my_arr_list.add("hello");
//        my_arr_list.add("java");
//        my_arr_list.add("world!");
//
//        Iterator<String> temp = my_arr_list.iterator();
//
//        // while문으로 my_arr_list의 모든 원소를 출력해봅시다.
//        while(it.hasNext())
//        {
//        	String j = (String)temp.next();
//            System.out.println(j);
//        }
//	}
//
//}
class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100]; // 프라이빗 접근제어자 + 100개// 제너릭과는
													// 반대로 모든 자료형을 받아들이기 위해
													// Object 배열을 선언

	public boolean addLast(Object element) {
		elementData[size] = element; // addLast로 들어온 element인자의 값이 size값이 됨
		size++;
		return true;
	}

	public boolean add(int index, Object e) {
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		elementData[index] = e;
		size++;
		return true;
	}

	public boolean addFirst(Object e) {
		return add(0, e);
	}

	public Object get(int index) {
		return elementData[index];
	}

	public int size() {
		return size; // 외부에서 사이즈에 마음대로 접근하지 못하게 하기 위해 이렇게 함
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}
}

public class List {
	public static void main(String[] args) {

		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1, 15);
		numbers.addFirst(5);
		System.out.println(numbers.indexOf(20));
		System.out.println(numbers);

	}// main
}

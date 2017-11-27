package basic_171127;


public class Exception03 {
	public static void main(String[] args) {
		Exception e= new Exception();
		
//		try{
//			throw e;
//		}
//		catch(Exception e1)
//		{
//			e1.printStackTrace();
//		}
		
		try {
			
			throw new RuntimeException("그냥 발생시켜봄ㅎ;");
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
			e2.printStackTrace();
		}
		
		System.out.println("end");
	}
	//컴파일러가 예외를 강제하지 않는 경우
	//1.RuntimeException
	//2.Error
	//	====>이것들은 'unchecked예외' 라고 부른다.
}

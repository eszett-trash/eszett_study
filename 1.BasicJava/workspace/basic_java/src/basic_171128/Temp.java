package basic_171128;

public class Temp {
	public static void main(String[] args) {
//		Runtime rt = Runtime.getRuntime();
//		System.out.println(rt.freeMemory());
//		System.out.println(rt.totalMemory());
//		long s = System.currentTimeMillis();
//		String a = "a";
//		for (int i = 0; i < 30000; i++) {
//			a+="a";
//		}
//		long t = System.currentTimeMillis();
//		System.out.println(rt.freeMemory());
//		System.out.println(rt.totalMemory());
		
		
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
		long s = System.currentTimeMillis();
		StringBuffer a = new StringBuffer("a");
		for (int i = 0; i < 300000000; i++) {
			a.append("a");
		}
		long t = System.currentTimeMillis();
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
		
		System.out.println(t-s);
	}
}

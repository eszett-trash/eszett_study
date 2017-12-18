package generic;

/*
  How to make generic class
  
  class CLASSNAME<GENERICTYPE>{
  	GENERICTYPE VARIABLE; 								//using variable declaration
  	...
  	GENERICTYPE METHODNAME(){ 					//being return value
  		...
  		return value;
  	}
  	METHODNAME(GENERICTYPE VARIABLE){ 		//using parameter variable
  	
  	}
 }
 --------------generic 
 t->type
 k->key
 v->value
 e->element
  
 */
class NonGenericClass{
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGenericClass<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
}

public class GenericTest {
	public static void main(String[] args) {
		NonGenericClass ngl = new NonGenericClass();
		
		ngl.setVal("가나다라");
		String rtn = (String)ngl.getVal();
		
		NonGenericClass ngl2 = new NonGenericClass();
		ngl2.setVal(100);
		Integer irtn = (Integer) ngl2.getVal();
		
		//no cast requires
		MyGenericClass<String> mg1 = new MyGenericClass<String>();
		mg1.setVal("가나다라");
		String myrtn = mg1.getVal();

		MyGenericClass<Integer> mg2 = new MyGenericClass<>();
		mg2.setVal(123);
		int myrtn1 = mg2.getVal();
		
	}
}

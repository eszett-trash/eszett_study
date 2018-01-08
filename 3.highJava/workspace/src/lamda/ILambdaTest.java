package lamda;

@FunctionalInterface
public interface ILambdaTest {
	public void test();
}

@FunctionalInterface
interface ILambdaTest2 {
	public void test(int a);
}

@FunctionalInterface
interface ILambdaTest3 {
	public int test(int a, int b);
}
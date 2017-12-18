public class Singleton {
	private static Singleton s = new Singleton();

	private Singleton() {}

	public Singleton getInstance() {
		return s;
	}
}

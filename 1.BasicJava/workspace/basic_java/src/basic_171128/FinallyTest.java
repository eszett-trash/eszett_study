package basic_171128;

public class FinallyTest {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteFiles();
		}
	}

	static void startInstall() {

	}

	static void copyFiles() {

	}

	static void deleteFiles() {

	}
}

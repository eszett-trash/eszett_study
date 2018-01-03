package mvcTest.board;

public class Searvice_mvc {
	DB_mvc dm = null;
	private static Searvice_mvc uniqueInstance = new Searvice_mvc();
	private Searvice_mvc(){
		dm = DB_mvc.getInstance();
	}
	public static Searvice_mvc getInstance(){return uniqueInstance;}
}

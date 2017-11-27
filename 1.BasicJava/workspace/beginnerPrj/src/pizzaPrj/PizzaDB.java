package pizzaPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class PizzaDB {

	private Connection connection;
	private String dbFileName;
	private boolean isOpened = false;

	private final static String QUERY_SELECT_BY_NAME = "SELECT * FROM media WHERE FilePath=?;";
	private final static String QUERY_SELECT_BY_NAME_HASHCODE = "SELECT * FROM media WHERE FilePath=? AND CheckSum=?;";
	private final static String QUERY_SELECT_THUMBNAIL = "SELECT Thumbnail FROM media WHERE FilePath=?;";
	public final static String DATABASE = "PIZZA_REGE.db";
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PizzaDB(String databaseFileName) {
		this.dbFileName = databaseFileName;
	}

	public boolean open() {
		try { // 읽기 전용
			SQLiteConfig config = new SQLiteConfig();
			config.setReadOnly(true);
			this.connection = DriverManager.getConnection("jdbc:sqlite:/"
					+ this.dbFileName, config.toProperties());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		isOpened = true;
		return true;
	}

	public boolean close() {
		if (this.isOpened == false) {
			return true;
		}
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean readMeta(String filePath, String hashCode)
			throws SQLException {
		if (this.isOpened == false) {
			return false;
		}
		boolean result = false;
		String query = "SELECT * FROM media WHERE FilePath=? AND CheckSum=?;";
		PreparedStatement prep = this.connection.prepareStatement(query);
		prep.setString(1, filePath);
		prep.setString(2, hashCode);
		ResultSet row = prep.executeQuery();
		if (row.next()) {
			row.getString(1); // index 로 가져오기
			row.getString("FileSize"); // field 이름으로 가져오기
			result = true;
		}
		row.close();
		prep.close();
		return result;
	}
}

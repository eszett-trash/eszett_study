package mvcTest.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Dao_mvc implements IDao_mvc {
	VO_mvc vm = new VO_mvc();
	private static Dao_mvc uniqueInstance = new Dao_mvc();

	private Dao_mvc() {
	}

	public static Dao_mvc getInstance() {
		return uniqueInstance;
	}

	@Override
	public int insertCon(String sql) {
		int cnt = 0;
		try {
			
			PreparedStatement pr = DBUtil.getConnection().prepareStatement(sql);
			
			pr.setInt(1, vm.getNum());
			pr.setString(2, vm.getTitle());
			pr.setString(3, vm.getWriter());
			pr.setString(5, vm.getContent());
			
			cnt = pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return cnt;
	}

	@Override
	public int deleteCon(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCon(VO_mvc dm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VO_mvc> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VO_mvc> getContent() {
		// TODO Auto-generated method stub
		return null;
	}


}

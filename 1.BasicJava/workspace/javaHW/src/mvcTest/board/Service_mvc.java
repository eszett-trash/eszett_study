package mvcTest.board;

import java.util.List;

public class Service_mvc implements IService_mvc{
	private Dao_mvc dam;
	@Override
	public int insertCon(VO_mvc dm) {
		return dam.insertCon(dm);
	}

	@Override
	public int deleteCon(String num) {
		return dam.deleteCon(num);
	}

	@Override
	public int updateCon(VO_mvc dm) {
		return dam.updateCon(dm);
	}

	@Override
	public List<VO_mvc> getList() {
		return dam.getList();
	}

	@Override
	public List<VO_mvc> getContent() {
		return dam.getContent();
	}

}

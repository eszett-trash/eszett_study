package mvcTest.board;

import java.util.List;

public interface IDao_mvc {
	int deleteCon(String num);
	int updateCon(VO_mvc dm);
	List<VO_mvc> getList();
	List<VO_mvc> getContent();
	int insertCon(String sql);
	
}

package mvcTest.board;

import java.util.List;

public interface IService_mvc {
	int insertCon(VO_mvc dm);
	int deleteCon(String num);
	int updateCon(VO_mvc dm);
	List<VO_mvc> getList();
	List<VO_mvc> getContent();
}

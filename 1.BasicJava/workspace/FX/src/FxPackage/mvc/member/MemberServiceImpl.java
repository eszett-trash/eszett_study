package FxPackage.mvc.member;

import java.util.List;
import java.util.Map;

public class MemberServiceImpl implements MemberServiceInf {
	private MemberDaoInf memDao;
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		//memDao = new MemberDaoImpl();
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){
		if(service==null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memDao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return memDao.getMemberCount(memId);
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		return memDao.getSearchMember(searchMap);
	}

}

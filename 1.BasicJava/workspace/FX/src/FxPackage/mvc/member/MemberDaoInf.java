package FxPackage.mvc.member;

import java.util.List;
import java.util.Map;

public interface MemberDaoInf {
	/**
	 * insertMember - MemberVO�� ��� �����͸� DB�� insert�ϴ� �޼���
	 * @param memVo - DB�� ������ �����Ͱ� ��� ��ü
	 * @return �����ϸ� ���� 1, �����ϸ� 0�� ��ȯ
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * ȸ��ID�� �̿��� �����ϴ� �޼���
	 * @param memId
	 * @return
	 */
	public int deleteMember(String memId);
	
	/**
	 * ȸ�� ������ �����ϴ� �޼���
	 * @param memVo
	 * @return
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * ȸ�� ��ü �����͸� �������� �޼���
	 * @return
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * ȸ��ID�� �ο����� �������� �޼���
	 * @param memId
	 * @return
	 */
	public int getMemberCount(String memId);
	

	/**
	 * Map�� ������ �˻� ���ǿ� �´� �����͸� �������� �޼���
	 * @param searchMap
	 * @return
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
}











package Cinema.Members;

import java.util.ArrayList;

public class MembersServiceImpl implements MembersService {

	private MembersDao dao;

	public MembersServiceImpl(MembersDao dao) {
		this.dao = dao;
	}
	@Override
	public boolean login(Members m) {
		// TODO Auto-generated method stub
		Members m2 = dao.select(m.getMid());
		if (m2 == null) {
			System.out.println("존재하지 않는 아이디입니다.");
		} else {
			if (m2.getPwd().equals(m.getPwd())) {
				return true;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		return false;
	}
	@Override
	public void addMembers(Members m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public void delMembers(String mid) {
		// TODO Auto-generated method stub
		dao.delete(mid);
	}

	@Override
	public void editPwd(Members m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public Members getMembers(String mid) {
		// TODO Auto-generated method stub
		return dao.select(mid);
	}

	@Override
	public ArrayList<String> getId(Members m) {
		// TODO Auto-generated method stub
		return dao.selectByInfo(m);
	}

	@Override
	public int age(String mid) {
		// TODO Auto-generated method stub
		return dao.age(mid);
	}

	@Override
	public ArrayList<Members> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
}

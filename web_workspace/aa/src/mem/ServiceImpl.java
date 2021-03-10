package mem;

import java.util.ArrayList;

public class ServiceImpl implements Service {
	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public ArrayList<Member> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Member m = getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			flag = true;
		}
		return flag;
	}

}

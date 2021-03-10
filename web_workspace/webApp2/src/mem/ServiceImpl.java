package mem;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resources.Factory;

public class ServiceImpl implements Service {
	private SqlSessionFactory sqlSessionFactory;// DBø¨∞·

	public ServiceImpl() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.insert(m);
		session.commit(); // db æ≤±‚ ¿€æ˜ æ≤±‚ øœ∑·. commit ≤¿ »£√‚
		session.close();
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		Member m = mapper.select(id);
		session.close();
		return m;
	}

	@Override
	public ArrayList<Member> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		ArrayList<Member> list = mapper.selectAll();
		session.close();
		return list;
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.update(m);
		session.commit();
		session.close();
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.delete(id);
		session.commit();
		session.close();
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

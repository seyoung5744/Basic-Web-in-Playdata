package imgBoard;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import imgBoard.Dao;
import resources.Factory;

public class ServiceImpl implements Service {
	private SqlSessionFactory sqlSessionFactory;// DBø¨∞·

	public ServiceImpl() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public void writeImgboard(ImgBoard ib) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.insert(ib);
		session.commit(); // db æ≤±‚ ¿€æ˜ æ≤±‚ øœ∑·
		session.close();
	}

	@Override
	public ImgBoard getImgboard(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		ImgBoard ib = mapper.select(num);
		session.close();
		return ib;
	}

	@Override
	public ArrayList<ImgBoard> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		ArrayList<ImgBoard> list = mapper.selectAll();
		session.close();
		return list;
	}

	@Override
	public void editImgboard(ImgBoard ib) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.update(ib);
		session.commit();
		session.close();
	}

	@Override
	public void delImgboard(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.delete(num);
		session.commit(); // db æ≤±‚ ¿€æ˜ æ≤±‚ øœ∑·
		session.close();
	}

}

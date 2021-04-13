package board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import board.Dao;
import resources.Factory;


public class ServiceImpl implements Service {
	private SqlSessionFactory sqlSessionFactory;// DB����

	public ServiceImpl() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public void writeBoard(Board b) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		mapper.insert(b);
		session.commit(); // db ���� �۾� ���� �Ϸ�. commit �� ȣ��
		session.close();
	}

	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		Board b = mapper.selectByNum(num);
		session.close();
		return b;
	}

	@Override
	public ArrayList<Board> getByTitle(String title) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		ArrayList<Board> list = mapper.selectByTitle(title);
		session.close();
		return list;
	}

	@Override
	public ArrayList<Board> getByWriter(String writer) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		ArrayList<Board> list = mapper.selectByWriter(writer);
		session.close();
		return list;
	}

	@Override
	public ArrayList<Board> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		ArrayList<Board> list = mapper.selectAll();
		session.close();
		return list;
	}

	@Override
	public void editBoard(Board b) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		mapper.update(b);
		session.commit();
		session.close();
	}

	@Override
	public void delBoard(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();// session open
		Dao mapper = (Dao) session.getMapper(Dao.class);// session�� ���� ���� ��ü ȹ��
		mapper.delete(num);
		session.commit();
		session.close();
	}

}

package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConn;
import mem.Member;

public class DaoImpl implements Dao {
	private DBConn db;

	public DaoImpl() {
		db = DBConn.getInstance();
	}
	@Override
	public void insert(Board b) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "insert into board(writer,w_date,title,content) values(?,sysdate(),?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Board selectByNum(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "select * from board where num=? order by num";
		Board b = null;
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public ArrayList<Board> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "select * from board where writer=? order by num";
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ArrayList<Board> selectByTitle(String title) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "select * from board where title like ? order by num"; // %단어% : title column에서 단어가 들어간 것을 찾아 반환.
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ArrayList<Board> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "select * from board order by num";
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void update(Board b) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update board set w_date=sysdate(), title=?, content=? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "delete from board where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package board;

import java.util.ArrayList;

public interface Dao {
	void insert(Board b);//현재 날짜로 저장.
	Board selectByNum(int num);//글번호로 검색
	ArrayList<Board> selectByWriter(String writer);//작성자로 검색
	ArrayList<Board> selectByTitle(String title);//제목으로 검색
	ArrayList<Board> selectAll();//전제검색
	void update(Board b);//글수정. 글번호로 찾아서, 날짜는 현재로 변경. 제목, 내용을 입력받은 값으로 수정.
	void delete(int num);//글삭제. 글번호로 찾아서
}

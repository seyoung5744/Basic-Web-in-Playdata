package board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Dao {
	@Insert("insert into board(writer,w_date,title,content) values(#{writer},sysdate(),#{title},#{content})")
	void insert(Board b);//현재 날짜로 저장.
	
	@Select("select * from board where num=#{num} order by num")
	Board selectByNum(int num);//글번호로 검색
	
	@Select("select * from board where writer=#{writer} order by num")
	ArrayList<Board> selectByWriter(String writer);//작성자로 검색
	
	@Select("select * from board where title like #{title} order by num")
	ArrayList<Board> selectByTitle(String title);//제목으로 검색
	
	@Select("select * from board order by num")
	ArrayList<Board> selectAll();//전제검색
	
	@Update("update board set w_date=sysdate(), title=#{title}, content=#{content} where num=?")
	void update(Board b);//글수정. 글번호로 찾아서, 날짜는 현재로 변경. 제목, 내용을 입력받은 값으로 수정.
	
	@Delete("delete from board where num=#{num}")
	void delete(int num);//글삭제. 글번호로 찾아서
}

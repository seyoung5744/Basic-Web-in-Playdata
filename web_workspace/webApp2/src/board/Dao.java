package board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Dao {
	@Insert("insert into board(writer,w_date,title,content) values(#{writer},sysdate(),#{title},#{content})")
	void insert(Board b);//���� ��¥�� ����.
	
	@Select("select * from board where num=#{num} order by num")
	Board selectByNum(int num);//�۹�ȣ�� �˻�
	
	@Select("select * from board where writer=#{writer} order by num")
	ArrayList<Board> selectByWriter(String writer);//�ۼ��ڷ� �˻�
	
	@Select("select * from board where title like #{title} order by num")
	ArrayList<Board> selectByTitle(String title);//�������� �˻�
	
	@Select("select * from board order by num")
	ArrayList<Board> selectAll();//�����˻�
	
	@Update("update board set w_date=sysdate(), title=#{title}, content=#{content} where num=?")
	void update(Board b);//�ۼ���. �۹�ȣ�� ã�Ƽ�, ��¥�� ����� ����. ����, ������ �Է¹��� ������ ����.
	
	@Delete("delete from board where num=#{num}")
	void delete(int num);//�ۻ���. �۹�ȣ�� ã�Ƽ�
}

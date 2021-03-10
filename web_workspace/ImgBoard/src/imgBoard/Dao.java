package imgBoard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Dao {
	@Insert("insert into img_board(writer,title,content,path) values(#{writer},#{title},#{content},#{path})")
	void insert(ImgBoard ib);
	
	@Select("select * from img_board where num=#{num}")
	ImgBoard select(@Param("num") int num);
	
	@Select("select * from img_board order by num")
	ArrayList<ImgBoard> selectAll();
	
	@Update("update img_board set title=#{title}, content=#{content} where num=#{num}")
	void update(ImgBoard ib);
	
	@Delete("delete from img_board where num=#{num}")
	void delete(@Param("num") int num);
}

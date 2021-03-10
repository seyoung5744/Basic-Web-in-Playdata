package com.example.demo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MsgDao {
	@Insert("insert into msg(email, pwd, msg) values(#{email}, #{pwd}, #{msg})")
	void insert(MsgVo mv);
	
	@Select("select * from msg order by num")
	ArrayList<MsgVo> selectAll();
	
	@Select("select * from msg where num=#{num}")
	MsgVo select(@Param("num") int num);
	
	@Update("update msg set msg=#{msg} where num=#{num}")
	void update(MsgVo mv);
	
	@Delete("delete from msg whrer num=#{num}")
	void delete(@Param("num") int num);
}

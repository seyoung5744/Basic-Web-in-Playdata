package com.example.demo.mem;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper // 맵퍼로 등록
public interface MemberDao {
	@Insert("insert into member values(#{id},#{pwd},#{name},#{email})")
	void insert(Member m);
	
	@Select("select * from member where id=#{id}")
	Member select(@Param("id") String id);
	
	@Select("select * from member")
	ArrayList<Member> selectAll();
	
	@Update("update member set pwd=#{pwd} where id=#{id}")
	void update(Member m);
	
	@Delete("delete from member where id=#{id}")
	void delete(@Param("id") String id);
}


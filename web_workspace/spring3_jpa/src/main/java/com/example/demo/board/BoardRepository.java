package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board2, Integer> {
	//ArrayList<Board2> findByTitle(String title);  파라메터 값과 title 컬럼이 일치하는 것을 검색
	ArrayList<Board2> findByTitleLike(String title);
	// ArrayList<Board2> findByTitleStringWith(String title); 파라미터 문자로 시작하는 값
	// ArrayList<Board2> findByTitleEndingWith(String title); 파라미터 문자로 끝나는 값
	// ArrayList<Board2> findByTitleContaining(String title); 파라미터 문자를 포함하는 값
	
	//findBy컬럼()
	// findAllOrderBy컬럼명Asc() // 전체 검색...내림차순
}

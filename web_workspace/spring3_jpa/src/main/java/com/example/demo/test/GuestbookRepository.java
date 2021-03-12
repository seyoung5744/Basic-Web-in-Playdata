package com.example.demo.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<GuestBook, Integer> {
	// 이 안에는 아무것도 안쓰임.
	// jpa를 이용한 db 작업 끝!!
	// 객체 클래스, JpaRepository 정의해주는것 말곤 없음
}

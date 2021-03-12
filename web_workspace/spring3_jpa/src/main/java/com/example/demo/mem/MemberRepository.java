package com.example.demo.mem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member2, String> {
	// 기본 적인 동작만 할때는 비워둠
	// 하지만 기본 검색(primary key로 검색하는것)이 아닌 다른 형태로 검색을 하는 경우 BoardRepository처럼 함수 정의를 해줘야함
}

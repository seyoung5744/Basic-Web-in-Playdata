package com.example.demo.down;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DownFileRepository extends JpaRepository<DownFile, Integer> {
	@Transactional
	@Modifying
	@Query(value="update DownFile set cnt=cnt+1 where num=:num")
	void updateCnt(@Param("num") int num);
}

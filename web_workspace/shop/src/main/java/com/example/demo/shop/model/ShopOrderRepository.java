package com.example.demo.shop.model;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Integer> {
	@Transactional
	@Modifying
	@Query(value="update ShopOrder set pay=true where num=:num")
	void updatePay(@Param("num") int num);
	
	ArrayList<ShopOrder> findByConsumer(ShopMember consumer);
}

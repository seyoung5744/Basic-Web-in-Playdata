package com.example.demo.shop.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopMemberRepository extends JpaRepository<ShopMember, String>{

}

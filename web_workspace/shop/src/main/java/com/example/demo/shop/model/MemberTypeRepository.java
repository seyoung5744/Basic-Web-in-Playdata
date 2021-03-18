package com.example.demo.shop.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MemberTypeRepository extends JpaRepository<MemberType, Integer> {

}

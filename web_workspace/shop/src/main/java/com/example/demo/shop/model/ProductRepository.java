package com.example.demo.shop.model;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	ArrayList<Product> findBySeller(ShopMember seller);
	ArrayList<Product> findByCate(Category cate);
}

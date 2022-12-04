package com.ShoppingCart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingCart.Entity.Item;

public interface ShoppingCartInterface extends JpaRepository<Item,Integer>{
	
	List<Item> findByBrand(String Brand);
	
	List<Item> findByCategory(String category);

}

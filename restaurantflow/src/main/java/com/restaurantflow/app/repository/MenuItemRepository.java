package com.restaurantflow.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantflow.app.entity.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
	
	List<MenuItem> findByAvailableTrue();
	
	List<MenuItem> findByCategory(String category);

}

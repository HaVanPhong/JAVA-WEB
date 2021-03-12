package com.hithaui.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.DAO.Category;

@Repository
public interface CategoryRepositoty extends JpaRepository<Category, Integer>{
	Category findByName(String name);

}

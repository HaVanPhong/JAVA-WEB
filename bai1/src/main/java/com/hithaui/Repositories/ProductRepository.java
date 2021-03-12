package com.hithaui.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.DAO.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

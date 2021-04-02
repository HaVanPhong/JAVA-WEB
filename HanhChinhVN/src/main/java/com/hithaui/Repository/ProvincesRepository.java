package com.hithaui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.DAO.Provinces;

@Repository
public interface ProvincesRepository extends JpaRepository<Provinces, Integer> {
	Provinces findByCode(String code);

}

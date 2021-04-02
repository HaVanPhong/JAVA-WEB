package com.hithaui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.DAO.Districts;

@Repository
public interface DistrictsRepository extends JpaRepository<Districts, Integer> {
	Districts findByCode(String code);

}

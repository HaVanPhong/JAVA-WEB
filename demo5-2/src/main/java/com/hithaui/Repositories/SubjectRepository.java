package com.hithaui.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.DAO.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}

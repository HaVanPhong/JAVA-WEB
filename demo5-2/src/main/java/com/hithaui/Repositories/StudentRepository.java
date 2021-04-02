package com.hithaui.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.DAO.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

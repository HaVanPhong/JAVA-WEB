package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.User;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer>{

}

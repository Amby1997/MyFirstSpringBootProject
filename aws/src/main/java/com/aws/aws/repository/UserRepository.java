package com.aws.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.aws.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

package com.ultrawav.helloaws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultrawav.helloaws.repository.entity.UserManager;

public interface UserManagerRepository extends JpaRepository<UserManager, Long>{

}

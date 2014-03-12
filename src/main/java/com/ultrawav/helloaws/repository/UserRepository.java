package com.ultrawav.helloaws.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ultrawav.helloaws.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	Page<User> findByUserManagerId(Long userManagerId, Pageable pageable);
	
	List<User> findByUserManagerId(Long userManagerId, Sort sort);
}

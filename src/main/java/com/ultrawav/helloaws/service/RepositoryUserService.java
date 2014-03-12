package com.ultrawav.helloaws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultrawav.helloaws.repository.UserRepository;
import com.ultrawav.helloaws.repository.entity.User;
import com.ultrawav.helloaws.repository.specification.UserSpecifications;

@Service
public class RepositoryUserService implements UserSearchService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<User> searchUser(String searchTerm) {
		return userRepository.findAll(UserSpecifications.nameIsLike(searchTerm));
	}
}

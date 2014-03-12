package com.ultrawav.helloaws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ultrawav.helloaws.repository.UserRepository;
import com.ultrawav.helloaws.repository.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findByUserManagerId(Long userManagerId, int startOffset, int numberOfCommentsForPage) {
    	Pageable pageSpecification = new PageRequest(startOffset, numberOfCommentsForPage, new Sort(Sort.Direction.DESC, "regDttm"));
    	Page<User> requestedPage = userRepository.findByUserManagerId(userManagerId, pageSpecification);
    	
    	return requestedPage.getContent();
    }
}

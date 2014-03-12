package com.ultrawav.helloaws.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ultrawav.helloaws.repository.UserRepository;
import com.ultrawav.helloaws.repository.entity.User;
import com.ultrawav.helloaws.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void findByUserManagerId() {
		@SuppressWarnings("unchecked")
		Page<User> requestedPage = mock(Page.class);
		
		when(userRepository.findByUserManagerId(any(Long.class), any(Pageable.class))).thenReturn(requestedPage);
		
		userService.findByUserManagerId(0L, 0, 5);
		
		verify(userRepository, times(1)).findByUserManagerId(any(Long.class), any(Pageable.class));
	}
}

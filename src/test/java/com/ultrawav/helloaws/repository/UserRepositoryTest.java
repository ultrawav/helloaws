package com.ultrawav.helloaws.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ultrawav.helloaws.repository.UserManagerRepository;
import com.ultrawav.helloaws.repository.UserRepository;
import com.ultrawav.helloaws.repository.entity.User;
import com.ultrawav.helloaws.repository.entity.UserManager;
import com.ultrawav.helloaws.util.AbstractRepositoryTest;

public class UserRepositoryTest extends AbstractRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserManagerRepository userManagerRepository;

	private UserManager savedUserManager;
	
	@Before
	public void setup() {
		
		UserManager userManager = new UserManager();
		userManager.setName("manager");
		
		savedUserManager = userManagerRepository.save(userManager);
		
		List<User> users = Lists.newArrayList();
		
		User user = new User();
		user.setName("need4spd4");
		user.setUserManager(userManager);
		
		User user1 = new User();
		user1.setName("need4spd4");
		user1.setUserManager(userManager);
		
		User user2 = new User();
		user2.setName("need4spd4");
		user2.setUserManager(userManager);
		
		User user3 = new User();
		user3.setName("need4spd4");
		user3.setUserManager(userManager);
		
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		userRepository.save(users);
	}
	
	@Test
	public void save() {
		User user = new User();
		user.setName("need4spd5");
		user.setUserManager(savedUserManager);
		
		User savedUser = userRepository.save(user);
		
		assertNotNull(savedUser);
		assertEquals(user, savedUser);
	}
	
	@Test
	public void saveAndFind() {
		User user = new User();
		user.setName("need4spd5");		
		user.setUserManager(savedUserManager);
		
		User savedUser = userRepository.save(user);	
		
		assertTrue(savedUser.getUserManager().getId() == savedUserManager.getId());
	}
	
	
	@Test
	public void findAll() {

		List<User> users = (List<User>)userRepository.findAll();

		assertTrue(users.size() == 4);
	}
}

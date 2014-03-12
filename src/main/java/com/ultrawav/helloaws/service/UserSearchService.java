package com.ultrawav.helloaws.service;

import java.util.List;

import com.ultrawav.helloaws.repository.entity.User;

public interface UserSearchService {

	public List<User> searchUser(String searchTerm);

	public List<User> searchUserAll();

}

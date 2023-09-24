package com.example.demo.service;

import com.example.demo.repository.entity.User;

import java.util.List;

public interface UserService {
	User save(User user);
	void delete(int userId);
	List<User> all();
	User findById(int userId);
	User findByUsername(String username);
}

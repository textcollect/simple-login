package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMySQL implements UserService {
	private final UserRepository userRepository;
	public UserServiceMySQL(@Autowired UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public void delete(int userId) {
		this.userRepository.deleteById(userId);
	}

	@Override
	public List<User> all() {
		List<User> result = new ArrayList<>();
		// for each user object found, add to `result` list
		userRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public User findById(int userId) {
		Optional<User> user = userRepository.findById(userId);
		User result = user.get();
		return result;
	}

	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
}

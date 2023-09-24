package com.example.demo.controller.dto;

import java.time.LocalDateTime;

public class UserDTO {
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	private String role;
	private boolean enabled;
	private LocalDateTime creation;

	public UserDTO(Long id, String name, String username, String email, String password, String role, boolean enabled, LocalDateTime creation) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.creation = creation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}
}

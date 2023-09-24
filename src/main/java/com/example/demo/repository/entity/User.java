package com.example.demo.repository.entity;

import com.example.demo.controller.dto.UserDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private String role;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "creation", columnDefinition = "DATETIME")
	@CreationTimestamp
	private LocalDateTime creation;

	protected User() {}

	public User(UserDTO userDTO) {
		this.id = userDTO.getId();
		this.name = userDTO.getName();
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
		this.email = userDTO.getEmail();
		this.role = userDTO.getRole();
		this.enabled = userDTO.isEnabled();
		this.creation = userDTO.getCreation();
	}

	// Getters & Setters

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

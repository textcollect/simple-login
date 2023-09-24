package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// When a user is authenticated, Spring Security object will create a user session (backend)
		// Spring Security object will also be responsible to manage the session (e.g. timeout, error)
		// Spring Security object will need to end the user session if logout/timeout

		// in sql query, get info from the frontend through the ? symbol
		// sending of info from frontend is through thymeleaf

		// usersByUsernameQuery is sql query method provided by AuthenticationManagerBuilder
		// the query used here gets the row tt matches what the frontend send
		// usersByUsernameQuery will check that the password matches and enabled=1
		// authoritiesByUsernameQuery - retrieve role of this user
		auth.jdbcAuthentication()
				.passwordEncoder(new BCryptPasswordEncoder())
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM Users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, role FROM Users WHERE username=?")
				;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// After authentication is done and user is logged in and session is active
		// need to setup the security policy for the http pages the user is able to access
		// CSRF protection is enabled by default when using EnableWebSecurity's default constructor
		http
				.formLogin((formLogin) -> formLogin
						.usernameParameter("username")
						.passwordParameter("password")
						.loginPage("/login")
						.defaultSuccessUrl("/index", true)
				)
				.logout((logout) -> logout
						.permitAll()
						.logoutSuccessUrl("/index"));

		// Specify which pages to allow users to access w/o logging in
		//and which pages users with "MANAGER" role can access
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/index", "/login", "/js/**", "/css/**").permitAll()
				.requestMatchers("/restricted").hasRole("MANAGER")
				.requestMatchers("/exp").hasRole("USER")
				.requestMatchers("/user").authenticated());

		return http.build();
	}
}

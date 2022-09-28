package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.services.impl.CustomUserDetailServices;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailServices customUserDetailServices;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors()
		.and()
		.authorizeRequests()
		.antMatchers("/token").permitAll()
		.antMatchers("/api/users/adduser","/api/users/getuserbyemail/**","/api/turfs/getturfbyadd/**","/api/users/getuser/**","/api/users/updateuser/**","/api/turfs/getturf/**","/api/bookings/getbookingsbydateandturf/**","/api/bookings/add").permitAll()
		.antMatchers("/api/bookings/getbookingsofuser/**","/api/bookings/delete/**","/api/bookings/get/**").hasRole("USER")
		.antMatchers("/api/bookings/getbookingsofturf/**").hasRole("MANAGER")
		.antMatchers("/api/users/**","/api/turfs/addturf","/api/bookings/getturfbookingsforadmin/**","/getbookingsbydate/**","/api/bookings/getbookingsofuser/**","/api/turfs/getturfbyname/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("kb").password(this.passwordEncoder().encode("kb12")).roles("NORMAL");
		auth.userDetailsService(customUserDetailServices).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}

package org.ikane.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(-20)
public class LoginConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager);
		
		auth.inMemoryAuthentication()
			.withUser("admin").password("1234").roles("ADMIN")
				.and()
				.withUser("user").password("1234").roles("USER")
				.and()
				.withUser("paul").password("emu").roles("USER")
				;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.formLogin().loginPage("/login").permitAll()
		.and()
			.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
		.and()
			.authorizeRequests().anyRequest().authenticated();
		// @formatter:on
	}
	
	

}

package org.nishp.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("demoadmin").password("{noop}adminpassword").authorities("ROLE_USER", "ROLE_ADMIN");
		auth.inMemoryAuthentication().withUser("demouserone").password("{noop}demopasswordone").authorities("ROLE_USER");
		auth.inMemoryAuthentication().withUser("usertwo").password("{noop}dummypasswordtwo").authorities("ROLE_USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().hasAnyRole("USER", "ADMIN").and().formLogin()
				.loginPage("/login").failureUrl("/login.jsp?error=1").loginProcessingUrl("/login").permitAll().and()
				.logout().logoutSuccessUrl("/login");
		
		http.csrf().disable();

	}

}

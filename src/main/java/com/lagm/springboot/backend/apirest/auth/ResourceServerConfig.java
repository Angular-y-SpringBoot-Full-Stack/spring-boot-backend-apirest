package com.lagm.springboot.backend.apirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// RECOMENDACIÓN: Siempre partir desde las reglas más específicas hasta las más genéricas
		
		http.authorizeRequests()
		// Público
		.antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**").permitAll()
		
		// .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
		// Reemplazado por @Secured({"ROLE_ADMIN", "ROLE_USER"})
		
		// .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
		// Reemplazado por @Secured({"ROLE_ADMIN", "ROLE_USER"})
		
		// .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
		// Reemplazado por @Secured("ROLE_ADMIN") o @Secured({"ROLE_ADMIN"})
		
		// Como no se indica el método http, se aplica para cualquier otro que no esté indicado arriba: PUT, DELETE
		.antMatchers("/api/clientes/**").hasRole("ADMIN")
		
		// Todas las rutas que no se especificaron van a ser solo para usuarios autenticados (independiente del rol)
		.anyRequest().authenticated();
	}
}

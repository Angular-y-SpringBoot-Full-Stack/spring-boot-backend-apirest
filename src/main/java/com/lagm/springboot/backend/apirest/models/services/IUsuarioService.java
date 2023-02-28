package com.lagm.springboot.backend.apirest.models.services;

import com.lagm.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
}

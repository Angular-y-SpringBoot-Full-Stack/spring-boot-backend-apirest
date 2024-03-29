package com.lagm.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagm.springboot.backend.apirest.models.dao.IClienteDao;
import com.lagm.springboot.backend.apirest.models.entity.Cliente;

@Service
/* @Service: Con esto decoramos y marcamos esta clase como un componente de Servicio en Spring. Va a quedar almacenado
 * en el contexto o contendedor de Spring, y después de podremos inyectar este beans de Spring. */
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	/* @Autowired: Permite inyectar el clienteDao. A pesar que es una interfaz, Spring por detrás de escena
	 * va a crear una instancia de una implementación concreta utilizando la interfaz y quedará guardada en el contenedor
	 * de Spring (contexto). */
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	/* @Transactional: Permite manejar transacción en el método. Podríamos omitir ya que las
	 *  clases heredadas del CrudRepository ya vienen con transaccionalidad */
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// orElse: Si lo encuentra retorna el objeto cliente, de lo contrario retorna un null
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}

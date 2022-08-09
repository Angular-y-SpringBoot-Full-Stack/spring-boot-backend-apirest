package com.lagm.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lagm.springboot.backend.apirest.models.entity.Cliente;
import com.lagm.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	private static final Integer SIZE = 4;
	@Autowired
	/* @Autowired: Busca una implementación concreta y la inyecta */
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}

	// Listado con paginación
	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable("page") Integer page) {
		Pageable pageable = PageRequest.of(page, SIZE);
		return clienteService.findAll(pageable);
	}
	
	@GetMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (cliente == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	// @ResponseStatus: Por defecto si no se asigna el ResponseStatus, el valor por defecto es HttpStatus.OK = 200
	// @RequestBody: El objeto cliente viene en formato JSON dentro del cuerpo del request
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		/* Intercepto de Spring: Intercepta el objeto cliente y valida cada valor de cada atributo del requestBody que envía angular en un formato json
		 * la cual se traduce a nuestra clase entity Cliente
		 * 1.
		 * @Valid: con esta notación se activa la validación. Si no colocamos esto, a pesar de que tengamos las reglas de validación configuradas en la clase
		 * entity Cliente, no se va a validar.
		 * 
		 * 2.
		 * Inyectar al método create el objeto que contiene todos los mensajes de error con el cual se puede saber si ocurrió algún error en la 
		 * validación: Se pasa el objeto BindingResult
		 * */
		Cliente clienteNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			// Si hay errores de validación, se obtienen los mensajes y se almacenan en un listado
			// Forma clásica de manejar los errores utilizando un for, arraylist. 
			/*List<String> errors = new ArrayList<>();
			for (FieldError error : result.getFieldErrors()) {
				errors.add("El campo '" + error.getField() + "' " + error.getDefaultMessage());
			}*/
			
			// Con java 8 podremos usar el api stream para hacer lo mismo pero con menos código
			List<String> errors = result.getFieldErrors()
					.stream()
					/*.map(err -> {
						return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
						})*/
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			
			
			// BAD_REQUEST: 400, código utilizado cuando falla una validación en una aplicación web con http
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); // CREATED: 201, cuando se creó contenido 
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
		// Es importante el orden. El BindingResult debe estar justo después de Cliente pero antes de @PathVariable
		Cliente clienteActual = clienteService.findById(id);
		Cliente clienteUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}	
		
		if (clienteActual == null) {
			response.put("mensaje", "Error: no se pudo editar. El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clienteActual.setApellido(cliente.getApellido());
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setCreateAt(cliente.getCreateAt());
			
			clienteUpdated = clienteService.save(clienteActual);
			/* save: Funciona tanto como insert como update (merge).
			 * Insert: Si id es null, es decir, si es un nuevo objeto que no está atachado al contexto de persistencia y su id no tiene valor
			 * Update: Si es un gestionado por el contexto de persistencia (y tiene un valor en su id) se hará un merge/update */
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido actualizado con éxito");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); 
	}
	
	@DeleteMapping("clientes/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT) // NO_CONTENT: 204 // Se va a quitar esto ya que ahora vamos a retornar contenido
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			clienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); // HttpStatus.OK ya que se va a retornar un contenido: la respuesta con el mensaje
	}
}

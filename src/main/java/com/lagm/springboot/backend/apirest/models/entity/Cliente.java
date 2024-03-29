package com.lagm.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @NotEmpty // No permite nombres vacíos
	@NotEmpty(message = "no puede estar vacío") // Se puede customizar el mensaje
	@Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12 caracteres") // Tamaño
	@Column(nullable = false) // Nombre no nulo (Por defecto nullable es true)
	private String nombre;
	
	@NotEmpty(message = "no puede estar vacío")
	private String apellido;
	
	@NotEmpty(message = "no puede estar vacío")
	@Email(message = "no es una dirección de correo bien formada")
	// @Column(nullable = false, unique = true) // Email no nulo y único (para que no se pueda duplicar)
	@Column(nullable = false, unique = false) // temporary email not unique
	private String email;

	@NotNull(message = "no puede estar vacío")
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	//@PrePersist // @PrePersist: Evento que se ejecuta antes de que se haga un save/persist en la base de datos
	//public void prePersist() {
	//	createAt = new Date();
	//}
	// Se comenta, para enviar la fecha desde el formulario de Angular

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
}

package com.gg.ADV.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.gg.ADV.enums.Rol;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Temporal(TemporalType.DATE)
	private Date alta;
	@Temporal(TemporalType.DATE)
	private Date modificacion;
	@Temporal(TemporalType.DATE)
	private Date baja;
	
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	protected String username;
	protected String password;

	@Enumerated(EnumType.STRING)
	protected Rol rol;

}

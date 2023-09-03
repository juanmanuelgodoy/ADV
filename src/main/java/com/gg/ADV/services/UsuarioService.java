package com.gg.ADV.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gg.ADV.Excepciones.Excepcion;
import com.gg.ADV.entities.Usuario;
import com.gg.ADV.enums.Rol;
import com.gg.ADV.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	@Transactional
	public void crearUsuario (String id, Date alta, String nombre, String apellido, String email, Integer telefono, String username, String password, String tipoRol) throws Excepcion {
		
		validar(id, alta, nombre, apellido, email, telefono, username, password, tipoRol);
		
		Usuario usuario = new Usuario();
		
		usuario.setAlta(new Date());
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		usuario.setUsername(username);
		usuario.setPassword(password);
		
		Rol rol;
		switch (tipoRol) {
			case "administrador":
				rol = Rol.ADMINISTRADOR;
				break;

			case "cliente":
				rol = Rol.CLIENTE;
				break;
				
			case "usuario":
				rol = Rol.USUARIO;
				break;

			default:
				rol = null;
				break;
		}
		usuario.setRol(rol);
		
		usuarioRepositorio.save(usuario);
			
	}
	
	public List<Usuario> listarUsuarios() {
		
		List<Usuario> usuarios = new ArrayList();
		
		usuarios = usuarioRepositorio.findAll();
		
		return usuarios;
	}
	
	@Transactional
	public void modificarUsuario(String id, Date modificacion, String nombre, String apellido, String email, Integer telefono, String username, String password, String tipoRol) throws Excepcion{
		
		validar(id, modificacion , nombre, apellido, email, telefono, username, password, tipoRol);
		
		Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			
			Usuario usuario = respuesta.get();
			
			usuario.setModificacion(modificacion);
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);
			usuario.setUsername(username);
			usuario.setPassword(password);
			
			
			usuarioRepositorio.save(usuario);

		}
	}
	
	private void validar(String id, Date alta, String nombre, String apellido, String email, Integer telefono, String username, String password, String tipoRol) throws Excepcion{
		
		if(id == null) {
			
			throw new Excepcion("El id del usuario no puede ser nulo");
		}
		
		if(alta == null) {
			
			throw new Excepcion("La fecha de alta no puede ser nula");
		}
		
		if(nombre.isEmpty() || nombre == null) {
			
			throw new Excepcion("El nombre del usuario no puede estar vacío ni ser nulo");
		}
		
		if(apellido.isEmpty() || apellido == null) {
			
			throw new Excepcion("El apellido del usuario no puede estar vacío ni ser nulo");
		}
		
		if(email.isEmpty() || email == null) {
			
			throw new Excepcion("El email del usuario no puede estar vacío ni ser nulo");
		}
		
		if(telefono == null) {
			
			throw new Excepcion("El telefono del usuario no puede ser nulo");
		}
		
		if(username.isEmpty() || username == null) {
			
			throw new Excepcion("El username del usuario no puede estar vacío ni ser nulo");
		}
		
		if(password.isEmpty() || password == null) {
			
			throw new Excepcion("El password del usuario no puede estar vacío ni ser nulo");
		}
		
		if(tipoRol.isEmpty() || tipoRol == null) {
			
			throw new Excepcion("El rol del usuario no puede estar vacío ni ser nulo");
		}
	}
}

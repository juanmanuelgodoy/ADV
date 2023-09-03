package com.gg.ADV.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gg.ADV.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	@Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
	public List<Usuario> BuscarPorNombre(@Param("nombre") String nombre);
	
	@Query("SELECT u FROM Usuario u WHERE u.apellido = :apellido")
	public List<Usuario> BuscarPorapellido(@Param("apellido") String apellido);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	public Usuario BuscarPorEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	public List<Usuario> BuscarPorUsername(@Param("username") String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.usuario.rol = :rol")
	public List<Usuario> BuscarPorRol(@Param("rol") String rol);
	

		
	

}

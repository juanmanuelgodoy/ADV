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
import com.gg.ADV.entities.Ventas;
import com.gg.ADV.enums.Categoria;
import com.gg.ADV.enums.Mes;
import com.gg.ADV.enums.SubCategoria;
import com.gg.ADV.enums.Unidad;
import com.gg.ADV.repositories.UsuarioRepository;
import com.gg.ADV.repositories.VentasRepository;

@Service
public class VentasService {
	
	@Autowired
	private VentasRepository ventaRepositorio;
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Transactional
	public void crearVenta( String id, Date alta, Mes mes, Integer anio, Categoria categoria, SubCategoria subcategoria, Double valor, Unidad unidad, String idUsuario) throws Excepcion {
		
		validar(id, alta, mes, anio, categoria, subcategoria, valor, unidad, idUsuario);
		
		Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
		
		Ventas venta = new Ventas();
		
		venta.setAlta(new Date());
		venta.setMes(mes);
		venta.setAnio(anio);
		venta.setCategoria(categoria);
		venta.setSubcategoria(subcategoria);
		venta.setValor(valor);
		venta.setUnidad(unidad);
		venta.setUsuario(usuario);
		
		ventaRepositorio.save(venta);
		
	}
	
	public List<Ventas> listarVentas() {
		
		List<Ventas> ventas = new ArrayList();
		
		ventas = ventaRepositorio.findAll();
		
		return ventas;
	}

	@Transactional
	public void modificarVenta(String id, Date modificacion, Mes mes, Integer anio, Categoria categoria, SubCategoria subcategoria, Double valor, Unidad unidad, String idUsuario) throws Excepcion {
		
		validar(id, modificacion, mes, anio, categoria, subcategoria, valor, unidad, idUsuario);
		
		Optional<Ventas> respuesta = ventaRepositorio.findById(id);
		Optional<Usuario> respuestaUsuario = usuarioRepositorio.findById(idUsuario);
		
		Usuario usuario = new Usuario();
		
		if(respuestaUsuario.isPresent()) {
			usuario = respuestaUsuario.get();
			
		}
		
		if(respuesta.isPresent()) {
			Ventas venta = respuesta.get();
			
			venta.setModificacion(modificacion);
			venta.setMes(mes);
			venta.setAnio(anio);
			venta.setCategoria(categoria);
			venta.setSubcategoria(subcategoria);
			venta.setValor(valor);
			venta.setUnidad(unidad);
			venta.setUsuario(usuario);
			
			ventaRepositorio.save(venta);
			
		}
				
	}
	
	private void validar(String id, Date alta, Mes mes, Integer anio, Categoria categoria, SubCategoria subcategoria, Double valor, Unidad unidad, String idUsuario) throws Excepcion{
		
		if(id == null ) {
			
			throw new Excepcion("El id de la venta no puede ser nulo");
		}
		
		if(alta == null ) {
			
			throw new Excepcion("La fecha de alta no puede estar vacia ni ser nula");
		}

		if(mes == null ) {
			
			throw new Excepcion("Elmes no puede ser nulo");
		}
		
		if(anio == null ) {
			
			throw new Excepcion("El año no puede ser nulo");
		}
		
		if(categoria == null ) {
			
			throw new Excepcion("La categoría no puede ser nula");
		}
		
		if(subcategoria == null ) {
			
			throw new Excepcion("La subcategoríua no puede ser nula");
		}
		
		if(valor == null ) {
			
			throw new Excepcion("El valor no puede ser nulo");
		}
		
		if(unidad == null ) {
			
			throw new Excepcion("La unidad no puede ser nula");
		}	
		
		if(idUsuario.isEmpty() || idUsuario== null ) {
			
			throw new Excepcion("El id del usuario no puede estar vacío ni ser nulo");
		}
	
	}
}

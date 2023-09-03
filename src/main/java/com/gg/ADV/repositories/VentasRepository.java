package com.gg.ADV.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gg.ADV.entities.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, String> {
	
	@Query("SELECT v FROM Ventas v WHERE v.mes = :mes")
	public List<Ventas> BuscarPorMes(@Param("mes") String mes);
	
	@Query("SELECT v FROM Ventas v WHERE v.anio = :anio")
	public List<Ventas> BuscarPorAnio(@Param("anio") String anio);
	
	@Query("SELECT v FROM Ventas v WHERE v.categoria = :categoria")
	public List<Ventas> BuscarPorCategoria(@Param("categoria") String categoria);
	
	@Query("SELECT v FROM Ventas v WHERE v.subcategoria = :subcategoria")
	public List<Ventas> BuscarPorSubcategoria(@Param("subcategoria") String subcategoria);
	
	@Query("SELECT v FROM Ventas v WHERE v.unidad = :unidad")
	public List<Ventas> BuscarPorUnidad(@Param("unidad") String unidad);


}

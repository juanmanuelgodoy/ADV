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

import com.gg.ADV.enums.Categoria;
import com.gg.ADV.enums.Mes;
import com.gg.ADV.enums.SubCategoria;
import com.gg.ADV.enums.Unidad;

import lombok.Data;

@Entity
@Data
public class Ventas {
	
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
	
	@Enumerated(EnumType.STRING)
	protected Mes mes;
	
	private Integer anio;
	
	@Enumerated(EnumType.STRING)
	protected Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	protected SubCategoria subcategoria;
	
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	protected Unidad unidad;
		
}

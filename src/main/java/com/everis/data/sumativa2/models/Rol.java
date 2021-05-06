package com.everis.data.sumativa2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
    //mucho a mucho
	/* @ManyToMany(fetch=FetchType.LAZY)
  //tabla relacional
   /* @JoinTable(
    		name="personas_roles", //plural
    	joinColumns = @JoinColumn(name= "rol_id"),//singular
    	inverseJoinColumns = @JoinColumn(name= "persona_id")//singular
    		)*/
	@ManyToMany(mappedBy="roles")
    private List<Persona> personas;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
/*
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date deletedAt;*/
    
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	
}
package com.entregagencia.models;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Viagem {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="viagem_name",length  = 50, nullable = false)
	private String nome;
	

	@JsonIgnore
	@ManyToMany(mappedBy="viagem", fetch = FetchType.EAGER)
	private Set<Usuario> usuario = new HashSet<>();
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	} 
	


}
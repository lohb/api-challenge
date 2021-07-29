package com.apichallenge.brqlorena.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "US_ID", updatable = false, nullable = false)
	private long id;
	

	@Column(name = "US_NOME",nullable =false)
	private String nome;
	
	@Column(name = "US_EMAIL",nullable = false)
	private String email;
	
	@Column(name = "US_SEXO")
	private String sexo;
	
	@Column(name = "US_CPF",nullable = false)
	private String cpf;
	
	@Column(name = "US_NACIONALIDADE")
	private String nacionalidade;
	
	@Column(name = "US_ESCOLARIDADE")
	private String escolaridade;
	
	@Column(name = "US_RG")
	private String rg;
	
	@Column(name = "US_ADMINISTRADOR")
	private boolean administrador;
	
	@Column(name = "US_FLAG_ATIVO",nullable = false)
	private int flagAtivo;
	

}

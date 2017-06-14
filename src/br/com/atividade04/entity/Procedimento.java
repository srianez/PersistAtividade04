package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa a tabela PROCEDIMENTO
 */
@Entity
@Table(name = "PROCEDIMENTO")
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 11, insertable = true, updatable = true)
	private java.lang.Integer id;

	@Column(name = "descricao", nullable = false, unique = false, length = 45, insertable = true, updatable = true)
	private java.lang.String descricao;

	@Column(name = "preco", nullable = false, unique = false, insertable = true, updatable = true)
	private java.lang.Double preco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpfpac")
	private Paciente paciente;		
	
	public Procedimento() {
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public java.lang.String getDescricao() {
		return this.descricao;
	}

	public Procedimento setDescricao(java.lang.String descricao) {
		this.descricao = descricao;
		return this;
	}

	public java.lang.Double getPreco() {
		return this.preco;
	}

	public Procedimento setPreco(java.lang.Double preco) {
		this.preco = preco;
		return this;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}


}
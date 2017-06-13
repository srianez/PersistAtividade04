package br.com.atividade04.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Classe que representa a tabela AGENDA
 */
@Entity
@Table(name = "AGENDA", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 11)
	private java.lang.Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private java.util.Date data;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora", nullable = false)
	private java.util.Date hora;

	@Column(name = "descricao", nullable = true, length = 45)
	private java.lang.String descricao;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "agenda")
	private List<Paciente> paciente;

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public Agenda() {

	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public java.util.Date getData() {
		return this.data;
	}

	public Agenda setData(java.util.Date data) {
		this.data = data;
		return this;
	}

	public java.util.Date getHora() {
		return this.hora;
	}

	public Agenda setHora(java.util.Date hora) {
		this.hora = hora;
		return this;
	}

	public java.lang.String getDescricao() {
		return this.descricao;
	}

	public Agenda setDescricao(java.lang.String descricao) {
		this.descricao = descricao;
		return this;
	}

}
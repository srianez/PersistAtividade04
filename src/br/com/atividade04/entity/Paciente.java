package br.com.atividade04.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Classe que representa a tabela PACIENTE
 */
@Entity
@Table(name = "PACIENTE")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cpf", nullable = false, length = 11, insertable = true, updatable = true)
	private java.lang.String cpf;

	@Column(name = "nome", nullable = false, unique = false, length = 45, insertable = true, updatable = true)
	private java.lang.String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "datanasc", nullable = true, unique = false, insertable = true, updatable = true)
	private java.util.Date datanasc;

	@Column(name = "telefone", nullable = true, unique = false, length = 20, insertable = true, updatable = true)
	private java.lang.String telefone;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "agenda_paciente", joinColumns = @JoinColumn(name = "paciente_cpf"), inverseJoinColumns = @JoinColumn(name = "agenda_id"))

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
//	private Set<Procedimento> procedimento = new HashSet<Procedimento>();
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
//	private Set<Matmed> matmed = new HashSet<Matmed>();
	
	private List<Agenda> agenda;

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	public Paciente() {

	}

	public java.lang.String getCpf() {
		return this.cpf;
	}

	public Paciente setCpf(java.lang.String cpf) {
		this.cpf = cpf;
		return this;
	}

	public java.lang.String getNome() {
		return this.nome;
	}

	public Paciente setNome(java.lang.String nome) {
		this.nome = nome;
		return this;
	}

	public java.util.Date getDatanasc() {
		return this.datanasc;
	}

	public Paciente setDatanasc(java.util.Date datanasc) {
		this.datanasc = datanasc;
		return this;
	}

	public java.lang.String getTelefone() {
		return this.telefone;
	}

	public Paciente setTelefone(java.lang.String telefone) {
		this.telefone = telefone;
		return this;
	}

}
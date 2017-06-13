package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que representa a tabela MATMED
 */
@Entity
@Table(name = "MATMED")
public class Matmed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 11, insertable = true, updatable = true)
	private java.lang.Integer id;

	@Column(name = "descricao", nullable = false, unique = false, length = 45, insertable = true, updatable = true)
	private java.lang.String descricao;

	@Column(name = "preco", nullable = false, unique = false, insertable = true, updatable = true)
	private java.lang.Double preco;

	@Column(name = "fabricante", nullable = true, unique = false, length = 45, insertable = true, updatable = true)
	private java.lang.String fabricante;

	@Column(name = "cpfpac", nullable = true, unique = false, insertable = true, updatable = true)
	private java.lang.String paciente;

	public Matmed() {
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public java.lang.String getDescricao() {
		return this.descricao;
	}

	public Matmed setDescricao(java.lang.String descricao) {
		this.descricao = descricao;
		return this;
	}

	public java.lang.Double getPreco() {
		return this.preco;
	}

	public Matmed setPreco(java.lang.Double preco) {
		this.preco = preco;
		return this;
	}

	public java.lang.String getFabricante() {
		return this.fabricante;
	}

	public Matmed setFabricante(java.lang.String fabricante) {
		this.fabricante = fabricante;
		return this;
	}

	public java.lang.String getPaciente() {
		return this.paciente;
	}

	public Matmed setPaciente(java.lang.String paciente) {
		this.paciente = paciente;
		return this;
	}

}
package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "AGENDA", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
//@XmlRootElement
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Agenda object = (Agenda) obj;
		if (id != null ? !id.equals(object.id) : object.id != null)
			return false;
		return true;
	}


	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
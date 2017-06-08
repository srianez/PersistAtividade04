package br.com.atividade04.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTE", schema = "scjperat04")
public class Paciente implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "cpf", nullable = false, length=11)
  private String cpf;
  

  @Column(name = "nome", nullable = false, length=45)
  private String nome;
  
  @Column(name = "datanasc", nullable = true)
  private Date datanasc;
  
  @Column(name = "telefone", nullable = true, length=20)
  private String telefone;

//  public class AgendaPaciente {
//	  @ManyToMany
//	  @JoinTable(name="AGENDA_PACIENTE",
//	  joinColumns=@JoinColumn(name="cpf"),
//	  inverseJoinColumns=@JoinColumn(name="id"))
//	  private Collection<Agenda> agenda;
//	  }
  
  
  public Paciente(){
	  
  }


public String getCpf() {
	return cpf;
}


public void setCpf(String cpf) {
	this.cpf = cpf;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public Date getDatanasc() {
	return datanasc;
}


public void setDatanasc(Date datanasc) {
	this.datanasc = datanasc;
}


public String getTelefone() {
	return telefone;
}


public void setTelefone(String telefone) {
	this.telefone = telefone;
}
  
  
}
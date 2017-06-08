package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PACIENTE")
@XmlRootElement
public class Paciente implements Serializable {


  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "cpf", nullable = false, length=11, insertable=true, updatable=true)
  private java.lang.String cpf;
  
  
  @Column(name = "nome", nullable = false, unique = false, length=45, insertable=true, updatable=true)
  private java.lang.String nome;
  
  
  @Temporal(TemporalType.DATE)
  @Column(name = "datanasc", nullable = true, unique = false, insertable=true, updatable=true)
  private java.util.Date datanasc;
  
  
  @Column(name = "telefone", nullable = true, unique = false, length=20, insertable=true, updatable=true)
  private java.lang.String telefone;
  
  
  public Paciente(){
	  
  }

  
  public java.lang.String getCpf(){
    return this.cpf;
  }
  
  
  public Paciente setCpf(java.lang.String cpf){
    this.cpf = cpf;
    return this;
  }
  
  public java.lang.String getNome(){
    return this.nome;
  }
  
  public Paciente setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }
  
  public java.util.Date getDatanasc(){
    return this.datanasc;
  }
  
  public Paciente setDatanasc(java.util.Date datanasc){
    this.datanasc = datanasc;
    return this;
  }
  
  public java.lang.String getTelefone(){
    return this.telefone;
  }
  
  public Paciente setTelefone(java.lang.String telefone){
    this.telefone = telefone;
    return this;
  }
  

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Paciente object = (Paciente)obj;
    if (cpf != null ? !cpf.equals(object.cpf) : object.cpf != null) return false;
    return true;
  }
  
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((cpf == null) ? 0 : cpf.hashCode());
    return result;
  }
  
}
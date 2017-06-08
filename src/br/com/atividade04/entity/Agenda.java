package br.com.atividade04.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "AGENDA", schema = "scjperat04")

public class Agenda implements Serializable {

 
  private static final long serialVersionUID = 1L;
 

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, length=11)
  private int id;
  

  @Column(name = "data", nullable = false)
  private Date data;
  

  @Column(name = "hora", nullable = false)
  private Date hora;
  
  
  @Column(name = "descricao", nullable = true, unique = false, length=45)
  private String descricao;
  

  public Agenda(){
  }


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Date getData() {
	return data;
}


public void setData(Date data) {
	this.data = data;
}


public Date getHora() {
	return hora;
}


public void setHora(Date hora) {
	this.hora = hora;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}

  
}
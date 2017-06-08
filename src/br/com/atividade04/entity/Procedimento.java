package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDIMENTO", schema = "scjperat04")

public class Procedimento implements Serializable {


  private static final long serialVersionUID = 1L;
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  @Column(name = "id", nullable = false, length=11)
  private int id;
  
  @Column(name = "descricao", nullable = false, length=45)
  private String descricao;
  
  @Column(name = "preco", nullable = false)
  private Double preco;
  
  @ManyToOne
  @JoinColumn(name="cpf_paciente", nullable = false, referencedColumnName = "cpf")
  private Paciente paciente;
  
  public Procedimento(){
	  
  }

  
  public int getId(){
    return this.id;
  }
  
  public Procedimento setId(int id){
    this.id = id;
    return this;
  }
  

  public String getDescricao(){
    return this.descricao;
  }
  
  public Procedimento setDescricao(String descricao){
    this.descricao = descricao;
    return this;
  }
  

  public Double getPreco(){
    return this.preco;
  }
  
  public Procedimento setPreco(Double preco){
    this.preco = preco;
    return this;
  }
  

  public Paciente getPaciente(){
    return this.paciente;
  }
  

  public Procedimento setPaciente(Paciente paciente){
    this.paciente = paciente;
    return this;
  }
  
  
}
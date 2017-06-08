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
@Table(name = "MATMED", schema = "scjperat04")

public class Matmed implements Serializable {

  private static final long serialVersionUID = 1L;
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, length=11)
  private int id;

  @Column(name = "descricao", nullable = false, length=45)
  private String descricao;

 
  @Column(name = "preco")
  private double preco;
  
  @Column(name = "fabricante", nullable = true, unique = false, length=45)
  private String fabricante;
  
  @ManyToOne
  @JoinColumn(name="cpfpac",  referencedColumnName = "cpf")
  private Paciente paciente;
  
  public Matmed(){
	  
  }


  public int getId(){
    return this.id;
  }
  
 
  public Matmed setId(int id){
    this.id = id;
    return this;
  }
  
 
  public String getDescricao(){
    return this.descricao;
  }
  
 
  public Matmed setDescricao(String descricao){
    this.descricao = descricao;
    return this;
  }
  
  public double getPreco(){
    return this.preco;
  }
  

  public Matmed setPreco(double preco){
    this.preco = preco;
    return this;
  }
  

  public String getFabricante(){
    return this.fabricante;
  }
  

  public Matmed setFabricante(String fabricante){
    this.fabricante = fabricante;
    return this;
  }
  

  public Paciente getPaciente(){
    return this.paciente;
  }
  
 
  public Matmed setPaciente(Paciente paciente){
    this.paciente = paciente;
    return this;
  }
 
  
}
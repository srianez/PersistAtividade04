package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@IdClass(AgendaPacientePK.class)
@Table(name = "AGENDAPACIENTE")
//@XmlRootElement
public class AgendaPaciente implements Serializable {


  private static final long serialVersionUID = 1L;
  

  @Id
  @Column(name = "agenda_id", nullable = true, insertable=true, updatable=true)
  private java.lang.Integer agenda;
  

  @Id
  @Column(name = "paciente_cpf", nullable = true, insertable=true, updatable=true)
  private java.lang.String paciente;
  

  public AgendaPaciente(){
	  
  }

  

  public java.lang.Integer getAgenda(){
    return this.agenda;
  }
  

  public AgendaPaciente setAgenda(java.lang.Integer agenda){
    this.agenda = agenda;
    return this;
  }
  

  public java.lang.String getPaciente(){
    return this.paciente;
  }
  

  public AgendaPaciente setPaciente(java.lang.String paciente){
    this.paciente = paciente;
    return this;
  }
  

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    AgendaPaciente object = (AgendaPaciente)obj;
    if (agenda != null ? !agenda.equals(object.agenda) : object.agenda != null) return false;
    if (paciente != null ? !paciente.equals(object.paciente) : object.paciente != null) return false;
    return true;
  }
  

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((agenda == null) ? 0 : agenda.hashCode());
    result = 31 * result + ((paciente == null) ? 0 : paciente.hashCode());
    return result;
  }
  
}
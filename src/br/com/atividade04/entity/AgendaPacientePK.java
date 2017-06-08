package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AgendaPacientePK implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Column(name = "agenda_id", insertable=true, updatable=true)
  private java.lang.Integer agenda;
  
  @Column(name = "paciente_cpf", insertable=true, updatable=true)
  private java.lang.String paciente;
  
  public AgendaPacientePK(){
  }
  

  public java.lang.Integer getAgenda(){
    return this.agenda;
  }
  
  public AgendaPacientePK setAgenda(java.lang.Integer agenda){
    this.agenda = agenda;
    return this;
  }

  public java.lang.String getPaciente(){
    return this.paciente;
  }
  

  public AgendaPacientePK setPaciente(java.lang.String paciente){
    this.paciente = paciente;
    return this;
  }
  

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    AgendaPacientePK object = (AgendaPacientePK)obj;
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

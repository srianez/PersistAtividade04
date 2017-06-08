package br.com.atividade04.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@IdClass(AgendaPacientePK.class)
@Table(name = "AGENDAPACIENTE", schema = "scjperat04")
@XmlRootElement

public class AgendaPaciente implements Serializable {

  private static final long serialVersionUID = 1L;
  

  @Id
  @JoinColumn(name="agenda_id", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  private Agenda agenda;
  
  @Id
  @JoinColumn(name="paciente_cpf", nullable = true, referencedColumnName = "cpf", insertable=true, updatable=true)
  private Paciente paciente;
  
  public AgendaPaciente(){
  }

  
  public Agenda getAgenda(){
    return this.agenda;
  }
  

  public AgendaPaciente setAgenda(Agenda agenda){
    this.agenda = agenda;
    return this;
  }
  
  public Paciente getPaciente(){
    return this.paciente;
  }
  
  public AgendaPaciente setPaciente(Paciente paciente){
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
package br.com.atividade04.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.atividade04.dao.GenericDao;
import br.com.atividade04.entity.Agenda;
import br.com.atividade04.entity.Matmed;
import br.com.atividade04.entity.Paciente;
import br.com.atividade04.entity.Procedimento;
import br.com.atividade04.utils.JpaUtil;

public class Main {

	public static void main(String[] args) {

		System.out.println("============ Carrega inicial das tabelas ============");
		CrudData();

		System.out.println("============ Lista dos Pacientes que possuem procedimentos ============");
		searchPacientesProcedimentos();

		System.out.println("============ Lista dos Materiais utilizados por paciente  ============");
		searchPacientesMateriais();
		


	}

	// Carga inicial da estrutura de BD
	public static void CrudData() {

		Calendar calendar = Calendar.getInstance();

		// GERA UMA AGENDA
		Agenda agenda = new Agenda();
		agenda.setData(calendar.getTime());
		agenda.setDescricao("Agenda X");
		agenda.setHora(calendar.getTime());
		
		// cria a lista de agenda
		List<Agenda> listAgenda = new ArrayList();
		listAgenda.add(agenda);	
		

		// ===== DADOS DO  PACIENTE =====
		Paciente paciente = new Paciente();
		paciente.setCpf("97555557754");
		paciente.setNome("Carlos Pedro");
		paciente.setDatanasc(calendar.getTime());
		paciente.setTelefone("111549997");

		// cria a lista de paciente
		List<Paciente> listaPaciente = new ArrayList();
		listaPaciente.add(paciente);


		// adiciona o paciente 1 na agenda e a agenda no paciente (manytomany bidirecional)
		agenda.setPaciente(listaPaciente);
		paciente.setAgenda(listAgenda);

		// persiste os dados
		GenericDao<Agenda> daoAgenda = new GenericDao<Agenda>(Agenda.class);
		daoAgenda.adicionar(agenda);

		// Gera procedimentos
		Procedimento procedimento = new Procedimento();
		procedimento.setDescricao("Apenas consulta");
		procedimento.setPaciente(paciente);
		procedimento.setPreco(989.99);

		// persiste os dados
		GenericDao<Procedimento> daoProcedimento = new GenericDao<Procedimento>(Procedimento.class);
		daoProcedimento.adicionar(procedimento);

		Procedimento procedimento2 = new Procedimento();
		procedimento2.setDescricao("Ajuste na barriga");
		procedimento2.setPaciente(paciente);
		procedimento2.setPreco(149.99);

		GenericDao<Procedimento> daoProcedimento2 = new GenericDao<Procedimento>(Procedimento.class);
		daoProcedimento2.adicionar(procedimento2);

		Procedimento procedimento3 = new Procedimento();
		procedimento3.setDescricao("Ajuste na lingua");
		procedimento3.setPaciente(paciente);
		procedimento3.setPreco(119.79);

		GenericDao<Procedimento> daoProcedimento3 = new GenericDao<Procedimento>(Procedimento.class);
		daoProcedimento3.adicionar(procedimento3);

		// grava a tabela matmed
		Matmed matmed = new Matmed();
		matmed.setDescricao("Esparadrapo");
		matmed.setFabricante("Esparadrapos do Brasil");
		matmed.setPreco(270.35);
		matmed.setPaciente(paciente);

		GenericDao<Matmed> daoMatmed = new GenericDao<Matmed>(Matmed.class);
		daoMatmed.adicionar(matmed);

		// grava a tabela matmed
		Matmed matmed2 = new Matmed();
		matmed2.setDescricao("Soro");
		matmed2.setFabricante("Soro fisiológico dos bons");
		matmed2.setPreco(999.90);
		matmed2.setPaciente(paciente);

		GenericDao<Matmed> daoMatmed2 = new GenericDao<Matmed>(Matmed.class);
		daoMatmed2.adicionar(matmed2);
		
		System.out.println("Atualizando Material.");
		matmed2.setPreco(199.90);
		daoMatmed.atualizar(matmed);
		
		System.out.println("Removendo Procedimento.");
		daoProcedimento3.remover(procedimento3);
	
	}

	public static void searchPacientesProcedimentos() {
		List<Procedimento> query = JpaUtil.getEntityManager()
				.createQuery("SELECT p FROM Procedimento p, Paciente c WHERE c.cpf = p.paciente.cpf",
						Procedimento.class)
				.getResultList();

		for (Procedimento procedimento : query) {
			System.out.println("Paciente: " + procedimento.getPaciente().getNome() + " Procedimento realizado: " +
					 procedimento.getDescricao() + " no valor de: " + procedimento.getPreco() );
		}
	}

	public static void searchPacientesMateriais() {
		List<Matmed> query = JpaUtil.getEntityManager()
				.createQuery("SELECT m FROM Matmed m, Paciente c WHERE c.cpf = m.paciente.cpf", Matmed.class)
				.getResultList();

		for (Matmed matmed : query) {
			System.out.println("Paciente: " + matmed.getPaciente().getNome() + " utilizou o material " + matmed.getDescricao()
					+ " no valor de " + matmed.getPreco() );
		}
	}

}

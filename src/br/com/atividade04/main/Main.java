package br.com.atividade04.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.atividade04.dao.GenericDao;
import br.com.atividade04.entity.Agenda;
import br.com.atividade04.entity.Matmed;
import br.com.atividade04.entity.Paciente;
import br.com.atividade04.entity.Procedimento;
import br.com.atividade04.utils.JpaUtil;



public class Main {

	public static void main(String[] args) {
        
		System.out.println("============ Carregando a tabelas ============");
		//prepareData();
		
		System.out.println("============ Lista dos Pacientes que possuem procedimentos ============");
		searchPacientesProcedimentos();
		
		System.out.println("============ Lista dos Materiais utilizados por paciente  ============");
		//searchPacientesMateriais();

	}

	//Carga inicial da estrutura de BD
	public static void prepareData() {

		Calendar calendar = Calendar.getInstance();
 
		
		// GERA UMA AGENDA
		Agenda agenda = new Agenda();
		agenda.setData(calendar.getTime());
		agenda.setDescricao("Agenda X");
		agenda.setHora(calendar.getTime());
		

// ===== DADOS DO PRIMEIRO PACIENTE =====
		Paciente paciente = new Paciente();
		paciente.setCpf("97555557754");
		paciente.setNome("Carlos Pedro");
		paciente.setDatanasc(calendar.getTime());
		paciente.setTelefone("111549997");

		// cria a lista de paciente
		List<Paciente> listaPaciente = new ArrayList();
		listaPaciente.add(paciente);

		// cria a lista de agenda
		List<Agenda> listAgenda = new ArrayList();
		listAgenda.add(agenda);

		// adiciona o paciente 1 na agenda e a agenda no paciente (manytomany bidirecional)
		agenda.setPaciente(listaPaciente);
		paciente.setAgenda(listAgenda);

		// persiste os dados
		GenericDao<Agenda> daoAgenda = new GenericDao<Agenda>(Agenda.class);
		daoAgenda.adicionar(agenda);

		// Gera  procedimento 1 para paciente 1
		Procedimento procedimento = new Procedimento();
		procedimento.setDescricao("Ajuste na testa");
//		procedimento.setCpfpac(paciente.getCpf());
		procedimento.setPaciente(paciente);
		procedimento.setPreco(1989.99);

		// persiste os dados
		GenericDao<Procedimento> daoProcedimento = new GenericDao<Procedimento>(Procedimento.class);
		daoProcedimento.adicionar(procedimento);

		// Gera  procedimento 2 para paciente 1
		Procedimento procedimento2 = new Procedimento();
		procedimento2.setDescricao("Ajuste na barriga");
//		procedimento2.setCpfpac(paciente.getCpf());
		procedimento2.setPaciente(paciente);
		procedimento2.setPreco(19.99);

		// persiste os dados
		GenericDao<Procedimento> daoProcedimento2 = new GenericDao<Procedimento>(Procedimento.class);
		daoProcedimento2.adicionar(procedimento2);

		// Gera  procedimento 3 para paciente 1
		Procedimento procedimento3 = new Procedimento();
		procedimento3.setDescricao("Ajuste na lingua");
//		procedimento3.setCpfpac(paciente.getCpf());
		procedimento3.setPaciente(paciente);
		procedimento3.setPreco(11.79);

		// persiste os dados
		GenericDao<Procedimento> daoProcedimento3 = new GenericDao<Procedimento>(Procedimento.class);
		daoProcedimento3.adicionar(procedimento3);

		
//		//DADOS DO SEGUNDO PACIENTE
//		
//		// Gera paciente 2 e vincula na agenda 1
//		Paciente paciente2 = new Paciente();
//		paciente2.setCpf("97555557754");
//		paciente2.setNome("Carlos Pedro");
//		paciente2.setDatanasc(calendar.getTime());
//		paciente2.setTelefone("111549997");
//
//		// cria a lista de paciente
//		List<Paciente> listaPaciente2 = new ArrayList();
//		listaPaciente2.add(paciente2);
//
//		// cria a lista de agenda
//		List<Agenda> listAgenda2 = new ArrayList();
//		listAgenda2.add(agenda);
//
//		// adiciona o paciente na agenda e a agenda no paciente (manytomany bidirecional)
//		agenda.setPaciente(listaPaciente2);
//		paciente.setAgenda(listAgenda2);
//
//		// persiste os dados
//		GenericDao<Agenda> daoAgenda2 = new GenericDao<Agenda>(Agenda.class);
//		daoAgenda2.adicionar(agenda);		
//		
//
//		
//		// Gera paciente 2 e vincula na agenda 1
//		Paciente paciente3 = new Paciente();
//		paciente3.setCpf("97555557754");
//		paciente3.setNome("Carlos Pedro");
//		paciente3.setDatanasc(calendar.getTime());
//		paciente3.setTelefone("111549997");
//
//		// cria a lista de paciente
//		List<Paciente> listaPaciente3 = new ArrayList();
//		listaPaciente3.add(paciente3);
//
//		// cria a lista de agenda
//		List<Agenda> listAgenda3 = new ArrayList();
//		listAgenda3.add(agenda);
//
//		// adiciona o paciente na agenda e a agenda no paciente (manytomany bidirecional)
//		agenda.setPaciente(listaPaciente2);
//		paciente.setAgenda(listAgenda2);
//
//		// persiste os dados
//		GenericDao<Agenda> daoAgenda3 = new GenericDao<Agenda>(Agenda.class);
//		daoAgenda3.adicionar(agenda);		
//		
//		
//
//
//		// grava a tabela matmed
//		Matmed matmed = new Matmed();
//		matmed.setDescricao("Barbante grande");
//		matmed.setFabricante("Barbantarilhos");
//		matmed.setPreco(200.35);
//		matmed.setPaciente(paciente.getCpf());
//
//		// persiste os dados
//		GenericDao<Matmed> daoMatmed = new GenericDao<Matmed>(Matmed.class);
//		daoMatmed.adicionar(matmed);

	}

    public static void searchPacientesProcedimentos() {
        List<Procedimento> query = JpaUtil.getEntityManager().createQuery("SELECT p FROM Procedimento p, Paciente c WHERE c.cpf = p.paciente.cpf", Procedimento.class).getResultList();

        for (Procedimento procedimento : query) {
        	System.out.println("Paciente: " + procedimento.getPaciente().getNome() + "\t | \t" + procedimento.getDescricao() + "\t | \t" + procedimento.getPreco()+"\r");
        }
    }
   
    public static void searchPacientesMateriais() {
        List<Matmed> query = JpaUtil.getEntityManager().createQuery("SELECT m FROM Matmed m, Paciente c WHERE c.cpf = m.paciente.cpf", Matmed.class).getResultList();

        for (Matmed matmed : query) {
        	System.out.println("Paciente: " + matmed.getPaciente().getNome() + "\t | \t" + matmed.getDescricao() + "\t | \t" + matmed.getPreco()+"\r");
        }
    }

}

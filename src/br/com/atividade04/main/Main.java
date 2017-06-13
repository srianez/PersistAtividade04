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


public class Main {

	public static void main(String[] args) {
        
		Calendar calendar = Calendar.getInstance();
		
		//grava uma agenda
		Agenda agenda = new Agenda();
        agenda.setData(calendar.getTime());
        agenda.setDescricao("Agenda 1");
        agenda.setHora(calendar.getTime());
        
		
		//grava um paciente
		Paciente paciente = new Paciente();
        paciente.setCpf("34306071839");
        paciente.setNome("Z� do caix�o");
		paciente.setDatanasc(calendar.getTime());
		paciente.setTelefone("897544157");
		
		List<Paciente> listaPaciente = new ArrayList();
		
		listaPaciente.add(paciente);
		
		agenda.setPaciente(listaPaciente);

		GenericDao<Agenda> daoAgenda = new GenericDao<Agenda>(Agenda.class);
		daoAgenda.adicionar(agenda);	
		
		
		
		
		
		
		//grava a tabela procedimento 
		
//		Procedimento procedimento = new Procedimento();
//		procedimento.setDescricao("Ajuste no ded�o");
//		procedimento.setPaciente(paciente.getCpf());
//		procedimento.setPreco(1999.33);
//				
//		GenericDao<Procedimento> daoProcedimento = new GenericDao<Procedimento>(Procedimento.class);
//
//		daoProcedimento.adicionar(procedimento);

		
		
//		//grava a tabela matmed 
//		Matmed matmed = new Matmed();
//        matmed.setDescricao("Barbante de ponto");
//        matmed.setFabricante("Loja azul");
//        matmed.setPreco(200.35);
//        matmed.setPaciente(paciente.getCpf());
//				
//		GenericDao<Matmed> daoMatmed = new GenericDao<Matmed>(Matmed.class);
//
//		daoMatmed.adicionar(matmed);	
		

//		// Recuperar clientes
//		List<Clientes> lisclientes = daoCli.listar();
//		for (Clientes cliente : lisclientes) {
//			System.out.println("Result dao.listar = " + cliente.getNome() + " - " + cliente.getEmail());
//		}


	}

}

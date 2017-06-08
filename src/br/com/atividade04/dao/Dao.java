package br.com.atividade04.dao;

import java.util.List;

public interface Dao<T> {
	
	void adicionar(T entidade);
	List<T> listar();

	void atualizar(T entidade);

	void remover(T entidade);

	T buscar(int id);
}
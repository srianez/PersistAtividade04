package br.com.atividade04.dao;

public interface Dao<T> {
	
	void adicionar(T entidade);

	void atualizar(T entidade);

	void remover(T entidade);

}
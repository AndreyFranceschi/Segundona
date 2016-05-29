package br.com.sfcc.dao;

import java.util.List;

public interface IDao<T> {

	void salvar(T t);
	
	T buscar(Long id);
	
	List<T> consultar();
	
	void excluir(Long id);
	
}

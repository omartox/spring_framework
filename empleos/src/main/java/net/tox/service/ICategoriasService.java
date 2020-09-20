package net.tox.service;

import java.util.List;

import net.tox.model.Categoria;

public interface ICategoriasService {
	
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);
	
	void eliminar(Integer idCategoria);
}

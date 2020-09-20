package net.tox.service;

import java.util.List;

import net.tox.model.Vacante;

public interface IVacantesService {
	
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
	List<Vacante> buscarDestacadas();
	void eliminar(int idVacante);
}

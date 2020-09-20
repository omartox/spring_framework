package net.tox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tox.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

	//Query Metodos
	//crear metodos para que spring sepa que consulta queremos hacer
	
	List<Vacante> findByEstatus(String estatus);
	
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
	List<Vacante> findBySalarioBetween(double s1, double s2);
	
	List<Vacante> findByEstatusIn(String [] estatus);
}

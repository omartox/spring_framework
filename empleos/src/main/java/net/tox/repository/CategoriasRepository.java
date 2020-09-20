package net.tox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.tox.model.Categoria;



public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
}

package net.tox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tox.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}

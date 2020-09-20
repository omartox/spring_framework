package net.tox.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tox.model.Usuario;
import net.tox.repository.UsuariosRepository;
import net.tox.service.IUsuariosService;

@Service
public class UsuariosServiceJPA implements IUsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> lista = usuariosRepo.findAll();
		return lista;
	}

}

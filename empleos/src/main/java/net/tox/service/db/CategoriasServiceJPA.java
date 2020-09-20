package net.tox.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.tox.model.Categoria;
import net.tox.repository.CategoriasRepository;
import net.tox.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJPA implements ICategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	
	@Override
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		List<Categoria> lista = categoriasRepo.findAll();
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> opctional = categoriasRepo.findById(idCategoria);
		if(opctional.isPresent())
			return opctional.get();			
		else
			return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
	}
	
	

}

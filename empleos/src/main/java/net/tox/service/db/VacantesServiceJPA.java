package net.tox.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.tox.model.Vacante;
import net.tox.repository.VacantesRepository;
import net.tox.service.IVacantesService;

@Service
@Primary
public class VacantesServiceJPA implements IVacantesService {
	
	@Autowired
	private VacantesRepository vacantesRepo;
 
	@Override
	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = vacantesRepo.findById(idVacante);
		if(optional.isPresent()) 
			return optional.get();
		else
			return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		vacantesRepo.save(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public void eliminar(int idVacante) {
		vacantesRepo.deleteById(idVacante);
	}

}

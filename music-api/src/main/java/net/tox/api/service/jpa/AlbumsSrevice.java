package net.tox.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tox.api.entity.Album;
import net.tox.api.repository.AlbumsRepository;
import net.tox.api.service.IAlbumsService;

@Service
public class AlbumsSrevice implements IAlbumsService {
	
	@Autowired
	private AlbumsRepository repoAlbums;

	@Override
	public List<Album> buscarTodos() {
		return repoAlbums.findAll();
	}

	@Override
	public void guardar(Album album) {
		repoAlbums.save(album);
	}

	@Override
	public void eliminar(int idAlbum) {
		repoAlbums.deleteById(idAlbum);
	}

}

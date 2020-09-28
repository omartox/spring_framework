package net.tox.api.service;

import java.util.List;

import net.tox.api.entity.Album;

public interface IAlbumsService {
	List<Album> buscarTodos();
	void guardar(Album album);
	void eliminar(int idAlbum);
	
}

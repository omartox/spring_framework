package net.tox.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tox.api.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {

}

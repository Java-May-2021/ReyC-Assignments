package com.reymer.playlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reymer.playlist.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findSongsByArtistContaining(String artist);
	List<Song> findTop10SongsByOrderByRatingDesc();
}
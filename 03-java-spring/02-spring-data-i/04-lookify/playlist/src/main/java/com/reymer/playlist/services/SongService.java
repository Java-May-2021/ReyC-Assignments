package com.reymer.playlist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.playlist.models.Song;
import com.reymer.playlist.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;

	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	public List<Song> getAllSongs() {
		return this.songRepo.findAll();
	}
	public Song getSingleSong(Long id) {
		return this.songRepo.findById(id).orElse(null);
	}
	public List<Song> getSongByArtist(String artist) {
		return this.songRepo.findSongsByArtistContaining(artist);
	}
	public List<Song> getTopTenSongs() {
		return this.songRepo.findTop10SongsByOrderByRatingDesc();
	}
	public Song createSong(Song song) {
		return this.songRepo.save(song);
	}
	public Song updateSong(Song song) {
		return this.songRepo.save(song);
	}
	public void deleteSong(Long id) {
		this.songRepo.deleteById(id);
	}
}

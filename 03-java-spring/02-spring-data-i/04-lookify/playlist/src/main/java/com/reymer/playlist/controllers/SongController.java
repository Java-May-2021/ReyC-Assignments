package com.reymer.playlist.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reymer.playlist.models.Song;
import com.reymer.playlist.services.SongService;

@Controller
public class SongController {
	@Autowired
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = this.songService.getAllSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	@GetMapping("/songs/new")
	public String newSong(Model model, @ModelAttribute("song") Song song) {
		ArrayList<Integer> ratingList = new ArrayList<Integer>();
		ratingList.add(1);
		ratingList.add(2);
		ratingList.add(3);
		ratingList.add(4);
		ratingList.add(5);
		ratingList.add(6);
		ratingList.add(7);
		ratingList.add(8);
		ratingList.add(9);
		ratingList.add(10);
		model.addAttribute("ratingList", ratingList);
		return "newSong.jsp";
	}
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		} else {
			this.songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = this.songService.getSingleSong(id);
		model.addAttribute("song", song);
		return "showSong.jsp";
	}
	@GetMapping("/songs/{id}/edit")
	public String editSong(@PathVariable("id") Long id, Model model) {
		ArrayList<Integer> ratingList = new ArrayList<Integer>();
		ratingList.add(1);
		ratingList.add(2);
		ratingList.add(3);
		ratingList.add(4);
		ratingList.add(5);
		ratingList.add(6);
		ratingList.add(7);
		ratingList.add(8);
		ratingList.add(9);
		ratingList.add(10);
		Song song = this.songService.getSingleSong(id);
		model.addAttribute("song", song);
		model.addAttribute("ratingList", ratingList);
		return "editSong.jsp";
	}
	@PostMapping("/songs/{id}/edit")
	public String updateSong(@Valid @ModelAttribute("song") Song song, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editSong.jsp";
		} else {
			this.songService.updateSong(song);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		this.songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@GetMapping("/search/topTen")
	public String showTopTen(Model model) {
		List<Song> topSongs = this.songService.getTopTenSongs();
		model.addAttribute("topSongs", topSongs);
		return "showTopSongs.jsp";
	}
	@GetMapping("/songs/search")
	public String showArtistSong(@RequestParam("artist") String artist, Model model) {
		List<Song> artistSongs = this.songService.getSongByArtist(artist);
		model.addAttribute("artistSongs", artistSongs);
		model.addAttribute("artist", artist);
		return "artistSongs.jsp";
	}
}

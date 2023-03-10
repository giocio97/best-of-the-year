package com.corsojava.bestoftheyear.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.corsojava.bestoftheyear.classes.Movie;
import com.corsojava.bestoftheyear.classes.Song;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping()

	public String home(Model model) {
		model.addAttribute("mynome", "Giovanni");
		return "index";
	}

	@GetMapping("/movies")
	public String showMovies(Model m) {
		List<Movie> mov = getBestMovies();
		m.addAttribute("movie", mov);

		return "movies";
	}

	@GetMapping("/songs")
	public String showSongs(Model s) {
		List<Song> songs = getBestSongs();
		s.addAttribute("song", songs);

		return "songs";

	}

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();

		Movie movie1 = new Movie(1, "Harry Potter");
		movies.add(movie1);
		Movie movie2 = new Movie(2, "Il signore degli anelli");
		movies.add(movie2);
		Movie movie3 = new Movie(3, "Una notte da leoni");
		movies.add(movie3);

		return movies;

	}

	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();

		Song song1 = new Song(1, "nel blu dipinto di blu");
		songs.add(song1);
		Song song2 = new Song(2, "rose rosse");
		songs.add(song2);
		Song song3 = new Song(3, "brividi");
		songs.add(song3);

		return songs;

	}

	@GetMapping("/movies/{id}")
	public String dettaglioMovie(Model model, @PathVariable("id") String id) {
		List<Movie> movies = getBestMovies();
		model.addAttribute("movie", movies.get(Integer.parseInt(id) - 1));
		return "movie";

	}

	@GetMapping("/songs/{id}")
	public String dettaglioSong(Model model, @PathVariable("id") String id) {
		List<Song> songs = getBestSongs();
		model.addAttribute("song", songs.get(Integer.parseInt(id) - 1));
		return "song";

	}

}

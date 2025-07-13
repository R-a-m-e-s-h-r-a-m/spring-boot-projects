package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

public class MovieService implements MovieRepository {

	private static HashMap<Integer, Movie> movieList = new HashMap<>();
	private int nextMovieId = 6;

	public MovieService() {
		movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
		movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
		movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
		movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
		movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
	}

	@Override
	public ArrayList<Movie> getMovies() {
		ArrayList<Movie> movies = new ArrayList<>(movieList.values());
		return movies;
	}

	@Override
	public Movie getMovieById(int movieId) {
		Movie movie = movieList.get(movieId);
		if (movie == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return movie;
	}

	@Override
	public Movie addMovie(Movie movie) {
		movie.setMovieId(nextMovieId++);
		if (movie != null)
			movieList.put(movie.getMovieId(), movie);
		return movie;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		Movie existingMovie = movieList.get(movieId);
		if (existingMovie == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		else {
			movie.setMovieId(movieId);
			movieList.put(movieId, movie);
		}

		return movie;
	}

	@Override
	public void deleteMovieById(int movieId) {
		Movie movie = movieList.get(movieId);
		if (movie == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		else {
			movieList.remove(movieId);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}

	}

}

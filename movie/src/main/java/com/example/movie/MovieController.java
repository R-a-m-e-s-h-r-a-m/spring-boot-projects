package com.example.movie;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MovieController {
  MovieService movieService = new MovieService();

  @GetMapping("/movies")
  public ArrayList<Movie> getMovies() {
    return movieService.getMovies();
  }

  @PostMapping("/movies")
  public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
  }

  @GetMapping("/movies/{movieId}")
  public Movie getMovieById(@PathVariable("movieId") int movieId) {
    return movieService.getMovieById(movieId);
  }

  @PutMapping("/movies/{movieId}")
  public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
    return movieService.updateMovie(movieId, movie);
  }

  @DeleteMapping("/movies/{movieId}")
  public void deleteMovieById(@PathVariable("movieId") int movieId) {
    movieService.deleteMovieById(movieId);

  }

}
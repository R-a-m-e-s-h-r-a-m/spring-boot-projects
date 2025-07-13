package com.example.movie;

import java.util.*;

public interface MovieRepository {
    ArrayList<Movie> getMovies();

    Movie getMovieById(int movieId);

    Movie addMovie(Movie movie);

    Movie updateMovie(int movieId, Movie movie);

    void deleteMovieById(int movieId);

}
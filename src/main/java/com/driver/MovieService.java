package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovie(String name){
        return movieRepository.getMovieByName(name);
    }

    public Director getDirector(String name){
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesFromDirector(String director){
        return movieRepository.getMoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}

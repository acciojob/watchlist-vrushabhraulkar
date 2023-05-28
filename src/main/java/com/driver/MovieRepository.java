package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> db=new HashMap<>();
    HashMap<String, Director>db2=new HashMap<>();
    HashMap<String, List<String>>db3=new HashMap<>();


    public String addMovie(Movie movie){
        String name=movie.getName();
        db.put(name, movie);
        return "Movie added successfully....";
    }

    public String addDirector(Director director){
        String name=director.getName();
        db2.put(name, director);
        return "Director added successfully....";
    }

    public void addMovieDirectorPair(String movie, String director){
        if(db.containsKey(movie) && db2.containsKey(director)){
            db.put(movie, db.get(movie));
            db2.put(director, db2.get(director));
            List<String> currentMovies=new ArrayList<>();
            if(db3.containsKey(director))
                currentMovies=db3.get(director);
            currentMovies.add(movie);
            db3.put(director, currentMovies);
        }
    }
    public Movie getMovieByName(String name){
        return db.get(name);
    }

    public Director getDirectorByName(String name){
        return db2.get(name);
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(db.keySet());
    }

    public void deleteDirector(String director){
        List<String>movies=new ArrayList<>();
        if(db3.containsKey(director)){
            movies=db3.get(director);
            for(String movie:movies){
                if(db.containsKey(movie)){
                    db.remove(movie);
                }
            }
            db3.remove(director);
        }
        if(db2.containsKey(director)){
            db2.remove(director);
        }
    }

    public List<String> getMoviesFromDirector(String director){
        List<String> movieList=new ArrayList<>();
        if(db3.containsKey(director))
            movieList=db3.get(director);
        return movieList;
    }

    public void deleteAllDirectors(){
        HashSet<String> moviesSet=new HashSet<>();

        for(String director:db3.keySet()){
            for(String movie:db3.get(director)){
                moviesSet.add(movie);
            }
        }
        for(String movie:moviesSet){
            if(db.containsKey(movie)){
                db.remove(movie);
            }
        }
    }

}

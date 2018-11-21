/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author MyPC
 */
public class Movie {
    int id;
    String name;
    String image;
    int duration;
    String linkTrailer;
    String director ;
    String cast ;
    String genre ;
    String language ;
    Date release ;
    int show_home;
    String context;

    public Movie() {
    }

    public Movie(int id, String name, String image, int duration, String linkTrailer, String director, String cast, String genre, String language, Date release, int show_home, String context) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.duration = duration;
        this.linkTrailer = linkTrailer;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.language = language;
        this.release = release;
        this.show_home = show_home;
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getDuration() {
        return duration;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public Date getRelease() {
        return release;
    }

    public int getShow_home() {
        return show_home;
    }

    public String getContext() {
        return context;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public void setShow_home(int show_home) {
        this.show_home = show_home;
    }

    public void setContext(String context) {
        this.context = context;
    }
    
}

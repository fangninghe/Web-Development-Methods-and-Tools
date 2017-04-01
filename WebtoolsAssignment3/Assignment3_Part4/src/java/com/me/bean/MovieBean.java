/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.bean;

/**
 *
 * @author Alex
 */
public class MovieBean {
    String name;
    String actor;
    String actress;
    String genre;
    int year;

    public MovieBean() {
    }
    
    

    public String getName() {
        return name;
    }

    public String getActor() {
        return actor;
    }

    public String getActress() {
        return actress;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}

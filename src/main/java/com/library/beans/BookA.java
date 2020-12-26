/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author saiv0001
 */
@Entity
@Table(name="BookA")
public class BookA{
    
    @Id
    @GeneratedValue
    private int book_id;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    private String book_name;
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genredetails;

    @Override
    public String toString() {
        return "BookA{" + "book_id=" + book_id + ", book_name=" + book_name + ", genredetails=" + genredetails + ", authordetails=" + authordetails + ", count=" + count + '}';
    }
    @ManyToOne
    @JoinColumn(name="author_id")
    private Authors authordetails;
    
    private int count;
    
    
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Genre getGenredetails() {
        return genredetails;
    }

    public void setGenredetails(Genre genredetails) {
        this.genredetails = genredetails;
    }

    public Authors getAuthordetails() {
        return authordetails;
    }

    public void setAuthordetails(Authors authordetails) {
        this.authordetails = authordetails;
    }
    
    

   
}

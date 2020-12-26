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
@Table(name="Authors")
public class Authors {

    @Override
    public String toString() {
        return "Authors{" + "author_id=" + author_id + ", author_name=" + author_name + '}';
    }
    
    @Id
    @GeneratedValue
    private int author_id;
    
    

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getAuthor_id() {
        return author_id;
    }
    private String author_name;
    
}

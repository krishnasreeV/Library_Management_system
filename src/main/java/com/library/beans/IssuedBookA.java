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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author saiv0001
 */
@Entity
@Table(name="IssuedBookA")
public class IssuedBookA {
    
    
    @Id
    @GeneratedValue
    private int ib_id;

  
    
    public String issuedbookstring(){
         return      "ID:"+ib_id+" ISSUER:"+ issuerdetails.getName()+" and BOOK:"+bookdetails.getBook_name();
    }
    
    @ManyToOne
    @JoinColumn(name="book_id")
    private BookA bookdetails;
    
    @ManyToOne
    @JoinColumn(name="issuer_id")
    private Issuers issuerdetails;

    private char returnedyn;
    
    public BookA getBookdetails() {
        return bookdetails;
    }

    public void setBookdetails(BookA bookdetails) {
        this.bookdetails = bookdetails;
    }

    public Issuers getIssuerdetails() {
        return issuerdetails;
    }

    public void setIssuerdetails(Issuers issuerdetails) {
        this.issuerdetails = issuerdetails;
    }

    public char getReturnedyn() {
        return returnedyn;
    }

    public void setReturnedyn(char returnedyn) {
        this.returnedyn = returnedyn;
    }
    

    public int getIb_id() {
        return ib_id;
    }

    public void setIb_id(int ib_id) {
        this.ib_id = ib_id;
    }

   
    
}

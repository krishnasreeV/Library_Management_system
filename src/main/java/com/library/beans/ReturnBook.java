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
@Table(name="ReturnBook")
public class ReturnBook {
    
    @Id
    @GeneratedValue
    private int rb_id;
    
    @ManyToOne
    @JoinColumn(name="ib_id")
    private IssuedBookA issuedbookdetails;

    public int getRb_id() {
        return rb_id;
    }

    public void setRb_id(int rb_id) {
        this.rb_id = rb_id;
    }

    public IssuedBookA getIssuedbookdetails() {
        return issuedbookdetails;
    }

    public void setIssuedbookdetails(IssuedBookA issuedbookdetails) {
        this.issuedbookdetails = issuedbookdetails;
    }
    
}

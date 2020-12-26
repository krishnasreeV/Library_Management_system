/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author saiv0001
 */
@Entity
@Table(name="Issuers")
public class Issuers {
    @Id
    @GeneratedValue
    private int issuer_id;

    public int getIssuer_id() {
        return issuer_id;
    }

    public void setIssuer_id(int issuer_id) {
        this.issuer_id = issuer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_issue() {
        return max_issue;
    }

    public void setMax_issue(int max_issue) {
        this.max_issue = max_issue;
    }
    private String name;
    private int max_issue;
    
}

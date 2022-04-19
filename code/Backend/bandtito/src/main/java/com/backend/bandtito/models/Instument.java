package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "instuments", schema = "public")
public class Instument {
    
    @Id
    @Column(name = "name", nullable = true)
    private String name;

    public Instument() {
        
    }

    public Instument(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
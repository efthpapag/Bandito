package com.backend.bandtito.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "concerts", schema = "public")
public class Concert {

    @Id
    @Column(name = "date", nullable = true)
    private LocalDate date;

    public Concert() {
        
    }

    public Concert(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate(){
        return this.date;
    }
    
}

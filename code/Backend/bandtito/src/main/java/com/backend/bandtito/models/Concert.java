package com.backend.bandtito.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "concerts", schema = "public")
public class Concert {

    //Columns

    @Id
    @Column(name = "date", nullable = true)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job", nullable = false)
    private Job job;

    //Constructors

    public Concert() {
        
    }

    public Concert(LocalDate date, Job job) {
        this.date = date;
        this.job = job;
    }

    //Getters

    public LocalDate getDate(){
        return this.date;
    }
    
}

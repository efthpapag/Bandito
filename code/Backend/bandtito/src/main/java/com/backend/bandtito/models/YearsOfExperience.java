package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yearsOfExperience", schema = "public")
public class YearsOfExperience {

    @Id
    @Column(name = "numberOfYears", nullable = true)
    private int numberOfYears;

    public YearsOfExperience() {
        
    }

    public YearsOfExperience(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public int getNumberOfYears(){
        return this.numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }
    
}

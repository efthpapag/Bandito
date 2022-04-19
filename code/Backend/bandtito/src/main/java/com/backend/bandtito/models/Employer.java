package com.backend.bandtito.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employers", schema = "public")
public class Employer extends User{
    
}

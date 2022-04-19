package com.backend.bandtito.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bandAdmins", schema = "public")
public class BandAdmin extends Musician{
    
}

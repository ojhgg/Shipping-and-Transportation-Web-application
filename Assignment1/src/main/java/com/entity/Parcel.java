package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parcel")
@Getter
@Setter
public class Parcel {

    
    @Column
    private String boxtype;
    
    @Column
    private String description;
    
    @Column
    private String dimension;
    
    @Id
    private String parcelsid;
    
    @Column
    private String weight;
    
    @Column
    private String quantity;
    
    // Getters and Setters
}
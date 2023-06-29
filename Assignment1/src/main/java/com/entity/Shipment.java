package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipment")
@Getter
@Setter
public class Shipment {
    @Column
    public String returnto;
    @Column
    public String shipfrom;
    @Column
    public String shipto;
    @Column
    public String servicetype;
    @Id
    public String parcels;
    @Column
    public String updateat;
    // Getters and Setters
}


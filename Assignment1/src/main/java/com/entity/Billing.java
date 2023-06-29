package com.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
@Getter
@Setter
public class Billing {
    @Id
    private int id;

    @Column
    private String accountnumber;

    @Column
    private String type;

    @Column
    private String paidby;

    // Getters and Setters
}

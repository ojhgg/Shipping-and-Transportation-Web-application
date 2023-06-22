// Courier.java

package com.entity;

/**
 * ApifoxModel
 */
@lombok.Data
public class Courier {
    private CourierBoxType[] courierBoxTypes;
    private CourierServiceType[] courierServiceTypes;
    private String name;
    private Operations operations;
    private String[] paperSizes;
    private String shipFrom;
    private String shipTo;
    private String slug;
}



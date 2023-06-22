// Customs.java

package com.entity;

/**
 * ApifoxModel
 */
@lombok.Data
public class Customs {
    private Eei eei;
    private Address importerAddress;
    private Passport passport;
    private String purpose;
    private String termsOfTrade;
}


// ShipperAccount.java

package com.entity;


/**
 * ApifoxModel
 */
@lombok.Data
public class ShipperAccount {
    private Address address;
    private String createdAt;
    private String description;
    private String id;
    private String settings;
    /**
     * 承运商编号
     */
    private String slug;
    private String timezone;
    private String type;
    private String updatedAt;
    private String password;
}




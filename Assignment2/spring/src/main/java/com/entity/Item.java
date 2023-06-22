package com.entity;

import java.util.Map;

// Item.java
@lombok.Data
public class Item {
    private String description;
    private String descriptioncn;
    private String hsCode;
    private String itemid;
    private String originCountry;
    private Map<String, Object> price;
    private Long quantity;
    private String sku;
    private Map<String, Object> weight;
}

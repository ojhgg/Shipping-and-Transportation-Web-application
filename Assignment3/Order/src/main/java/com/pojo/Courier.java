package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("courier")
public class Courier {

  private String boxname;
  private String servicename;
  private String name;
  private String shipfrom;
  private String shipto;
  private String slug;

  public String getBoxName() {
    return boxname;
  }

  public void setBoxName(String boxname) {
    this.boxname = boxname;
  }


  public String getServiceName() {
    return servicename;
  }

  public void setServiceName(String servicename) {
    this.servicename = servicename;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getShipFrom() {
    return shipfrom;
  }

  public void setShipFrom(String shipfrom) {
    this.shipfrom = shipfrom;
  }


  public String getShipto() {
    return shipto;
  }

  public void setShipTo(String shipto) {
    this.shipto = shipto;
  }


  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

}

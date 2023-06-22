package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("courierservicetype")
public class Courierservicetype {

  private String isdomestic;
  private String servicename;
  private String servicetype;
  private String shipfromcountry;


  public String getIsDomestic() {
    return isdomestic;
  }

  public void setIsDomestic(String isdomestic) {
    this.isdomestic = isdomestic;
  }


  public String getServiceName() {
    return servicename;
  }

  public void setServiceName(String servicename) {
    this.servicename = servicename;
  }


  public String getServiceType() {
    return servicetype;
  }

  public void setServiceType(String servicetype) {
    this.servicetype = servicetype;
  }


  public String getShipFromCountry() {
    return shipfromcountry;
  }

  public void setShipFromCountry(String shipfromcountry) {
    this.shipfromcountry = shipfromcountry;
  }

}

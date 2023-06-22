package com.pojo;

import lombok.Getter;
import lombok.Setter;


public class Shipment {
  private String returnto;
  private String shipfrom;
  private String shipto;
  private String servicetype;
  private String parcels;
  private String updateat;
  public String getReturnTo() {
    return returnto;
  }

  public void setReturnTo(String returnto) {
    this.returnto = returnto;
  }


  public String getShipfrom() {
    return shipfrom;
  }

  public void setShipfrom(String shipfrom) {
    this.shipfrom = shipfrom;
  }


  public String getShipto() {
    return shipto;
  }

  public void setShipto(String shipto) {
    this.shipto = shipto;
  }


  public String getServicetype() {
    return servicetype;
  }

  public void setServicetype(String servicetype) {
    this.servicetype = servicetype;
  }


  public String getParcels() {
    return parcels;
  }

  public void setParcels(String parcels) {
    this.parcels = parcels;
  }

  public String getUpdateat() {
    return updateat;
  }

  public void setUpdateat(String updateat) {
    this.updateat = updateat;
  }
}

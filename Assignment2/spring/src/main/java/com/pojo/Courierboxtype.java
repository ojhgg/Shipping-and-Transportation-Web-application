package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("courierboxtype")
public class Courierboxtype {

  private String boxname;
  private String boxtype;


  public String getBoxName() {
    return boxname;
  }

  public void setBoxName(String boxname) {
    this.boxname = boxname;
  }


  public String getBoxType() {
    return boxtype;
  }

  public void setBoxType(String boxtype) {
    this.boxtype = boxtype;
  }

}

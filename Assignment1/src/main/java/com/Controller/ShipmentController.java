package com.Controller;

import com.entity.Billing;
import com.entity.Shipment;
import com.service.ShipmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;


@Controller
@RequestMapping("/shipping")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;

    @PostMapping("/track")
    public ModelAndView trackShipment(@RequestParam("item") String item, ModelAndView model)
    {
        // 根据 item ID 进行航运查询，获取航运详情
        Shipment shipment = shipmentService.getShipmentDetails(item);
        if (shipment != null) {
            model.addObject("shipment", shipment);
            model.setViewName("shipment");
            System.out.println(shipment);
        }
        else {
            model.setViewName("shipment");//没有设置view名，默认转发到controller的ur导致报错
            // 将航运详情添加到模型中
            // 返回视图名
            return model;
        }
        return model;
    }
    @PostMapping("/create")
    public ModelAndView createShipment(@RequestParam("returnto")String  returnto, @RequestParam("shipfrom")String  shipfrom, @RequestParam("shipto")String  shipto, @RequestParam("servicetype")String  servicetype, @RequestParam("parcels")String  parcels, @RequestParam("id")String  id, @RequestParam("accountnumber")String  accountnumber, @RequestParam("paidby")String  paidby,ModelAndView model)
    {
        // 根据 item ID 进行航运查询，获取航运详情
        String updatedat = LocalDate.now().toString();
        Shipment shipment = new Shipment();
        shipment.setUpdateat(updatedat);
        shipment.setReturnto(returnto);
        shipment.setParcels(parcels);
        shipment.setShipfrom(shipfrom);
        shipment.setServicetype(servicetype);
        shipment.setShipto(shipto);
        Billing billing = new Billing();
        billing.setId(Integer.parseInt(id));
        billing.setType(servicetype);
        billing.setPaidby(id);
        billing.setAccountnumber(accountnumber);
        shipmentService.createShipmentOrder(returnto,shipfrom,shipto,servicetype,parcels,updatedat);
        int result=shipmentService.createBilling(id,accountnumber,servicetype,paidby);
        if(result==1)
        {
            model.addObject("error","用户名不存在");
        }
        model.addObject("shipment", shipment);
        model.setViewName("shipment");

        return model;
    }

    @RequestMapping("/main")
    public String mainPage() {
        return "main";
    }

}
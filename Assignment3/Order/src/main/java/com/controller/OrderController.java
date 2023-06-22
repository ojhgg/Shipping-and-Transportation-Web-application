package com.controller;
import com.service.OrderService;
import com.vo.R;
import com.vo.param.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * FileName:  OrderController
 * Date: 2023/04/01
 */

@RestController
@RequestMapping("/user")
//@CrossOrigin
@AllArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService userService;

    @PostMapping("tracking")
    public R  tracking(@RequestBody Param itemid,@RequestAttribute("id") String id){
        return userService.tracking(itemid);
   }

    @PostMapping("createOrder")
    public R createOrder(@RequestBody CreateOrderParam createOrderParam,@RequestAttribute("id")String id)
    {
       return  userService.createOrder(createOrderParam,id);
    }
    @PostMapping("billing")
   public R billing (@RequestBody Param2 accountnumber,@RequestAttribute("id") String id)
    {
        return  userService.Billing(accountnumber);
    }
}

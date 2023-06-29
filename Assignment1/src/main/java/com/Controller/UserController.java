package com.Controller;
import com.entity.User;
import com.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
   Userservice userservice;

    @PostMapping(value="/login")
    @ResponseBody
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
     User foundUser = userservice.findByUsernameAndPassword(username, password);
        ModelAndView model = new ModelAndView();
       if (foundUser != null) {
            // 将航运详情添加到模型中
            model.addObject("username",username);
            model.setViewName("main");
            return model;
       } else {
           model.addObject("errorMessage", "failed"); // 设置错误消息
           model.setViewName("redirect:../index.jsp?errorMessage=faile");
           return model;
      }
    }
    @PostMapping(value="/registry")
    @ResponseBody
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email)
    {
        User foundUser = userservice.findByUsernameAndPassword(username, password);
        ModelAndView model = new ModelAndView();
        if (foundUser != null) {
            userservice.registerUser(username,password,email);
            // 将航运详情添加到模型中
            model.addObject("username",username);
            model.setViewName("main");
            return model;
        } else {
            model.addObject("errorMessage", "failed"); // 设置错误消息
            model.setViewName("redirect:../registry.jsp?errorMessage=faile");
            return model;
        }
    }

    @RequestMapping("/shipment")
    public String shipmentPage() {
        return "shipment";
    }

    @RequestMapping("/order")
    public String orderPage() {
        return "order";
    }
    @RequestMapping("/main")
    public String mainPage() {
        return "main";
    }
}
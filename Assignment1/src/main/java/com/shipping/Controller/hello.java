package com.shipping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class hello {
    @RequestMapping("/Getdate")

    public ModelAndView Getdata(){
        Date date=new Date();//服务器时间
        ModelAndView mv = new ModelAndView();
        mv.addObject("date" , date);
        mv.setViewName("index");
        return mv;
    }
}

package com.carto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/hello", method = {RequestMethod.POST})
    @ResponseBody
    public String hello() {
        return "hello world";
    }
}

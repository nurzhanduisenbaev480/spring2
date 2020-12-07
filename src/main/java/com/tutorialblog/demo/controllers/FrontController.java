package com.tutorialblog.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FrontController {

    @GetMapping("/")
    public String frontPage(Map<String, Object> model){
        model.put("title", "Главная страница");
        return "index";
    }

}

package com.lyx.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HtmlController {

    @RequestMapping("/admin_index")
    public String admin_index(){
        return "admin_index.html";
    }


    @RequestMapping("/")
    public String index(){
        return "login.html";
    }

    @RequestMapping("/user_index")
    public String user_index(){
        return "index.html";
    }

    @RequestMapping("/try")
    public String test(){
        return "try2.html";
    }


}

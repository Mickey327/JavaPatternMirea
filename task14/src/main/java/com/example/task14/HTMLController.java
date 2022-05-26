package com.example.task14;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HTMLController {
    @GetMapping(value = "/home")
    public String hello(){
        return "home.html";
    }
}

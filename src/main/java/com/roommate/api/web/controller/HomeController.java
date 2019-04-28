package com.roommate.api.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Response;

@RestController("/")
public class HomeController {

    @GetMapping
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("welcome");
        return modelAndView;
    }
}

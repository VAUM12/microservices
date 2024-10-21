package com.easybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    /**
     * Return a friendly greeting
     * @return a hello message
     */
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}

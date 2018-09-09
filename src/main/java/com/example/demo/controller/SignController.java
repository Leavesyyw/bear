package com.example.demo.controller;

import com.example.demo.service.SignService;
import com.example.demo.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {
    @Autowired
    SignService signService;

    @PostMapping(value = "/signup")
    public Result signup(String username, String password) {
        return signService.signup(username, password);
    }

    @PostMapping(value = "/signin")
    public Result signin(String username, String password) {
        return signService.signin(username, password);
    }
}
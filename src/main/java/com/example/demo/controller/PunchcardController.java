package com.example.demo.controller;

import com.example.demo.repository.InformationRepository;
import com.example.demo.repository.PunchCardRepository;
import com.example.demo.service.PunchCardService;
import com.example.demo.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class PunchcardController {
    @Autowired
    PunchCardService punchCardService;

    @PostMapping(value = "/punchcard/search")
    public Result search(String username){
        return punchCardService.search(username);
    }

    @PostMapping(value = "/punchcard/do")
    public Result punchcard(String username){
        return punchCardService.punchcard(username);

    }
}

package com.cai.ggs2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hi")
    public String hi(){
        return "hi good";
    }
}

package com.cj.ggs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {


    @GetMapping(value="hi")
    public String hi(){
        return "get-hi";
    }


    @RequestMapping(value="hi", method = RequestMethod.POST)
    public String hi2(String param1){
        return "post-hi-" + param1;
    }

}

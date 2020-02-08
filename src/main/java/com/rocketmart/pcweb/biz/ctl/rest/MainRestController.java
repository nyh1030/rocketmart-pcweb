package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.context.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class MainRestController {

    @Autowired
    private SessionContext context;

    @GetMapping("/test")
    public Map<String, Object> test(Product product){

        context.username = "남";

        return new HashMap<>();
    }


}

package com.rocketmart.pcweb.biz.ctl.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/rest")
@RestController
public class MainRestCtl {

    @GetMapping("/test")
    public String test(){
        return "testtttt";
    }
}

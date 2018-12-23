package com.way.controller;

import com.way.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Way Liang
 * @Date: 12/19/2018 17:54
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam(value = "name",defaultValue = "way (ribbon+rest)") String name){
        return helloService.hiService(name);
    }
}

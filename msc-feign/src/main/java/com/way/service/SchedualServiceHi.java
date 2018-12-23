package com.way.service;

import com.way.hystrix.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
   hystrix
   只需要在FeignClient的SchedualServiceHi接口的注解中加上fallback的指定类就行了：
    */
@FeignClient(value = "msc-eureka-client",fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {
    /*
    定义一个feign接口，
    通过@ FeignClient（“服务名”），
    来指定调用哪个服务。
    比如在代码中调用了service-hi服务的“/hi”接口
     */


    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

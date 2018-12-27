package com.way;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@RestController
@EnableDiscoveryClient
public class MscConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscConfigServerApplication.class, args);
    }

    @GetMapping(value = "/hi")
    public String hi(){
        return "hi";
    }
}


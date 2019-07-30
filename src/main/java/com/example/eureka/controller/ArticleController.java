package com.example.eureka.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: ll
 * @create: 2019-07-30 16:28
 */
@RestController
public class ArticleController {

    @Autowired
    private RestTemplate restTemplate;

    /*@Autowired
    private EurekaClient eurekaClient;*/

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://127.0.0.1:8081/user/hello", String.class);
    }

    @GetMapping("/article/callHello2")
    public String callHolle2() {
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }

    /*@GetMapping("/article/infos1")
    public Object serviceUrl1() {
        return eurekaClient.getInstancesByVipAddress("eureka-client-user-serivce", false);
    }*/

    @GetMapping("/article/infos2")
    public Object serviceUrl2(){
        return discoveryClient.getInstances("eureka-client-user-service");
    }
}
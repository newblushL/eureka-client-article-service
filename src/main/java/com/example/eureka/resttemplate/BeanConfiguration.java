package com.example.eureka.resttemplate;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: RestTemplate配置
 * @author: ll
 * @create: 2019-07-30 16:27
 */
@Configuration
public class BeanConfiguration {

    @Bean
    //自动构造LoadBalancerClient接口的实现类并注册到Spring容器中
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
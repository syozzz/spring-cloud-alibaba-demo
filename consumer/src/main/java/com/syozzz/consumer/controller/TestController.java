package com.syozzz.consumer.controller;

import com.syozzz.consumer.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderClient client;

    @GetMapping("/consume")
    public String consumer() {
        return restTemplate.getForObject("http://alibaba-provider/hello?name=restTemplate", String.class);
    }

    @GetMapping("/consumeByFeign")
    public String consumeByFeign() {
        return client.hello("feign");
    }

}

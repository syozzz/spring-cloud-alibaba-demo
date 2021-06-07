package com.syozzz.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("alibaba-provider")
public interface ProviderClient {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

}

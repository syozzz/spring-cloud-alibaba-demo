package com.syozzz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Slf4j
    @RestController
    @RefreshScope //@RefreshScope，主要用来让这个类下的配置内容支持动态刷新
    static class TestController {

        @Value("${msg.info}")
        private String title;

        @GetMapping("/hello")
        public String hello() {
            return title;
        }

    }

}

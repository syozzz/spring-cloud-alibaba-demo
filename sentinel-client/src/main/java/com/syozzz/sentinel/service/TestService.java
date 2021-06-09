package com.syozzz.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    @SentinelResource(value = "doSomeThing", blockHandler = "exceptionHandler") //定义资源点 然后就可以对此资源点进行限流控制
    public void doSomeThing(String s) {
        log.info(s);
    }

    @SentinelResource(value = "doSomeThing2", fallback = "fallbackHandler")
    public void doSomeThing2(String str) {
        log.info(str);
        throw new RuntimeException("发生异常");
    }

    public void exceptionHandler(String str, BlockException ex) {
        log.error( "blockHandler：" + str, ex);
    }

    public void fallbackHandler(String str) {
        log.error("fallbackHandler：" + str);
    }

}

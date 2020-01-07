package com.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lijiawen
 * @date 2019/1/18 下午5:26
 */
@Component
@RequestMapping(value = "/test")
public class TestController {

    @PostMapping(value = "/get", consumes = {"application/json"})
    public String test(){

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();


        return "ok";
    }

}

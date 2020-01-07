package com.example.consumer;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiawen
 * @date 2019/3/17 下午2:06
 */
public class FutureTest {

    public static void main(String[] args) {
        RateLimiter rateLimiter= RateLimiter.create(10);
        rateLimiter.acquire();
    }

}

package com.example.mutithread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yingru.ljw
 * @date 2020-04-06 17:24
 */
public class MockQueueTest {

    static MockQueue mockQueue = new MockQueue(2);

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.put("1");
        linkedBlockingQueue.take();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mockQueue.put("1");
                    mockQueue.put("2");
                    mockQueue.put("3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Object res1 = mockQueue.get();
                    Object res2 = mockQueue.get();
                    Object res3 = mockQueue.get();

                    System.out.println(res1);
                    System.out.println(res2);
                    System.out.println(res3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();


    }

}

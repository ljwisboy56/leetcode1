package com.example.mutithread;

import java.util.concurrent.*;

/**
 * @author yingru.ljw
 * @date 2020-04-06 17:47
 */
public class TestAnyQueue {

    public static void main(String[] args) throws InterruptedException {
//        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
//
//        concurrentLinkedQueue.add("1");
//        concurrentLinkedQueue.add("2");
//
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.poll());
//
        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService3 = Executors.newFixedThreadPool(10);
//        ScheduledExecutorService executorService4 = Executors.newScheduledThreadPool(10);


        //使用非公平策略
//        SynchronousQueue synchronousQueue= new SynchronousQueue();
        //使用公平策略
        SynchronousQueue synchronousQueue= new SynchronousQueue(true);
        new Thread(()-> {
            try {
                synchronousQueue.put("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //休眠一下，让异步线程完成
        Thread.sleep(1000);
        new Thread(()-> {
            try {
                synchronousQueue.put("B");
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
        //休眠一下，让异步线程完成
        Thread.sleep(1000);
        new Thread(()-> {
            try {
                Object take = synchronousQueue.take();
                System.out.println(take);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
        //休眠一下，让异步线程完成
        Thread.sleep(1000);
        //不管如何输出，都是 0
        System.out.println(synchronousQueue.size());





    }


}

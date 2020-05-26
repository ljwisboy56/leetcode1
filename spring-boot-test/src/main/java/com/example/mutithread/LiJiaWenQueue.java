package com.example.mutithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LiJiaWenQueue {

    private final int size;
    private final ReentrantLock reentrantLock;
    private final Condition notEmpty;
    private final Condition notFull;
    private final Object[] objects;
    private int count = 0;
    private int takeIndex;
    private int putIndex;

    public LiJiaWenQueue(int size){
        this.size = size;
        reentrantLock = new ReentrantLock();
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        objects = new Object[size];
    }

    public void put(Object obj) throws InterruptedException {
        try {
            reentrantLock.lock();
            while (count == objects.length){
                notFull.await();
            }
            this.doPutQueue(obj);
        }finally {
            reentrantLock.unlock();
        }
    }

    private void doPutQueue(Object obj) {
        objects[putIndex] = obj;
        putIndex++;
        count++;
        if(count >= size){
            putIndex = 0;
        }
        notEmpty.signal();
    }

    public Object get() throws InterruptedException {
        try {
            reentrantLock.lock();
            while (count == 0){
                notEmpty.await();
            }
            return this.doGetQueue();
        }finally {
            reentrantLock.unlock();
        }
    }

    private Object doGetQueue() {
        Object target = objects[takeIndex];
        takeIndex++;
        count--;
        if(takeIndex >= size){
            takeIndex = 0;
        }
        notFull.signal();
        return target;
    }

}

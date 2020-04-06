package com.example.mutithread;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yingru.ljw
 * @date 2020-04-06 16:46
 */
public class MockQueue {

    private int size;

    Object[] objects;

    Condition notFull;

    Condition notEmpty;

    ReentrantLock reentrantLock;

    int putIndex = 0;

    int takeIndex = 0;

    int count = 0;

    public MockQueue(int size){
        this.size = size;
        objects = new Object[size];
        this.reentrantLock = new ReentrantLock();
        notEmpty = reentrantLock.newCondition();
        notFull = reentrantLock.newCondition();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(size);
        try {
            arrayBlockingQueue.put("a");
            arrayBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void put(Object obj) throws InterruptedException {
        if(Objects.isNull(obj)){
            throw new NullPointerException();
        }
        reentrantLock.lock();
        try {
            while (count == objects.length){
                notFull.await();
            }
            addQueue(obj);
        }finally {
          reentrantLock.unlock();
        }

    }

    private void addQueue(Object obj) {
        objects[putIndex] = obj;
        ++putIndex;
        if(putIndex >= size){
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
    }

    public Object get() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            return dequeue();
        }finally {
            reentrantLock.unlock();
        }
    }

    private Object dequeue() {
        Object target = objects[takeIndex];
        objects[takeIndex] = null;
        takeIndex++;
        if(takeIndex == objects.length){
            takeIndex = 0;
        }
        count--;
        notFull.signal();
        return target;
    }

}

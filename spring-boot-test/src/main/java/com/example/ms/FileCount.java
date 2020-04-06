package com.example.ms;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yingru.ljw
 * @date 2020-04-06 23:02
 */
public class FileCount {

    static ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

    static List<Future<HashMap<String, Integer>>> futures = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        File file = new File("D://");
        //首先读出第一层的所有文件
        File[] files = file.listFiles();
        if(files == null || files.length == 0){
            return;
        }
        int threadSize = files.length / 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(file);
            if(i % threadSize == 0){
                Future<HashMap<String, Integer>> future = executorService.submit(new Worker(list,countDownLatch));
                futures.add(future);
            }
        }

        //阻塞
        countDownLatch.await();

        for(Future<HashMap<String,Integer>> mapFuture : futures){
            HashMap<String, Integer> map  = mapFuture.get();
            //汇总
            concurrentHashMap.putAll(map);
        }

    }

    public static List<String> readFile(File file,List<String> list){
        if(file == null){
            return list;
        }else {
            File[] files = file.listFiles();
            if(files == null || files.length == 0){
                return list;
            }
            for(File f: files){
                if(f.isFile()){
                    doRead(f,list);
                }
                if(f.isDirectory()){
                    readFile(f,list);
                }
            }
            return list;
        }

    }

    private static void doRead(File file,List<String> list) {
        //文件读取成字符串
    }

    private static class Worker implements Callable<HashMap<String,Integer>> {

        private HashMap<String, Integer> map = new HashMap<>();

        private List<File> list;

        private CountDownLatch countDownLatch;

        public Worker(List<File> list, CountDownLatch countDownLatch){
            this.list = list;
            this.countDownLatch = countDownLatch;
        }

        private HashMap<String, Integer> doWorkFile(List<File> list) {
            List<String> strList = new ArrayList<>();
            for(File file : list){
                strList.addAll(readFile(file,new ArrayList<>()));
            }

            map.put("s1",1);
            countDownLatch.countDown();
            return map;
        }

        @Override
        public HashMap<String, Integer> call() {
            return doWorkFile(list);
        }
    }

}

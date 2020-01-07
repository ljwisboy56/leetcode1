package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lijiawen
 * @date 2019/3/16 下午8:43
 */
public class Antfinancial {

//    先有一车牌拍卖系统，参与竞拍
//    的人每个人需要拍出一个价格，但
//    是竞拍人不能连续出价，必须有人出
//    价以后自己才能出价，否则无效。并且每次竞
//    拍价格区间在1-200元以内，请写一
//    段代码，模拟多人竞拍1000次以后，谁
//    获得了基础价格是4000元的车牌。

    //购买者的指针
    static Buyer curBuyer = null;

    //购买者的人数
    static int buyers = 10000;

    //我们需要的价格
    static int finalPrice = 4000;

    //竞价者数组
    static List<Buyer> list;

    static int sum = 0;

    static int num = 0;

    static ReentrantLock reentrantLock = new ReentrantLock();

    static ExecutorService executorService = null;


    static {
        //初始化一个数组
        list = new ArrayList<>();
        //并且模拟10000个购买者
        for (int i = 0; i < buyers; i++) {
            //生成购买者对象
            Buyer buyer = new Buyer(getRandomString(5));
            buyer.setExecutorService(executorService);
            //放入竞价数组
            list.add(buyer);
        }
    }

    //购买者和价格之间的映射记录
    private static HashMap<Integer, String> hashMap = new HashMap<>();

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            executorService.submit(list.get(i));
        }

        System.out.println("当前的出价综合,sum="+sum);


    }


    static class Buyer implements Runnable {

        private ExecutorService executorService;

        private String name;

        private int value;

        public Buyer(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }

        @Override
        public void run() {

            while (num < 1000){

                reentrantLock.lock();

                randomInt(200);
                //存储价格和购买者的映射
                hashMap.put(sum, curBuyer.getName());

                reentrantLock.unlock();
            }

            //拿到4000的人是谁
            if (hashMap.get(finalPrice) != null) {
                System.out.println("拿到4000元的人的名字="+curBuyer.getName());
            } else {
                System.out.println("没有4000元这个价格");
            }



        }

        private void setExecutorService(ExecutorService executorService){
            this.executorService = executorService;
        }

        //随机生成
        private void randomInt(int rr) {

                Antfinancial.sum += 1 + (int) (Math.random() * rr);

                this.value = sum;

                num++;

                if(sum == 4000){
                    executorService.shutdownNow();

                }

        }
    }



    //随机生产名字
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}

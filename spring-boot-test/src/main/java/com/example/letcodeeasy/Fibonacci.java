package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-24 15:57
 */
public class Fibonacci {


    /**
     * 和斐波那契是一模一样的；
     * 关键的区别就是 ，初始值 1，2这两个数列项的初始值设定对就好了；
     * 我们来理解下 斐波那契数列的应用：
     * 求达成一件事有多少种方法和途径，那么我们必须知道初始条件2个；在已知步长内去达成
     * @param target
     * @return
     */
    public int JumpFloor(int target) {

        if(target < 0){
            return -1;
        }

        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }

        int one = 1;
        int two = 2;
        int res = 0;



        //1 2 3 5
        for(int i = 3; i <= target;i++){
            res = one+two;
            one = two;
            two = res;
        }

        return res;

    }




}

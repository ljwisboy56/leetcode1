package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-26 00:50
 */
public class 第134题加油站 {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        //条件1
        int sum = 0;
        for(int tmp : cost){
            sum += tmp;
        }

        int cs = 0;
        for(int tmp : gas){
            cs += tmp;
        }

        if(cs > sum){
            return -1;
        }

        //条件2
        int station =0;
        int cur = 0;
        for(int i = 0; i < gas.length;i++){
            cur += gas[i] - cost[i];
            if(cur < 0){
                station = i +1;
                cur = 0;
            }
        }

        return station;

    }

}

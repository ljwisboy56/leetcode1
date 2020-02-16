package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-15 17:29
 */
public class 加油站 {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int taotalTank = 0;
        int curTank = 0;

        int station = 0;

        for (int i =0;i < gas.length;i++){
            taotalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];

            if(curTank <0){
                station = i+1;
                curTank = 0;
            }
        }
        return taotalTank >=0?station:-1;

    }

}

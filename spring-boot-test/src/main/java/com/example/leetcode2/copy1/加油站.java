package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-21 20:06
 */
public class 加油站 {

    /**
     * 写下思路:比较简单：2个条件满足即可：
     * 1，遍历一遍油量一定大于消耗量
     * 2,当满足条件1的时候，我们找到能走到结尾的那个点，不管他是第几个一定能满足，
     * 因为总体的量是正的，那么这一段距离能走到结尾，
     * 说明 i 到 end 的油量-消耗量的值一定大于前面所有的站点相加的值（即时他们是负数的）
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;

        for (int i = 0; i < gas.length;i++){
            sum += gas[i] - cost[i];
        }

        if(sum < 0){
            return -1;
        }

        int curTank = 0;
        int station = 0;

        for (int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];
            if(curTank <0){
                station = i +1;
                curTank = 0;
            }
        }

        return station;

    }

}

package com.example.jzof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yingru.ljw
 * @date 2019-12-08 15:12
 */
public class FindGreatestSumOfSubArray {

    int sum = 0;


    public static void main(String[] args) {
        int[] a = new int[]{1,-2,3,10,-4,7,2,-5};

        int res = new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray2(a);

        System.out.println(res);

    }

    public int FindGreatestSumOfSubArray(int[] array) {
        List<Integer> list = new ArrayList();
        for(int i = 0;i < array.length;i++){
            int sum = 0 ;
            for( int j = i;j < array.length;j++){
                sum+=array[j];
                list.add(sum);
            }
        }


        Collections.sort(list);

        return list.get(list.size()-1);
    }


    /**
     * 首先规划处状态转移方程：
     * v(i)=max(v(i-1)+a[i],,a(i));
     * v(0)=0;
     * v(1)=max(v(9)+a[1],v(0));
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array){

        int[] dp = new int[array.length];

        dp[0] = array[0];

        int max = 0;

        for(int i=1;i < array.length;i++){
            dp[i]=Math.max(dp[i-1]+array[i],array[i]);
            max =Math.max(dp[i],max);
        }
        return max;

    }




}

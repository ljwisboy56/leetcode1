package com.example.jzof;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-15 22:50
 */
public class FindContinuousSequence2 {

    public static void main(String[] args) {

        new FindContinuousSequence2().FindContinuousSequence(100);

    }

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int[] array = new int[sum-1];
        //先初始化出一个数组
        for(int i =1;i < sum;i++){
            array[i-1] = i;
        }

        //把问题变成我们常见的回溯或者动态规划
        doFindCount(0,array,sum);
        System.out.println(listAll);
        return listAll;

    }

    ArrayList<Integer> list = new ArrayList<>();


    private void doFindCount(int t,int[] array, int sum) {

        if(finalS(list,sum)){
            listAll.add(new ArrayList<>(list));
        }else {
            list = new ArrayList<>();
            for(int j = t;j < array.length;j++){
                list.add(array[j]);
                if(bound(array[j],sum) && constraint(list,sum)){
                    continue;
                }else {
                    doFindCount(t+1,array,sum);
                }
            }
        }

    }

    private boolean constraint(ArrayList<Integer> list,int sum) {
        int tmpSum = 0;
        for(int intS : list){
            tmpSum += intS;
        }
        return tmpSum < sum;

    }

    private boolean finalS(ArrayList<Integer> list,int sum){

        int tmpSum = 0;
        for(int intS : list){
            tmpSum += intS;
        }
        return tmpSum == sum;

    }

    private boolean bound(int a ,int sum){
        return a < sum;
    }
}

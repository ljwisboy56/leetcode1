package com.example.jzof;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-15 21:19
 */
public class FindContinuousSequence {

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();


    /**
     *
     * dp(i,j):（i是取第n个数，j标识剩余数量时）的种树
     * 如果第i个数我们取了，v(j) < j; dp(i,j)=dp(i-1,j-v(j))+v(j));
     * 如果第i个数我们没取，dp(i,j)=dp(i-1,j)
     *
     * 边界条件：
     * 当容量为0时，dp(i,j)=0
     * 当取第0个数是，dp(i,j)=0;
     *
     *
     * @return
     */
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> res = new FindContinuousSequence().FindContinuousSequence(5);
        System.out.println(res);



    }



    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int[] array = new int[sum-1];
        //先初始化出一个数组
        for(int i =1;i < sum;i++){
            array[i-1] = i;
        }

        //把问题变成我们常见的回溯或者动态规划
        doFindCount(array,sum);
        return listAll;

    }

    /**
     * 给定一个数组，让你求这个数组达到某种值的所有集合，标准的回溯，排列集问题
     * @param array
     * @param sum
     */
    private void doFindCount(int[] array, int sum) {
        readDoFind(0,array.length,array,sum);
    }

    private void readDoFind(int start,int end, int[] array, int sum) {

        if(sum(start,end,array) >= sum){
            ArrayList<Integer> list = null;
            for(int i = start;i <= end;i++){
                list = new ArrayList<>();
                list.add(array[i]);
            }
            listAll.add(list);
        }else {
            for(int i = start;i < array.length;i++){
                swap(i,start,array);
                int[] newArray = new int[end-start+1];
                int ni = 0;
                for(int s =start;s <= end;s++){
                    newArray[ni++] = array[s];
                }
                if(constraint(i,start,sum,newArray)){
                    sum = sum - array[i];
                    readDoFind(i+1,end,array,sum);
                }
                swap(i,start,array);
            }

        }

    }

    private int sum(int start, int end, int[] array) {
        return 0;

    }

    private boolean constraint(int i,int t, int sum,int[] array) {
        if(array[i] > sum){
            return false;
        }

        int tmpSum = 0;
        for(int j = t;j <= i;j++){
            tmpSum += array[j];
        }
        if(tmpSum > sum){
            return false;
        }
        return true;

    }

    private void swap(int i, int t, int[] array) {
        int tmp = array[i];
        array[i] = array[t];
        array[t] = tmp;
    }
}

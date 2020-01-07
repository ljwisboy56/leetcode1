package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-16 23:07
 */
public class LastRemaining_Solution {

    public static void main(String[] args) {
        int res = new LastRemaining_Solution().LastRemaining_Solution(6,3);
        System.out.println(res);
    }

    /**
     *
     * 0 1  2 3 4  5
     * 0 1 -2 3 4 -2
     * 0 1 -2 -2 4 -2
     * 0 -2 -2 -2 4 -2
     * 0 -2 -2 -2 -2 -2
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {

        if(n == 0 || m == 0){
            return -1;
        }

        //先把问题转成数组来做，用数组模拟一个圆环
        int[] array = new int[n];
        for(int i =0;i < n;i++){
            array[i] = i;
        }

        //找到这个小朋友是第几个小朋友
        return doFindXiaoPengYoutM(array,0,m-1);

    }

    private int doFindXiaoPengYoutM(int[] array,int begin,int end) {

        //终止条件，当只剩下一个小朋友的时候，就终止，那么最终小朋友就是begin的前一个
        if(count2(array)==array.length-1){
            return begin;
        }

        //开始真正的去找
        int count = -1;
        //循环遍历这个圆环数组
        for(int i = begin;;i++){
            if(i == array.length){
                i = 0;
            }
            //如果没有到达小朋友的数字，则看该位是不是-2，如果是-2则跳过该位，什么也不做
            if(array[i] == -2){
                continue;
            }
            //如果不是-2，说明是正常位置的小朋友那么记录一个count++
            else {
                count++;
            }
            //如果到了选中数的小朋友
            if(count == end){
                //把该小朋友设置为-2，证明其已经出局
                array[i] = -2;
                //设置开始位位下一个小朋友,那么这个小朋友是下一个不是-2的小朋友的坐标
                begin = setBegin(i,array);
                //然后终止这次的查找，递归进入下一次
                break;
            }
        }
        return doFindXiaoPengYoutM(array,begin,end);
    }

    private int setBegin(int i,int[] arr) {
        int begin = 0;
        //这些是数组中还在参与游戏的
        for(int t = i;;t++){
            if(t >= arr.length){
                t = 0;
            }
            if(arr[t] != -2){
                begin = t;
                break;
            }
        }
        return begin;

    }

    //求出不在的人
    private int count2(int[] array) {
        int size=0;
        for(int tmp : array){
            if(tmp == -2){
                size++;
            }
        }
        return size;
    }


}

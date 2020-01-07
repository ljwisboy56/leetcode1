package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-07 20:19
 */
public class MoreThanHalfNum_Solution {


    public static void main(String[] args) {
        int[] a = new int[]{1};
        int r = new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(a);
        System.out.println(r);
    }


    int res = 0;

    public int MoreThanHalfNum_Solution(int [] array) {
        
        if(array == null){
            return 0;
        }

        return doFind(array,0);

    }

    private int doFind(int[] array,int begin) {
        
        if(begin > array.length-1){
            return res;
        }else {
            for(int i = begin;i < array.length; i++){
                int x = array[i];

                if(constraint(array,x)){
                     res = array[i];
                     return res;
                }else {
                    doFind(array,begin+1);
                }
            }
        }
        
        return res;
    }

    private boolean constraint(int[] array,int x) {

        int sum = array.length/2;
        int count = 0;
        for(int a : array){
            if(a == x){
                count++;
            }
        }
        return count > sum;
    }

}

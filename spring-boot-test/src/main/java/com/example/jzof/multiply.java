package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-17 23:42
 */
public class multiply {

    /**
     *
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */
    public int[] multiply(int[] A) {


        if(A == null || A.length == 0){
            return null;
        }

        int[] B = new int[A.length];



        for(int i=0;i<A.length;i++){
            B[i] = count(A,i);
        }
        return B;
    }

    private int count(int[] arr, int i) {

        int sum = 1;
        for(int j = 0;j < arr.length;j++){
            if(j != i){
                sum = sum * arr[j];
            }
        }
        return sum;
    }


}

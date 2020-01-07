package com.example.jzof2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-12-25 10:00
 */
public class BST树复原 {

    public static void main(String[] args) {

        int[] a = new int[]{4,8,6,12,16,14,10};

        boolean res = new BST树复原().VerifySquenceOfBST(a);

        System.out.println(res);

    }

    boolean res  =false;

    //[1,2,3,4,9,6,7,8,5]
    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence == null || sequence.length == 0){
            return false;
        }

        return doVerfy(sequence);


    }

    boolean doVerfy(int[] sequence){
        if(sequence.length <= 1){
            return true;
        }

        //拿到根节点
        int root = sequence[sequence.length-1];

        int index = 0;


        while (index <= sequence.length-1 && sequence[index] < root){
            index++;
        }

        int index2 = index;
        for(int i = index2;i < sequence.length-1;i++){
            if(sequence[i] < root){
                return false;
            }
        }

        return doVerfy(Arrays.copyOfRange(sequence,index,sequence.length-1));
    }




}

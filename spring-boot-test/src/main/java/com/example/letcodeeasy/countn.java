package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-12-22 22:11
 */
public class countn {

    public static void main(String[] args) {
        //4 3 2 1
        new countn().sumN(5);



    }

    /**
     * sum = target-1,target-2,...0;
     * @param target
     * @return
     */
    private int sumN(int target){
        int sum = 0;

        for(int i =0;i <target;i++){
            sum += i;
        }
        System.out.println(sum);
        return sum;

    }
}

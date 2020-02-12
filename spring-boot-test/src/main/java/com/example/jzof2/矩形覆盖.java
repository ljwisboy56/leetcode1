package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 23:30
 */
public class 矩形覆盖 {

    //dp[i]=dp[i-1]+dp[i-2]
    public int RectCover(int target) {

        if(target == 0){
            return 0;
        }

        if(target ==1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= target;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[target];

    }

}

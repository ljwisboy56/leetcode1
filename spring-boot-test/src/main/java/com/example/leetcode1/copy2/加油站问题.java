package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-05 20:27
 */
public class 加油站问题
{
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr = {1,5,2,1,7};
        int res = find(arr);
        System.out.println(arr);
    }

    private static int find(int[] arr){
        if(arr == null || arr.length ==0){
            return 0;
        }

        int[] dp = new int[arr.length-1];

        dp[0] = arr[0];
        dp[1] = Math.max(dp[0],arr[1]);

        //dp(i) = Max(dp(i-2)+ arr[i],dp[i-1]);
        for(int i =2;i < arr.length;i++){
            dp[i] = Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        return dp[arr.length -1];

    }

}

package com.example.leetcode1;

import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-01-16 00:08
 */
public class 解码方法 {


    public static void main(String[] args) {


        int res = new 解码方法().numDecodings("226");
        System.out.println(res);

    }

    /**
     * 动态规划：
     *
     * 22：分为2、2（BB）,22 BV
     * 226：2、2、6（BBZ）,2 22 6(BVF),2,26(BZ)
     * 227：2、2、7，2、22、7，
     * 2220：2，2,20
     *
     *
     * dp[i]=dp(i-1)+
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }

        String[] strings = s.split("");

        if("0".equals(strings[0])){
            return 0;
        }

        int[] dp = new int[strings.length+1];
        dp[0] = 1;
        for(int i = 2 ;i < strings.length;i++){
            int a = 0;

            if(strings[i].equals("0")){
                if(Integer.valueOf(strings[i-1]+strings[i]) <= 26){
                    dp[i] = dp[i-2] +1;
                }else {
                    return 0;
                }
            }else {

                if(Integer.valueOf(strings[i-1]+strings[i]) <= 26){
                    a = 1;
                }
                dp[i] = dp[i-1] + a;
            }

        }

        return dp[strings.length-1];

    }


}

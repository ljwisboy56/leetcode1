package com.example.leetcode2.copy2;

import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-24 01:52
 */
public class 第120题三角形最小路径和 {


    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null){
            return 0;
        }
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        int m = triangle.get(triangle.size()-1).size();

        //动态规划表
        int[][] dp = new int[n][m];
        //初始化
        dp[0][0] = triangle.get(0).get(0);
        dp[1][1] = dp[0][0]+ triangle.get(1).get(1);
        dp[1][0] = dp[0][0]+ triangle.get(1).get(0);

        for (int i = 2  ; i < triangle.size();i++){
            for (int j = 0; j < triangle.get(i).size();j++){
                //最左边的一定是
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                else if(j == triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for (int tmp : dp[n-1]){
            res = Math.min(res,tmp);
        }

        return res;

    }

//    List<List<Integer>> triangle = new ArrayList<>();
//
//    int minRes = Integer.MAX_VALUE;
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//
//        this.triangle = triangle;
//        this.doFind(0,0,0);
//        return minRes;
//
//    }
//
//
//    private void doFind(int n,int diguiCount,int sum) {
//
//        if(diguiCount == triangle.size()){
//            minRes = Math.min(minRes,sum);
//        }else {
//            List<Integer> list = triangle.get(diguiCount);
//            //每层的节点数
//            for (int i = n ;i < list.size() ;i++){
//                if(i > n +1){
//                    break;
//                }
//                //先拿到当前值
//                sum += list.get(i);
//                doFind(i,diguiCount+1,sum);
//                sum -= list.get(i);
//            }
//        }
//    }

}

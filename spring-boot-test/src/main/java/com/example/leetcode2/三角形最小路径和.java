package com.example.leetcode2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-13 12:54
 */
public class 三角形最小路径和 {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        int res = new 三角形最小路径和().minimumTotal(triangle);
        System.out.println(res);

    }

    List<List<Integer>> triangle = new ArrayList<>();

    int minRes = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {

        this.triangle = triangle;

//        this.doFind(0,0,0);

        return this.doFind2(triangle);

//        return minRes;


    }

    /**
     * 动态归还转移方程：思路1：
     * 自顶向下，递推公式 minPath[i][j] = Min()minPath[i-1][j-1], minPath[i-1][j]) + a[i][j],
     *
     * 链接：https://leetcode-cn.com/problems/triangle/solution/dong-tai-gui-hua-zi-ding-xiang-xia-zi-di-xiang-s-3/
     */
    private int  doFind2(List<List<Integer>> triangle) {

        if(triangle == null){
            return 0;
        }

        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }

        int n = triangle.size();

        int m = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[n][m];

        dp[0][0] = triangle.get(0).get(0);

        dp[1][1] = dp[0][0]+ triangle.get(1).get(1);

        dp[1][0] = dp[0][0]+ triangle.get(1).get(0);

        for (int i = 2  ; i < triangle.size();i++){
            for (int j = 0; j < triangle.get(i).size();j++){
                //最左边的一定是
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j == triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else {
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

    private void doFind(int n,int diguiCount,int sum) {

        if(diguiCount == triangle.size()){
            minRes = Math.min(minRes,sum);
        }else {
            List<Integer> list = triangle.get(diguiCount);
            //每层的节点数
            for (int i = n ;i < list.size() ;i++){
                //先拿到当前值
                sum += list.get(i);
                if(i > n +1){
                    break;
                }
                doFind(i,diguiCount+1,sum);
                sum -= list.get(i);
            }
        }
    }
}

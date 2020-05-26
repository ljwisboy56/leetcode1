package com.example.leetcode2.copy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-20 11:57
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

    int min = Integer.MAX_VALUE;
    public int minimumTotal2(List<List<Integer>> triangle) {
        dfs(0,0,triangle,0);
        return min;

    }

    private void dfs(int n, int sum,List<List<Integer>> triangle,int level) {
        if(level == triangle.size()){
            min =Math.min(min,sum);
            return;
        }else if(level == 0){
            sum += triangle.get(0).get(0);
            dfs(0,sum,triangle,level+1);
        }
        else {
            for (int i = n; i <= n+1; i++) {
                sum += triangle.get(level).get(i);
                dfs(i,sum,triangle,level+1);
                sum -= triangle.get(level).get(i);
            }
        }
    }

    /**
     * dp(m,n) = max( dp(m-1,n-1),dp(m-1,n))+v(i,j)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

      return 0;

    }

}

package com.example.leetcode2.copy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-20 11:52
 */
public class 杨辉三角2 {

    public static void main(String[] args) {

        List<Integer> allList = new 杨辉三角2().getRow(4);
        System.out.println(allList);

    }

    List<List<Integer>> allList = new ArrayList<>();


    public List<Integer> getRow(int rowIndex) {

        dfs(0,rowIndex);

        return allList.get(rowIndex-1);

    }

    private void dfs(int n, int numRows) {

        if(n == numRows){
            return;
        }else if(n == 0){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            allList.add(cur);
        }else {
            //拿到上一个队列集合
            List<Integer> pre = allList.get(n-1);
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if(i == 0 || i == n){
                    cur.add(1);
                }else {
                    cur.add(pre.get(i) + pre.get(i-1));
                }
            }
            allList.add(cur);
        }
        dfs(n+1,numRows);
    }
}

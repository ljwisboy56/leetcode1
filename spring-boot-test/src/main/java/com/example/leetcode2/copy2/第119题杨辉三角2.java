package com.example.leetcode2.copy2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-23 13:18
 */
public class 第119题杨辉三角2 {

    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex+1).get(rowIndex);
    }

    List<List<Integer>> allList = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        dfs(1,numRows);
        return allList;
    }

    private void dfs(int n,int nums) {
        if(n > nums){
            return;
        }else if(n == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            allList.add(tmp);
            dfs(n+1,nums);
        }
        else {
            List<Integer> pre = allList.get(n-2);
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(i == 0 || i == n-1){
                    cur.add(1);
                }else {
                    int tmp = pre.get(i-1)+pre.get(i);
                    cur.add(tmp);
                }
            }
            allList.add(cur);
            dfs(n+1,nums);
        }
    }

}

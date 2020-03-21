package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-21 18:09
 */
public class 第77题组合 {

    public static void main(String[] args) {
        List<List<Integer>> allList = new 第77题组合().combine(4,2);
        System.out.println(allList);


    }

    /**
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    List<List<Integer>> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return allList;
    }

    private void dfs(int i, int n, int k) {
        if(list.size() == k){
            allList.add(new ArrayList<>(list));
        }else {
            for (int j = i; j <= n; j++) {
                list.add(j);
                dfs(j+1,n,k);
                list.remove(list.size()-1);
            }
        }
    }

}

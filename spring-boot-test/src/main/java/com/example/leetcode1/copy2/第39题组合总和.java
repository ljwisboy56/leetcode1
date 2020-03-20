package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-18 00:38
 */
public class 第39题组合总和 {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        List<List<Integer>> allList = new 第39题组合总和().combinationSum(candidates,8);
        System.out.println(allList);
    }

    List<List<Integer>> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //特判
        if(candidates == null || candidates.length == 0) return allList;
        this.target = target;
        dfs(0,candidates,0);
        return allList;
    }

    private void dfs(int n, int[] candidates, int sum) {
        if(n > candidates.length){
            return;
        }else if(sum == target){
            allList.add(new ArrayList<>(list));
        }else {
            for (int i = n ; i < candidates.length; i++) {
                list.add(candidates[i]);
                sum += candidates[i];
                if(sum <= target){
                    dfs(i,candidates,sum);
                }
                sum -= candidates[i];
                list.remove(list.size()-1);
            }
        }
    }


}

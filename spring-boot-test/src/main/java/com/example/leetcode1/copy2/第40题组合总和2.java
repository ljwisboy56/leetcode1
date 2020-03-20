package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-18 01:08
 */
public class 第40题组合总和2 {

    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        List<List<Integer>> allList = new 第40题组合总和2().combinationSum2(arr,5);
        System.out.println(allList);
    }

    List<List<Integer>> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int target = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length==0) return allList;
        this.target = target;
        Arrays.sort(candidates);
        dfs(0,candidates,0);
        return allList;
    }

    private void dfs(int n, int[] candidates, int sum) {
        if(n > candidates.length){
            return;
        }else if(sum == target){
            allList.add(new ArrayList<>(list));
        }else {
            for (int i = n; i < candidates.length; i++) {
                //这个地方很关键，n代表当前层，只有大于当前层的下一层会过滤掉
                if(i > n && candidates[i] == candidates[i-1]){
                    continue;
                }
                sum += candidates[i];
                list.add(candidates[i]);
                if(sum <= target){
                    dfs(i+1,candidates,sum);
                }
                sum -= candidates[i];
                list.remove(list.size()-1);
            }
        }
    }

}

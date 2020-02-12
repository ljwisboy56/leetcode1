package com.example.leetcode1.leetcodecopy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-04 12:55
 */
public class 组合总和2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        List<List<Integer>> allList = new  组合总和2().combinationSum2(arr,3);
        System.out.println(allList);


    }

    private int target = 0;

    private List<List<Integer>> allList = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0){
            return allList;
        }

        Arrays.sort(candidates);

        this.target = target;

        doFind(0,candidates,0);

        return allList;

    }

    private void doFind(int n, int[] candidates,int sum) {
        if(n >= candidates.length){
           return;
        }else {
            for (int i = n;i < candidates.length;i++){
                //注意这个如何避免重复这个非常经典，是反判断
                if(i > n  && candidates[i] == candidates[i-1]){
                    continue;
                }
                list.add(candidates[i]);
                sum += candidates[i];
                //剪纸部分
                if(sum == target){
                    allList.add(new ArrayList<>(list));
                    //当满足条件后，同层节点后面的加和一定都大于目标值，所以剪枝并且、回溯
                    //remove是回溯
                    sum -= candidates[i];
                    list.remove(list.size()-1);
                    //break是剪枝
                    break;
                }
                //当小于目标值，则递归进入下一层
                else if(sum < target){
                    doFind(i+1,candidates,sum);
                }
                //如果大于则直接剪枝并且回溯
                else {
                    sum -= candidates[i];
                    list.remove(list.size()-1);
                    break;
                }
                sum -= candidates[i];
                list.remove(list.size()-1);
            }
        }
    }


}

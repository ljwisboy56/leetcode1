package com.example.leetcode1.copy1;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-03 23:13
 */
public class 组合总和 {

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,4,3};
        List<List<Integer>> allList = new 组合总和().combinationSum(arr,11);
        System.out.println(allList);

    }

    HashSet<String> set = new HashSet<>();

    List<List<Integer>> allList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    int target = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        this.target = target;

        this.doCombinationSum(0, candidates);

        return allList;
    }

    private void doCombinationSum(int n, int[] candidates) {
        for (int i=0;i < candidates.length;i++){
            list.add(candidates[i]);
            int sv = sum(list);
            if(sv == target){
                if(judge(list)){
                    allList.add(new ArrayList<>(list));
                }
                list.remove(list.size()-1);
                break;
            }else if(sv < target){
                doCombinationSum(n+1,candidates);
            }else {
                list.remove(list.size()-1);
                break;
            }
            list.remove(list.size()-1);
        }
    }

    private boolean judge(List<Integer> list) {

        ArrayList<Integer> tmpList = new ArrayList<Integer>(list);

        Collections.sort(tmpList);

        String key = "";
        for (int tmp : tmpList){
            key += "-" + tmp;
        }

        if (!set.contains(key)){
            set.add(key);
            return true;
        }else {
            return false;
        }
    }

    private int sum(List<Integer> list){
        int sum =0;
        for (int tmp : list){
            sum+=tmp;
        }
        return sum;
    }

}

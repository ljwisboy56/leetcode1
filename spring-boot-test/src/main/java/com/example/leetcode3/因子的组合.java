package com.example.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-29 14:29
 */
public class 因子的组合 {

    public static void main(String[] args) {

        List<List<Integer>> allList = new 因子的组合().getFactors(62847);
        System.out.println(allList);

    }

    List<List<Integer>> allList = new ArrayList<>();

    int target = 0;

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {

        if(n == 1){
            return allList;
        }

        this.target = n;

        dfs(2,1);

        return allList;

    }

    private void dfs(int n, int sum) {

        if(sum > target){
            return;
        }else if(sum == target){
            allList.add(new ArrayList<>(list));
        }else {
            for (int i = n; i < target; i++) {
                if(target % i == 0){
                    sum *= i;
                    list.add(i);
                    if(sum > target){
                        sum /= i;
                        list.remove(list.size()-1);
                        break;
                    }
                    dfs(i,sum);
                    sum /= i;
                    list.remove(list.size()-1);
                }

            }
        }

    }



}

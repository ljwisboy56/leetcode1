package com.example.leetcode1.leetcodecopy1;

import com.example.order.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-09 14:05
 */
public class 组合 {

    public static void main(String[] args) {

        List<List<Integer>> allList= new 组合().combine(1,1);
        System.out.println(allList);

    }


    List<List<Integer>> allList=  new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    int target =0;

    int k = 0;

    public List<List<Integer>> combine(int n, int k) {

        this.target = n;

        this.k = k;

        this.doFind(1);

        return allList;

    }

    private void doFind(int n) {
        if(list.size() == k){
            allList.add(new ArrayList<>(list));
        }else {
            for (int i =n;i <= target;i++){
                list.add(i);
                doFind(i+1);
                list.remove(list.size()-1);
            }
        }
    }

}

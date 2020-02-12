package com.example.leetcode1.leetcodecopy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-02 01:27
 */
public class 括号生成 {

    List<String> list = new ArrayList<>();

    int target = 0;

    int[] x = null;

    public List<String> generateParenthesis(int n) {

        this.target = 2 * n;

        x = new int[target];

        for (int i =0;i < x.length;i++){
            x[i] = -1;
        }

        doFind(0);

        return list;


    }

    private void doFind(int n) {

        if(n >= target){
            output(x);
        }else {
            for (int i=0;i<=1;i++){
                x[n] = i;
                if(constrint(x)){
                    doFind(n+1);
                }
                x[n] = -1;
            }
        }
    }

    private boolean constrint(int[] x) {
        int left =0;
        int right = 0;
        for (int tmp : x){
            if(tmp == 0){
                left++;
            }
            if(tmp == 1){
                right++;
            }
        }
        return left <= target/2 && right <= target/2 && left >= right;
    }

    private void output(int[] x) {
        String str = "";
        for(int tmp : x){
            if(tmp == 0){
                str += "(";
            }
            if(tmp == 1){
                str += ")";
            }
        }
        list.add(str);
    }

}

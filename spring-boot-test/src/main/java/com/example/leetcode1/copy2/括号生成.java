package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-05 00:09
 */
public class 括号生成 {
    ArrayList<String> list = new ArrayList<>();
    int target = 0;
    int[] x ;
    public List<String> generateParenthesis(int n) {

        this.target = 2 * n;

        x = new int[target];
        //初始化
        for(int i = 0; i < target;i++){
            x[i] = -1;
        }

        doFind(0);

        return list;

    }

    private void doFind(int n) {
        if(n >= target){
            output(x);
        }else {
            for(int i =0; i<=1;i++){
                x[n] = i;
                if(constraint(x)){
                    doFind(n+1);
                }
                x[n] = -1;
            }
        }
    }

    private boolean constraint(int[] x) {
        //用0来记录左括号个数
        int left = 0;
        //用1来记录又括号的个数
        int right = 0;
        for(int tmp : x){
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

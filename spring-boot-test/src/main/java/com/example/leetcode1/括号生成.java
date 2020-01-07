package com.example.leetcode1;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-01-03 00:46
 */
public class 括号生成 {


    ArrayList<String> list = new ArrayList<>();

    int target = 0;

    int[] x ;

    public static void main(String[] args) {
        List<String> res = new 括号生成().generateParenthesis(6);
        System.out.println(res);
    }


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


    public List<String> generateParenthesis2(int n) {

        this.target = n;

        doGenerate("",0,0);

        return null;
    }

    private void doGenerate(String str, int left, int right) {


        if(left > target || right > target){
            return;
        }

        if(left == target && right == target){
            list.add(str);
            return;
        }

        if(left > right){
            doGenerate(str+"(",left+1,right);
            doGenerate(str+")",left,right+1);
        }

    }



}

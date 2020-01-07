package com.example.jzof;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author yingru.ljw
 * @date 2019-12-07 17:00
 */
public class Permutation {


    ArrayList<String> list = new ArrayList<>();

    TreeSet<String> tee = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {

        if(str == null){
            return list;
        }

        char[] chars = str.toCharArray();

        doPermutation(chars,0);

        list.addAll(tee);
        return list;

    }


//    //针对N叉树的递归回溯方法
//    void backtrack (int t)
//    {
//        if (t>n) output(x); //叶子节点，输出结果，x是可行解
//        else
//            for i = 1 to k//当前节点的所有子节点
//        {
//            x[t]=val(i); //每个子节点的值赋值给x
//            //满足约束条件和限界条件
//            if (constraint(t)&&bound(t))
//                backtrack(t+1);  //递归下一层
//        }
//    }

    private void doPermutation(char[] chars, int begin) {


        if(begin == chars.length-1){
            tee.add(String.valueOf(chars));
        }else {

            for(int i =begin;i<chars.length;i++ ){
                swap(chars,i,begin);
                doPermutation(chars,begin+1);
                swap(chars,i,begin);
            }

        }

    }

    private void swap(char[] chars, int i, int begin) {
        char tmp = chars[i];
        chars[i] = chars[begin];
        chars[begin] = tmp;
    }
}

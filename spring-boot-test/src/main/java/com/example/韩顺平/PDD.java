package com.example.韩顺平;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-09 20:54
 */
public class PDD {

    /**
     * hash表
     */
    static HashSet<String> set;

    /**
     * 目标值w
     */
    static String w ;

    /**
     * hash函数
     * @param str
     * @return
     */
    public static String hash(String str){
        char[] strings = str.toCharArray();
        Arrays.sort(strings);
        return new String(strings);
    }

    /**
     * 初始化所有100亿数据，和目标值w
     * @param strs
     */
    public static void init(String[] strs){
        set = new HashSet<>();
        set.addAll(Arrays.asList(strs));
        w = hash("word");
    }

    public static List<String> find(){
        List<String> list = new ArrayList<>();
        for(String str : set){
            if(hash(str).equals(w)){
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args){
        //测试数据
        String[] strs = {"sosd","rowd","aaaw","word"};
        //初始化数据
        init(strs);
        //发现查找函数
        List<String> res= find();
        System.out.println(res);
    }

}

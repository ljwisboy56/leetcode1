package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author yingru.ljw
 * @date 2020-02-01 21:58
 */
public class 电话号码的字幕组合 {

    public static void main(String[] args) {
        List<String> list = new 电话号码的字幕组合().letterCombinations("23");
        System.out.println(list);



    }

    private static HashMap<Character,String> hashMap = new HashMap<>();

    static {
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
    }

    List<String> list = new ArrayList<>();


    public List<String> letterCombinations(String digits) {



        if(Objects.isNull(digits) || "".equals(digits)){
            return list;
        }

        int len = digits.length();

        String res = "";

        //初始化
        list.add(res);

        for (int i=0;i < len;i++){
            doLetter(digits.charAt(i));
        }

        return list;
    }

    private void doLetter(char tc) {

        ArrayList<String> tmpList = new ArrayList<>();

        String str = hashMap.get(tc);

        //获取数组
        String[] strings = str.split("");

        for (int i =0; i<strings.length;i++){
            for (String tmp : list){
                tmp = tmp + strings[i];
                tmpList.add(tmp);
            }
        }

        list = tmpList;
    }
}

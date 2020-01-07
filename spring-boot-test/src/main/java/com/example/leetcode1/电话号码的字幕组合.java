package com.example.leetcode1;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-01-01 19:08
 */
public class 电话号码的字幕组合 {

//    public static void main(String[] args) {
//        List<String> res= new 电话号码的字幕组合().letterCombinations("2345");
//        System.out.println(res.size());
//    }


    static Map<Character,String> map = new HashMap<>();
    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits == null || digits.equals("")){
            return result;
        }

        int length = digits.length();
        //转char集合
        char[] chars = digits.toCharArray();
        //拿到字符对应的str集合
        String startStr = map.get(chars[0]);
        //拿到第一个字符串list
        List<String> listStartStr = Arrays.asList(startStr.split(""));
        result.addAll(listStartStr);
        List<String> preList = new ArrayList<>(result);
        for(int i = 1; i < length;i++){
            List<String> strings = caculate(result,map.get(chars[i]));
            result.addAll(strings);
            result.removeAll(preList);
            preList = new ArrayList<>(result);

        }
        return result;

    }

    private List<String> caculate(List<String> a, String b){

        char[] charsB = b.toCharArray();
        List<String> res = new ArrayList<>();
        String str = "";
        for(int i = 0;i < a.size();i++){
            for (int j=0;j < charsB.length;j++){
                str = str + a.get(i);
                str = str + charsB[j];
                res.add(str);
                str = "";
            }
        }
        return res;
    }


}

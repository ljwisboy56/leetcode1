package com.example.leetcode1;

import com.example.order.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-31 23:09
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] str = new String[]{"caa","","a","acb"};
        String abc = new 最长公共前缀().longestCommonPrefix(str);
        System.out.println(abc);
    }

    String maxStr = null;

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        for(int i = 0; i < strs.length;i++){
            for(int j = i+1; j < strs.length;j++){
                String s1 = strs[i];
                String s2 = strs[j];
                String tmpStr = findMaxStr(s1.toCharArray(),s2.toCharArray());
                if(maxStr == null){
                    maxStr = tmpStr;
                }else {
                    if(tmpStr.length() < maxStr.length()){
                        if(maxStr.startsWith(tmpStr)){
                            maxStr = tmpStr;
                        }
                    }
                }
            }
        }

        if(maxStr == null){
            return "";
        }else {
            return maxStr;
        }
    }

    private String findMaxStr(char[] a,char[] b){
        ArrayList<Character> tmp = new ArrayList<>();
        int length = Math.min(a.length,b.length);
        int start = 0;
        while (start < length){
            if(a[start] == b[start]){
                tmp.add(a[start]);
                start++;
            }else {
                break;
            }
        }

        StringBuilder stringBuffer = new StringBuilder();
        for (Character character : tmp){
            stringBuffer.append(character);
        }
        return stringBuffer.toString();
    }

}

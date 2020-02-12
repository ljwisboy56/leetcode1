package com.example.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-01-11 15:56
 */
public class 最小覆盖子串 {

    public static void main(String[] args) {

        String res = new 最小覆盖子串().minWindow("ADOBECODEBANC","ABC");
        System.out.println(res);

    }

    String res = "";

    HashMap<Character,Integer> map = null;
    /**
     *
     * 滑动窗口思想
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        //先初始化t窗口
        map = new HashMap<>();
        char[] ts = t.toCharArray();
        for (char tmp : ts){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }

        //其次初始化2个指针
        int left = 0;
        int right = 0;

        //然后初始化目标值
        char[] ss = s.toCharArray();

        while (right <= ss.length){
            //拷贝出窗口数组
            String tmpStr = s.substring(left,right);
            if(window(tmpStr)){
                if("".equals(res)){
                    res = tmpStr;
                }else if(tmpStr.length() < res.length()){
                    res = tmpStr;
                }
                while (left < right){
                    left++;
                    tmpStr = s.substring(left,right);
                    if(window(tmpStr)){
                        tmpStr = s.substring(left,right);
                        if(tmpStr.length() < res.length()){
                            res = tmpStr;
                        }
                    }else {
                        break;
                    }
                }
            }
            right++;
        }
        return res;
    }

    private boolean window(String tmpStr) {

        char[] tmpChar = tmpStr.toCharArray();

        HashMap<Character,Integer> tmpMap = new HashMap<>();
        for (char tmp : tmpChar){
            tmpMap.put(tmp,tmpMap.getOrDefault(tmp,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(tmpMap.containsKey(entry.getKey())){
                if(tmpMap.get(entry.getKey()) < entry.getValue()){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

}

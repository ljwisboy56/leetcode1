package com.example.leetcode2;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-17 14:52
 */
public class 至多包含两个不同字符的最长子串 {

    HashMap<Character,Integer> hashMap = new HashMap<>();


    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }

        int len = s.length();

        if(len <= 2){
            return len;
        }

        int left = 0;
        int right = 0;

        int res = 0;

        while (right < len){
            //拿到当前元素
            //这步操作就可能把2个不同元素变为3个，这个时候就要更新坐标了。
            if(hashMap.size() < 3){
                //更新相同元素的最右位置，这样一步可以跳过多个值
                hashMap.put(s.charAt(right),right);
                right++;
            }
            //更新的逻辑：我们先找到所有坐标里面做小的，那么他一定是最左坐标然后删除调这个key移动他前面
            //即他的下一位就好了
            else {
                //找到map中最小的坐标
                int index = Collections.min(hashMap.values());
                //删除当前最小的元素
                hashMap.remove(s.charAt(index));
                //移动左指针
                left = index +1;
            }

            res = Math.max(res,right-left);
        }
        return res;

    }

}

package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-19 22:21
 */
public class 第58题最后一个单词的长度 {

    public static void main(String[] args) {

        System.out.println(new 第58题最后一个单词的长度().lengthOfLastWord("hello world"));

    }

    public int lengthOfLastWord(String s) {

        if(s == null || "".equals(s.trim())){
            return 0;
        }
        String[] strings = s.split(" ");
        for (int i = strings.length-1; i >= 0; i--) {
            if(!"".equals(strings[i])){
                return strings[i].length();
            }
        }
        return 0;
    }
}

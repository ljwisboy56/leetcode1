package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-07 12:43
 */
public class 最后一个单词的长度 {

    public static void main(String[] args) {
        int res = new 最后一个单词的长度().lengthOfLastWord("hello world ");
        System.out.println(res);

    }


    public int lengthOfLastWord(String s) {

        if(s == null || "".equals(s)){
            return 0;
        }

        int count = 0;
        for (int i = s.length()-1;i >= 0 ;i--){
            if(s.charAt(i) != ' '){
                count++;
            }else {
                if(i+1 < s.length()-1 && s.charAt(i+1) !=' '){
                    break;
                }
            }
        }
        return count;

    }

}

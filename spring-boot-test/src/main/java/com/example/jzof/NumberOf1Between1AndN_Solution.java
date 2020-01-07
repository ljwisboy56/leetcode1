package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-15 15:19
 */
public class NumberOf1Between1AndN_Solution {


    public static void main(String[] args) {
        int res = new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(13);
        System.out.println(res);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        //把每个数都转成字符串来处理
        for(int j = 1;j<=n;j++){
            String nstr= String.valueOf(j);
            char[] chars = nstr.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1') {
                    num++;
                }
            }
        }
        return num;
    }

}

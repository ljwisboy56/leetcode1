package com.example.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-15 13:49
 */
public class 分割回文串 {

    public static void main(String[] args) {
        List<List<String>> allList = new 分割回文串().partition("aab");
        System.out.println(allList);


    }

    List<List<String>> allList = new ArrayList<>();

    List<String> list = new ArrayList<>();

    int len = 0;

    int[][] dp = null;

    public List<List<String>> partition(String s) {

        if(s == null || "".equals(s)){
            return allList;
        }


        len = s.length();

        dp = new int[len][len];

        //初始化动态规划表
        this.init(dp,s);

        this.dfs(0,s);

        return allList;

    }

    private void init(int[][] dp, String s) {
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1] ==1)) {
                    dp[left][right] = 1;
                }
            }
        }

    }

    private void dfs(int n, String s) {
        if(n >=s.length()){
            allList.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = n; i < s.length(); i++) {
                if(dp[n][i] == 0){
                    continue;
                }
                //他取值的时候，是把数的分支截取出来的
                list.add(s.substring(n,i+1));
                dfs(i+1,s);
                list.remove(list.size()-1);
            }
        }
    }

}

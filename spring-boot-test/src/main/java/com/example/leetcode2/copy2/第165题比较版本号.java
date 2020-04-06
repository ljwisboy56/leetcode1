package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-28 20:30
 */
public class 第165题比较版本号 {

    /**
     * 输入: version1 = "0.1", version2 = "1.1"
     * 输出: -1
     */
    public static void main(String[] args) {

        System.out.println(new 第165题比较版本号().compareVersion("0.1","1.1.0.0.0.0.0.0"));


    }


    public int compareVersion(String version1, String version2) {

        while (version1.split("\\.").length > version2.split("\\.").length) {
            version2 += ".";
            version2 += "0";
        }

        while (version1.split("\\.").length < version2.split("\\.").length) {
            version1 += ".";
            version1 += "0";
        }

        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        for (int i = 0; i < v1s.length; i++) {
            if(Integer.valueOf(v1s[i]) > Integer.valueOf(v2s[i])){
                return 1;
            }else if(Integer.valueOf(v1s[i]) < Integer.valueOf(v2s[i])){
                return -1;
            }
        }

        return 0;

    }

}

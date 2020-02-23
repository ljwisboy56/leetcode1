package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-23 13:11
 */
public class 比较版本号 {


    public static void main(String[] args) {
        String a1 = "1.01";
        String a2 = "1.001";
        int res = new 比较版本号().compareVersion(a1,a2);
        System.out.println(res);



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

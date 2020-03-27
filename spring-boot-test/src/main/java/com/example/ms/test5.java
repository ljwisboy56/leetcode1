package com.example.ms;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-03-25 12:40
 */
public class test5 {

    public static void main(String[] args) {
        System.out.println(new test5().solution(0,2,3,2));
        for(String str : set){
            System.out.println(str);
        }
    }

    static HashSet<String> set = new HashSet<>();
    public int solution(int A, int B, int C, int D) {
        int[] arr = new int[4];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = D;
        for (int i = 0; i < 4; ++i){
            for (int j = 0; j < 4; ++j) {
                if (j != i){
                    for (int k = 0; k < 4; ++k) {
                        if (k != i && k != j) {
                            int l = 6 - i - j - k;
                            int hours = 10 * arr[i] + arr[j];
                            int mins = 10 * arr[k] + arr[l];
                            if (hours < 24 && mins < 60){
                                String key = "" + hours + mins;
                                set.add(key);
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }


}

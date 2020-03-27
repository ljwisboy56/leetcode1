package com.example.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-25 12:03
 */
public class test1 {

    public static void main(String[] args) {
        test1 t1 = new test1();
        int[] res = t1.solution(20);
        System.out.println(res);


    }


    public int[] solution(int N) {
        List<Integer> list = new ArrayList<>();
        if(N % 2 == 0){
            for (int i = 1; i<= N/2; i++) {
                list.add(-i);
            }
            for (int i = 1; i <= N/2 ; i++) {
                list.add(i);
            }
        }else {
            list.add(0);
            for (int i = 1; i<= N/2; i++) {
                list.add(-i);
            }
            for (int i = 1; i <= N/2 ; i++) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}

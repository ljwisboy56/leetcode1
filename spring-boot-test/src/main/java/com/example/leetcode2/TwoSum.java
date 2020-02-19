package com.example.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-18 12:43
 */
public class TwoSum {

    List<Integer> list ;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(list.size() <= 1){
            return false;
        }

        Collections.sort(list);

        int p1 = 0;

        int p2 = list.size()-1;

        while (p1 < p2){
            if(list.get(p1) + list.get(p2) == value){
                return true;
            }else if(list.get(p1) + list.get(p2) < value){
                p1++;
            }else {
                p2--;
            }
        }

        return false;
    }


}

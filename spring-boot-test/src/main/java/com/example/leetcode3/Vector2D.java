package com.example.leetcode3;

import java.util.LinkedList;

/**
 * @author yingru.ljw
 * @date 2020-02-28 21:11
 */
public class Vector2D {

    LinkedList<Integer> linkedList = new LinkedList<>();

    int index = 0;

    public Vector2D(int[][] v) {
       for(int[] arr : v){
           for(int tmp : arr){
               linkedList.add(tmp);
           }
       }
    }

    public int next() {
        int res = linkedList.get(index);
        index++;
        return res;

    }

    public boolean hasNext() {
        return index != linkedList.size();
    }


}

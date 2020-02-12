package com.example.leetcode1.leetcodecopy1;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-06 22:49
 */
public class 合并区间 {

    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        arr[0] = new int[]{1,3};
        arr[1] = new int[]{2,6};
        arr[2] = new int[]{8,10};
        arr[3] = new int[]{15,18};

        int[][] ints = new 合并区间().merge(arr);
        System.out.println(ints);

    }


    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }

        List<Interval> list = new ArrayList<>();

        List<Interval> res = new ArrayList<>();

        //先初始化
        for (int[] arr:intervals){
            list.add(new Interval(arr[0],arr[1]));
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start){
                    return -1;
                }else if(o1.start == o2.start){
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(list.get(0));

        for (Interval cur :list){
            Interval tmp = stack.pop();
            int tmpStart = tmp.start;
            int tmpEnd  = tmp.end;

            int curStart = cur.start;
            int curEnd = cur.end;

            if(curStart <= tmpEnd){
                Interval n1 = new Interval(tmpStart,Math.max(tmpEnd,curEnd));
                stack.push(n1);
            }else {
                stack.push(cur);
                res.add(tmp);

            }
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        int[][] ints = new int[res.size()][2];
        for (int i=0; i <res.size() ; i++){
            ints[i] = new int[]{res.get(i).start,res.get(i).end};
        }

        return ints;


    }

    public static class Interval{

        int start;

        int end;

        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }

    }


}

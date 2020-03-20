package com.example.leetcode1.copy2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-03-19 19:32
 */
public class 第56题合并区间 {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new 第56题合并区间().merge(arr);


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

        list.sort(Comparator.comparingInt(o -> o.start));

        Stack<Interval> stack = new Stack<>();
        stack.push(list.get(0));

        for (Interval cur :list){
            Interval tmp = stack.pop();
            if(tmp.end >= cur.start) {
                Interval n1 = new Interval(tmp.start,Math.max(tmp.end,cur.end));
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

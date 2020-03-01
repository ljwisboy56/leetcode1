package com.example.leetcode3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-28 21:14
 */
public class 会议室 {

    public static void main(String[] args) {
        int[][] a = {{2,4},{7,10}};
        boolean res =new 会议室().canAttendMeetings(a);
        System.out.println(res);

    }

    class Interval{
        int start ;
        int end ;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }


    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
            return true;
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
            if(tmp.end > cur.start) {
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

        return list.size() == res.size();

    }
}

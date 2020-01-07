package com.example.leetcode1;

import com.example.order.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-07 17:49
 */
public class 合并区间 {

    static class Intervl{
        int start = 0;
        int end = 0;

        public Intervl(int start,int end){
            this.start = start;
            this.end = end;
        }

    }

    /**
     *
     *
     * https://blog.csdn.net/weixin_30363263/article/details/80265742
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        List<Intervl> list = new ArrayList<>();

        for (int[] arr : intervals){
            list.add(new Intervl(arr[0],arr[1]));
        }

        int len = intervals.length;

        Intervl tmp = list.get(0);

        list.sort(Comparator.comparingInt(o -> o.start));

        for(int i = 1; i < len; i++){
            //如果说tmp的end大于下一个端点的起点
            if(tmp.end >= list.get(i).start){
                tmp.end = Math.max(list.get(i).end,tmp.end);
            }else {
                list.add(tmp);
                tmp = list.get(i);
            }
            //如果是最后一个，如果最后一个走进了条件if则满足也进不来，需要把它加进来，
            // 如果走进了分支2，则取到的肯定是null加不进来
            if(i == len-1){
                list.add(tmp);
            }
        }

        int[][] res = new int[list.size()][2];

        for(int i = 0; i < list.size();i++){
            res[i][0] = list.get(i).start;
            res[i][1] = list.get(i).end;
        }

        return res;

    }



}

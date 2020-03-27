package com.example.leetcode2.copy2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-03-25 14:53
 */
public class 第128题最长连续序列 {
    public int longestConsecutive(int[] nums) {
        //构建一个并查集
        UnionFind unionFind = new UnionFind(nums);

        //遍历去判断
        for (int num : nums) {
            if(unionFind.findFarter(num-1) != null){
                unionFind.union(num - 1, num);
            }
        }

        int max = 0;
        for(Map.Entry<Integer,Integer> entry : unionFind.sizeMap.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        return max;

    }

    class UnionFind {

        //k-是儿子，value是父亲
        public HashMap<Integer, Integer> faterMap;

        public HashMap<Integer, Integer> sizeMap;

        /**
         * 并查集的初始化
         *
         * @param nums
         */
        public UnionFind(int[] nums) {
            faterMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int tmp : nums) {
                faterMap.put(tmp, tmp);
                sizeMap.put(tmp, 1);
            }
        }


        public Integer findFarter(Integer son) {
            if(faterMap.get(son) == null){
                return null;
            }
            int fatrer = faterMap.get(son);
            if (fatrer != son) {
                fatrer = findFarter(fatrer);
            }

            faterMap.put(son, fatrer);
            return fatrer;
        }

        /**
         * 路径压缩分组 a和b一定是能分到一组的，
         * 至于说怎么判断能不能分到右业务层面去判断
         * 该函数只负责分组
         */
        public void union(int sona, int sonb) {

            int fartera = findFarter(sona);
            int farterb = findFarter(sonb);

            if (fartera != farterb) {
                int sizea = sizeMap.get(fartera);
                int sizeb = sizeMap.get(farterb);

                if (sizea <= sizeb) {
                    //设定a的父亲是b
                    faterMap.put(fartera, farterb);
                    sizeMap.put(farterb, sizea + sizeb);
                } else {
                    faterMap.put(farterb, fartera);
                    sizeMap.put(fartera, sizea + sizeb);
                }
            }
        }

    }

}

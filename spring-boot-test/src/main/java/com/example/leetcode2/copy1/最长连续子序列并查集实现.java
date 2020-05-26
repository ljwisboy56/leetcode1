package com.example.leetcode2.copy1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-02-21 13:31
 */
public class 最长连续子序列并查集实现 {

    public static void main(String[] args) {
        int res = new 最长连续子序列并查集实现().longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(res);
    }

    public int longestConsecutive(int[] nums) {

        UnionFind unionFind = new UnionFind(nums);

        for (int i = 0;i < nums.length;i++){
            if(unionFind.faterMap.containsKey(nums[i]-1)){
                unionFind.union(nums[i]-1,nums[i]);
            }
        }

        int max = 0;
        for(Map.Entry<Integer,Integer> entry : unionFind.sizeMap.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        return max;

    }

    class UnionFind {

        private int size;

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
            size = nums.length;
            for (int tmp : nums) {
                faterMap.put(tmp, tmp);
                sizeMap.put(tmp, 1);
            }
        }


        public Integer findFarter(Integer son) {

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

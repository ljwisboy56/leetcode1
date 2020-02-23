package com.example.leetcode2.copyleetcode2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-21 00:21
 */
public class 最长连续子序列并查集 {


    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果父集合里面包含这个节点？
            //首先nums[i]一定是存在的，因为你并查集初始化的时候全都初始化进去了
            //但是此时没触发合并
            //对并查集进行一合并
            //首先看下当前数-1即连续的树在不在并查集里面，
            //如果在直接把他俩合并到一个集团里
            if (uf.fatherMap.containsKey(nums[i] - 1)) {
                //那么把他和他的前前一个节点合并一下
                uf.union(nums[i] - 1, nums[i]);
            }
        }
        return uf.max;
    }

    public class UnionFind {

        int max;

        //存的是每个集团内部的父子关系图<k:v>k是子节点，v是父节点
        HashMap<Integer, Integer> fatherMap;

        //存的是集团父节点之间的权重, k是父节点的值，v是权重
        HashMap<Integer, Integer> sizeMap;

        public UnionFind(int[] nums) {
            max = 1;//处理nums中只有一个元素的情况下，默认为1
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (int key : nums) {
                fatherMap.put(key, key);
                sizeMap.put(key, 1);
            }
        }

        public int findFather(int val) {
            int father = fatherMap.get(val);
            //如果他的父节点不是他本身，那么就去递归的找出他的父节点
            //直到找到他的父节点是他本身为止
            if (father != val) {
                father = findFather(father);
            }
            //最短路径压缩，把他的父节点更新为最根上的父节点
            fatherMap.put(val, father);
            return father;
        }

        public void union(int a, int b) {
            //找到a的父节点
            int aFather = findFather(a);
            //找到b的父节点
            int bFather = findFather(b);
            //如果a不等于b说明他俩不是一个集团的
            if (aFather != bFather) {
                //那么在tl群里面找到他的size个数
                int aSize = sizeMap.get(aFather);
                //找到b节点对应的size个数
                int bSize = sizeMap.get(bFather);
                //如果asize小于bsize，那么a就要归到b的节点里面
                if (aSize <= bSize) {
                    //那么把a合并到b里面
                    fatherMap.put(aFather, bFather);
                    //然后b的规模扩大为a+b
                    sizeMap.put(bFather, aSize + bSize);
                } else {
                    //负责把b归入a
                    fatherMap.put(bFather, aFather);
                    sizeMap.put(aFather, aSize + bSize);
                }
                //最后找出最大的值
                max = Math.max(max, aSize + bSize);
            }
        }
    }
}

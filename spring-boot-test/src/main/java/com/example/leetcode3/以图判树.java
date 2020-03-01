package com.example.leetcode3;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-29 17:52
 */
public class 以图判树 {

    /**
     * 判断图是不是树，满足两点
     *
     * 1\是连通图
     * 1\不存在环
     */
    public boolean validTree(int n, int[][] edges) {

        UnionFind unionFind =new UnionFind(edges);

        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])){
                return false;
            }
        }
        return unionFind.count == 1;


    }

    class UnionFind{

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        HashMap<Integer,Integer> hashSize = new HashMap<>();

        int count ;

        UnionFind(int[][] edges){

            for (int[] edge : edges) {
              hashMap.put(edge[0],edge[0]);
              hashMap.put(edge[1],edge[1]);
              hashSize.put(edge[1],1);
              hashSize.put(edge[0],1);
            }
            this.count = edges.length;
        }

        private int findFather(int x){
            int tmp = hashMap.get(x);
            if(x != tmp){
                tmp = findFather(tmp);
            }
            return tmp;
        }


        public boolean union(int x,int y){

            int xfater = findFather(x);
            int yfater = findFather(y);

            if(xfater == yfater){
                return false;
            }

            int sizex = hashSize.get(x);
            int sizey = hashSize.get(y);

            if(sizex > sizey){
                hashMap.put(yfater,xfater);
                hashSize.put(xfater,sizex+sizey);
            }else {
                hashMap.put(xfater,yfater);
                hashSize.put(yfater,sizex+sizey);
            }
            count--;
            return true;
        }
    }

}

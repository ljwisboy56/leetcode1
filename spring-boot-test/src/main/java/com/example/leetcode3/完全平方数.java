package com.example.leetcode3;


import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-03-01 18:17
 */
public class 完全平方数 {

    public static void main(String[] args) {
        int res = new 完全平方数().numSquares2(13);
        System.out.println(res);


    }

    int target = 0;

    int min = Integer.MAX_VALUE;

    List<Integer> list = new ArrayList<>();

    public int numSquares(int n) {


        this.target = n;

        dfs(1,0);

        return min;

    }

    private void dfs(int n, int sum) {
        if(n >= target){
            return;
        }else if(sum == target){
            min = Math.min(min,list.size());
            return;
        }else {
            for (int i = n; i < target; i++) {
                sum += i * i;
                list.add(i*i);
                if(sum > target){
                    sum -= i * i;
                    list.remove(list.size()-1);
                    break;
                }
                if(sum == target){
                    sum -= i * i ;
                    min = Math.min(min,list.size());
                    list.remove(list.size()-1);
                    break;
                }
                dfs(i,sum);
                sum -= i * i;
                list.remove(list.size()-1);
            }
        }
    }

    public int numSquares2(int n) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);

        int level = 0;

        while (!queue.isEmpty()){
            level++;
            int len =  queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                for (int j = 1; j *j <=cur ; j++) {
                    int tmp = cur -j *j;
                    if(tmp == 0){
                        return level;
                    }
                    if(!set.contains(tmp)){
                        queue.offer(tmp);
                    }
                    set.add(tmp);
                }
            }
        }
        return level;
    }

}

package com.example.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-29 18:11
 */
public class 丑数 {

    public static void main(String[] args) {
        System.out.println(new 丑数().isUgly(6));
    }

    private static HashSet<Integer> set = new HashSet<>();

    static {
        set.add(2);
        set.add(3);
        set.add(5);
    }

    List<Integer> list = new ArrayList<>();

    int target = 0;

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        while (num != 1){
            if ( num % 2 == 0){
                num /= 2;
            } else if ( num % 3 == 0){
                num /= 3;
            } else if ( num % 5 == 0){
                num /= 5;
            } else{
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n, int sum) {

        if(sum > target){
            return false;
        }else if(target == sum){
            for (int tmp :list){
                if(!set.contains(tmp)){
                    return false;
                }
            }
            return true;
        }else {
            for (int i = n; i <= target; i++) {
                if(target % i == 0){
                    sum *= i;
                    list.add(i);
                    if(sum > target){
                        sum/=i;
                        list.remove(list.size()-1);
                        break;
                    }
                    if(dfs(i,sum)){
                        return true;
                    }
                    sum/=i;
                    list.remove(list.size()-1);
                }

            }
        }
        return false;
    }


}

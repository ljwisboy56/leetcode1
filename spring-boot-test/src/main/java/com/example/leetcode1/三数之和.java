package com.example.leetcode1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * @author yingru.ljw
 * @date 2019-12-31 23:49
 */
public class 三数之和 {

    static int[] x = null;

    HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {

        int[] nums = new int[]{3,0,3,2,-4,0,-3,2,2,0,-1,-5};

        int[] res = Arrays.stream(nums).sorted().toArray();

        Arrays.stream(res).forEach(System.out::println);

        x = new int[nums.length];
        List<List<Integer>> lists = new 三数之和().threeSum2(res);
        System.out.println(lists);

    }

    List<List<Integer>> allList = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        x = new int[nums.length];
        doFind(0,nums);
        System.out.println(allList);
        return allList;
    }


    private void doFind(int n, int[] nums) {
        if(n >= nums.length){
            output(x,nums);
        }else {
            for(int i =0;i <= 1;i++){
               x[n] = i;
               if(bound(x,n)){
                   doFind(n+1,nums);
               }
               x[n] = 0;
            }
        }
    }

    private boolean bound(int[] x,int n) {
        int count = 0;
        for (int value : x) {
            if (value == 1) {
                count++;
            }
        }
        return count <= 3;
    }

    private void output(int[] x,int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < x.length;i++){
            if(x[i] == 1){
                list.add(nums[i]);
            }
        }
        if (list.size() != 3){
            return;
        }

        int sum =0;
        for(Integer integer : list){
            sum += integer;
        }

        if(sum == 0){
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list){
                sb.append(integer);
            }
            String key = sb.toString();
            if(!set.contains(key)){
                set.add(key);
                allList.add(list);
            }
        }

    }

    List<List<Integer>> res = new ArrayList();

    List<Integer> list = new ArrayList<>();


    /**
     *  int[] nums = new int[]{1,0,-1,2,-2};
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        //求出数组的长度
        int len = nums.length;
        //先排序一把
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(new ArrayList<>(list));
                    while (r > l && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    while (r > l && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

}

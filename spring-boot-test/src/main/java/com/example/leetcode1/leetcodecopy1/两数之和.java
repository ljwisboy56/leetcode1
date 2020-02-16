package com.example.leetcode1.leetcodecopy1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-18 18:16
 */
public class 两数之和 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,3};
        int[] rr = new 两数之和().twoSum2(arr,6);
        System.out.println(rr);

    }

    int target ;

    int[] x ;

    int[] res ;

    public int[] twoSum(int[] nums, int target) {

        x = new int[nums.length];

        this.target = target;

        doTwoSum(0,nums);

        return res;

    }

    private void doTwoSum(int n, int[] nums) {

        if(n >= nums.length){
           return;
        }else {
            for (int i =0;i <= 1; i++){
                x[n] = i;
                if(constraint(x,nums)){
                    doTwoSum(n+1,nums);
                }else {
                    output(x,nums);
                }
                x[n] = 0;
            }
        }


    }

    private boolean constraint(int[] x, int[] nums) {
        int sum = 0;
        for (int i =0; i < x.length;i++){
            if(x[i] == 1){
                sum += nums[i];
            }
        }
        return sum != target;
    }

    private void output(int[] x, int[] nums) {

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < x.length;i++){
            if(x[i]==1){
                sum += nums[i];
                list.add(i);
            }
        }


        if(sum == target && list.size()==2){
            res = new int[list.size()];
            for (int i=0;i<list.size();i++){
                res[i] = list.get(i);
            }
        }
    }


    public int[] twoSum2(int[] nums, int target) {
        int[] res= new int[2];

        if(nums == null || nums.length == 0){
            return res;
        }



        List<Integer> list = new ArrayList<>();
        for (int tmp : nums){
            list.add(tmp);
        }


        //先排序一遍数组
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if(nums[left] + nums[right] == target){

                res[0] = list.indexOf(nums[left]);
                list.set(res[0], Integer.MIN_VALUE);
                res[1] = list.indexOf(nums[right]);
                list.set(res[1], Integer.MIN_VALUE);
//                while (left < right){
//                    if(nums[left] == nums[left + 1]){
//                        left++;
//                    }
//                }
//                while (left < right){
//                    if(nums[right] == nums[left - 1]){
//                        right--;
//                    }
//                }
//                left++;
//                right--;
                break;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return res;

    }


}

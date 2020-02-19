package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 01:26
 */
public class 两数之和2 {

    public int[] twoSum2(int[] numbers, int target) {

        int[] res = new int[2];

        int mid = 0;

        int start = 0;

        int end = numbers.length-1;

        while (start < end){

            mid = start + (end - start)/2;

            if(numbers[start] + numbers[end] == target){
                res[0] = start;
                res[1] = end;
                return res;
            }

            if(2 * mid >= target){
                end = mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] arr = {2,7,11,15};
        int[] res = new 两数之和2().twoSum(arr,9);

    }

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        if(numbers == null || numbers.length ==0){
            return res;
        }

        int start = 0;
        int end = numbers.length-1;
        while (start < end){
            if(numbers[start] + numbers[end] > target){
                end--;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else {
                res[0] = start+1;
                res[1] = end+1;
                return res;
            }
        }

        return res;
    }

}

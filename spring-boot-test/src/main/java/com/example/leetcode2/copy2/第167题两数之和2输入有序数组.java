package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 00:54
 */
public class 第167题两数之和2输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length-1;
        while (start < end){
            if(numbers[start] + numbers[end] == target){
                break;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else {
                end--;
            }
        }
        res[0] = start+1;
        res[1] = end+1;
        return res;
    }

}

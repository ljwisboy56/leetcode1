package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-01 22:22
 */
public class 四数之和 {

    public static void main(String[] args) {
        List<List<Integer>> allList = new 四数之和().fourSum(new int[]{1,0,-1,0,-2,2},0);
        System.out.println(allList);


    }


    List<List<Integer>> allList = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int len = nums.length;

        Arrays.sort(nums);

        for (int i =0; i < len;i++){

            int real = target - nums[i];

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int[] tmpNums = Arrays.copyOfRange(nums,i+1,len);
            threeSum(tmpNums,real,nums[i]);
        }

        return allList;

    }

    private void threeSum(int[] tmpNums, int real ,int cur) {

        int len = tmpNums.length;

        for (int i=0;i < len;i++){
            //过滤掉重复的
            if (i> 0 && tmpNums[i-1] == tmpNums[i]) {
                continue;
            }

            int realReal = real - tmpNums[i];
            int left = i+1;
            int right = len-1;

            while (left < right){
                if(tmpNums[left] + tmpNums[right] == realReal){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(tmpNums[left]);
                    list.add(tmpNums[right]);
                    list.add(tmpNums[i]);
                    list.add(cur);
                    allList.add(new ArrayList<>(list));
                    while (left < right && tmpNums[left] == tmpNums[left+1]){
                        left++;
                    }
                    while (left < right && tmpNums[right] == tmpNums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(tmpNums[left] + tmpNums[right] < realReal){
                    left++;
                }else {
                    right--;
                }
            }

        }
    }

}

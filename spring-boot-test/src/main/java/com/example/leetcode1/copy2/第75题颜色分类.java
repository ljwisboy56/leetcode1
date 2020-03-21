package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-21 16:10
 */
public class 第75题颜色分类 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        new 第75题颜色分类().sortColors(arr);
        System.out.println(arr);

    }

    /**
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {

        if(nums == null || nums.length == 0) return;
        int max = 2;
        int min = 0;

        //构建桶
        int[] bucket = new int[max-min +1];
        for(int tmp : nums){
            bucket[tmp-min]++;
        }

        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
           while (bucket[i] != 0){
               nums[k++] = i +min;
               bucket[i]--;
           }
        }
    }

}

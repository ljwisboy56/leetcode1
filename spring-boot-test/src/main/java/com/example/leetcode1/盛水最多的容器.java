package com.example.leetcode1;


/**
 * @author yingru.ljw
 * @date 2019-12-31 20:52
 */
public class 盛水最多的容器 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};

        int res = new 盛水最多的容器().maxArea(arr);

        System.out.println(res);

    }

    private int max = Integer.MIN_VALUE;

    public int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }


        for(int i = 0; i < height.length;i++){
            for(int j = i+1;j < height.length;j++){
                int area = calculated(i,j,height);
                max = Math.max(max,area);
            }
        }

        return max;

    }


    private int calculated(int x,int y,int[] arr){
        int chang = y - x;
        int kuan = Math.min(arr[y],arr[x]);
        return chang * kuan;

    }

    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}

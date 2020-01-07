package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-21 02:47
 */
public class TwoArrSearch {

    public static void main(String[] args) {
        int[][] a = new int[][]{{}};
        int target = 1;

    }

    public boolean Find(int target, int[][] array) {
        int res = -1;
        for (int i = 0; i < array.length; i++) {
            res = doBinarySearch2(array[i], target, 0, array[0].length - 1);
            if (res != -1) {
                return true;
            }
        }
        return false;

    }

    private int doBinarySearch2(int[] arr, int target, int left, int right) {
        if (arr.length == 0 || arr[left] > target || arr[right] < target) {
            return -1;
        }

        int finalIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return finalIndex;
    }
}

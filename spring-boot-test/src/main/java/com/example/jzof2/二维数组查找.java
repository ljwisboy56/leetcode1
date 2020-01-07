package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 17:20
 */
public class 二维数组查找 {

    public static void main(String[] args) {
        int[] ins = new int[]{1,3,5,6,7,9,10};
        boolean res = new 二维数组查找().binarySearch(1,ins);
        System.out.println(res);
    }

    public boolean Find(int target, int [][] array) {

        if(array == null){
            return false;
        }

        boolean res = false;
        for (int[] ints : array) {
            res = binarySearch(target,ints);
            if (res) {
                break;
            }
        }
        return res;
    }

    private boolean binarySearch(int target,int[] ints) {
        return doBinartySearch(0,ints.length-1,target,ints);
    }

    private boolean doBinartySearch(int left, int right, int target, int[] ints) {

        if(left > right){
            return false;
        }

        int mid = (left+right)/2;
        if(ints[mid] < target){
            return doBinartySearch(mid+1,right,target,ints);
        }else if(ints[mid] > target){
            return doBinartySearch(left,mid-1,target,ints);
        }else {
            return true;
        }

    }

}

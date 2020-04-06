package com.example.ebay;

/**
 * @author yingru.ljw
 * @date 2020-04-01 16:10
 */
public class EbayTest {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,4};
        int[] a2 = new int[]{2,3,4,5};

        System.out.println(new EbayTest().find(a1,a2,4));

    }


    public int find(int[] arr1,int[] arr2,int k){

        int[] nums = new int[arr1.length+arr2.length];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < arr1.length && p2 < arr2.length){
            if(index == k){
                return nums[k-1];
            }
            if(arr1[p1] <= arr2[p2]){
                nums[index] = arr1[p1];
                p1++;
                index++;
            }else {
                nums[index] = arr2[p2];
                p2++;
                index++;
            }
        }

        while (p1 < arr1.length){
            if(index == k){
                return nums[k-1];
            }
            nums[index] = arr1[p1];
            p1++;
            index++;
        }

        while (p2 < arr2.length){
            if(index == k){
                return nums[k-1];
            }
            nums[index] = arr2[p2];
            p2++;
            index++;
        }
        return -1;

    }
}

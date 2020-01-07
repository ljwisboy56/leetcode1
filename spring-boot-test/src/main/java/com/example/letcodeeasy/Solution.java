package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-21 02:07
 */
public class Solution {

    public boolean find(int [][] array,int target) {

        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid]){
                    low=mid+1;
                }
                else if(target<array[i][mid]){
                    high=mid-1;
                }
                else{
                    return true;
                }
            }
        }
        return false;

    }


}

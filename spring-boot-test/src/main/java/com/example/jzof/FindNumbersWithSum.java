package com.example.jzof;

import org.hibernate.validator.constraints.Mod11Check;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-12-16 22:04
 */
public class FindNumbersWithSum {


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,7,11,15};
        int sum = 15;

        ArrayList<Integer> res = new  FindNumbersWithSum().FindNumbersWithSum(arr,sum);
        System.out.println(res);


    }

    /**
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if(array == null || array.length == 0){
            return resList;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int tmp : array){
            if(tmp <= sum){
                list.add(tmp);
            }
        }

        int resSum ;
        long realSum = Long.MAX_VALUE;
        for(int i = 0;i < list.size();i++){
            for(int j =i+1;j<list.size();j++){
                if(array[i] + array[j] == sum){
                    resSum = array[i] * array[j];
                    if(realSum > resSum){
                        realSum = resSum;
                        resList.clear();
                        resList.add(array[i]);
                        resList.add(array[j]);
                    }
                }
            }
        }
        return resList;
    }
}

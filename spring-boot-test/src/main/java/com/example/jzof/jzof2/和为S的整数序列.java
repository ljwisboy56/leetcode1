package com.example.jzof.jzof2;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-29 16:47
 */
public class 和为S的整数序列 {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> res = new 和为S的整数序列().FindContinuousSequence(10);
        System.out.println(res);


    }


    ArrayList<ArrayList<Integer>> allList = new ArrayList<>();

    ArrayList<Integer> list = new ArrayList<>();

    int target = 0;

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        this.target = sum;

        doFind(1);

        return allList;
    }

    private void doFind(int n) {
        if(judege(list)){
            return;
        }else {
            list.add(n);
            for(int i = n;i < target;i++){
                if(judege(list)){
                    allList.add(new ArrayList<>(list));
                    break;
                }else if(bound(i,n) && constraint(list)){
                    doFind(n+1);
                }else {
                    break;
                }
            }
            list.remove(list.size()-1);
        }

    }

    private boolean judege(ArrayList<Integer> list) {

        int sum = 0;
        for(Integer tmp : list){
            sum += tmp;
        }
        return sum == target;
    }

    private boolean bound(int n,int i ) {
        return Math.abs(n - i) <= 1;
    }

    private boolean constraint(ArrayList<Integer> list) {
        int sum = 0;
        for(Integer tmp : list){
            sum += tmp;
        }
        return sum < target;

    }

}

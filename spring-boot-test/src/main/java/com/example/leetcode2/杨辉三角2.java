package com.example.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-13 12:46
 */
public class 杨辉三角2 {

    List<List<Integer>> allList = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {

        doFindRes(1,rowIndex);

        return allList.get(allList.size()-1);
    }

    private void doFindRes(int n, int numRows) {
        if(n > numRows+1){
            return;
        }else if(n == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            allList.add(list);
            doFindRes(n+1,numRows);
        }else {
            List<Integer> list = new ArrayList<>();
            //直接拿
            List<Integer> preList = allList.get(allList.size()-1);
            for (int i = 0; i < n;i++){
                if(i == 0){
                    list.add(1);
                }else if(i == preList.size()){
                    list.add(1);
                }else {
                    list.add(preList.get(i-1) + preList.get(i));
                }
            }
            allList.add(list);
            doFindRes(n+1,numRows);
        }
    }


}

package com.example.jzof;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2019-12-21 21:28
 */
public class movingCount {

    public static void main(String[] args) {

        int res = new movingCount().movingCount(15,20,20);
        System.out.println(res);


    }

    HashSet<String> set = new HashSet<>();

    int threshold;


    public int movingCount(int threshold, int rows, int cols) {

        if(threshold < 0){
            return 0;
        }

        this.threshold = threshold;

        doMovingCount(0,0,rows,cols);

        return set.size();

    }

    private void doMovingCount(int i, int j, int rows,int cols) {

        if(i >= rows || j >= cols){
            return;
        }else {
            if(set.contains( String.valueOf(i) +"-" + String.valueOf(j))){
                return;
            }
            for(int k =0;k <= 1;k++){
                for(int m = 0;m <= 1;m++){
                    if(m == k && m == 0){
                        continue;
                    }
                    if(constraint(i,j)){
                        return;
                    }else {
                        countSet(i,j);
                        doMovingCount(i+k,j+m,rows,cols);
                    }
                }
            }
        }
    }

    private void countSet(int k, int m) {
        String key = String.valueOf(k) +"-" + String.valueOf(m);
        set.add(key);
    }

    private boolean constraint(int k, int m) {
        int sum = 0;

        String[] kstr = String.valueOf(k).split("");
        for(String tmp : kstr){
            sum += Integer.valueOf(tmp);
        }

        String[] mstr = String.valueOf(m).split("");
        for(String tmp : mstr){
            sum += Integer.valueOf(tmp);
        }

        return sum > threshold;

    }
}

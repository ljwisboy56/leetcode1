package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-24 23:18
 */
public class RectCover {


    public int RectCover(int target) {


        if(target == 0){
            return -1;
        }

        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }

        int one = 1;
        int two = 2;
        int res = 0;
        for(int i = 2;i<= target;i++){
            res = one+two;
            one = two;
            two = res;
        }
        return res;


    }


}

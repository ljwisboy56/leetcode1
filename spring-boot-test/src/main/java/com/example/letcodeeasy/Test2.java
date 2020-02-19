package com.example.letcodeeasy;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-11-12 23:41
 */
public class Test2 {


    public int reverse(int x) {
        String strs = String.valueOf(x);
        char[] chars = strs.toCharArray();
        char[] resChars = new char[chars.length];
        if(chars[0] == '-'){
            for(int tmp = 0 ;tmp < chars.length; tmp++){
                resChars[tmp+1] = resChars[chars.length - 1 -tmp];
            }
        }else {
            for(int tmp = 0 ;tmp < chars.length; tmp++){
                resChars[tmp] = resChars[chars.length - 1 -tmp];
            }
        }

        List<Character>  finalChars = new ArrayList<>();
        for(int i =0;i < resChars.length ; i++){
            if(resChars[i] == '-'){
                finalChars.add(resChars[i]);
                if(resChars[i+1] != '0'){
                    finalChars.add(resChars[i+1]);
                }
            }else {
                if(resChars[i] != '0'){
                    finalChars.add(resChars[i+1]);
                }
            }
        }

        char[] ff = new char[finalChars.size()];
        int i = 0;
        for(Character character : finalChars){
            ff[i++] = character;
        }
        return Integer.valueOf(new String(ff));

    }

    public static void main(String[] args) {
        int mid = 0 + ((9-0) >> 1);
        System.out.println(mid);

    }


}

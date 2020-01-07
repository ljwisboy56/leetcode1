package com.example.jzof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-12-16 22:26
 */
public class LeftRotateString {

    public static void main(String[] args) {
        String str = new LeftRotateString().LeftRotateString("",6);
        System.out.println(str);

    }


    public String LeftRotateString(String str,int n) {

        if(str == null || str.equals("") ){
            return "";
        }

        char[] chars = str.toCharArray();

        //先把需要左移的字符串给存起来
        List<Character> characters = new ArrayList<>();


        for(int i = n;i < chars.length;i++){
            characters.add(chars[i]);
        }

        for(int i =0;i< n;i++){
            //把需要左移的给放在后面
            characters.add(chars[i]);
        }

        StringBuilder tmp = new StringBuilder();

        for(Character character : characters){
            tmp.append(character);
        }

        return tmp.toString();


    }
}

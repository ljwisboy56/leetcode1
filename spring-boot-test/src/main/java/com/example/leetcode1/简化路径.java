package com.example.leetcode1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yingru.ljw
 * @date 2020-01-09 17:34
 */
public class 简化路径 {

    public static void main(String[] args) {
        String tes = "/home/";
        String res = new 简化路径().simplifyPath(tes);
        System.out.println(res);



    }

    public String simplifyPath(String path) {

        if(path == null){
            return null;
        }

        String[] strings = path.split("/");

        LinkedList<String> characters = new LinkedList<>();
        characters.add("flag");
        characters.add("/");
        for (int i = 1; i < strings.length;i++){
            if("".equals(strings[i])){
                continue;
            }else if(strings[i].equals(".")){
                continue;
            }else if(strings[i].equals("..")){
                String tmp = characters.get(characters.size()-2);
                if("flag".equals(tmp)){
                    continue;
                }else {
                    characters.remove(characters.size()-1);
                    characters.remove(characters.size()-1);
                }
            }else {
                characters.add(strings[i]);
                characters.add("/");
            }
        }

        //把第一个flag删掉
        characters.remove(0);
        if(characters.size() == 1 && characters.get(0).equals("/")){
            return "/";
        }else {
            String res = "";
            for (int i = 0;i < characters.size()-1;i++){
                res += characters.get(i);
            }
            return res;

        }

    }

}

package com.example.leetcode1.copy2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-03-20 14:04
 */
public class 第71题简化路径 {

    public static void main(String[] args) {

        String aa= "/home//foo/";
        String res = new 第71题简化路径().simplifyPath(aa);
        System.out.println(res);
    }

    public String simplifyPath(String path) {
        if(path == null || "".equals(path.trim())){
            return "";
        }

        String[] strings = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for(String str : strings){
            if("".equals(str) || ".".equals(str)){
                continue;
            }else if("..".equals(str)){
                if(!stack.isEmpty()){
                    stack.pollLast();
                    stack.pollLast();
                }
            }else {
                stack.add(str);
                stack.add("/");
            }
        }

        if(!stack.isEmpty()){
            stack.pollLast();
        }
        //做最后一个边界处理
        stack.addFirst("/");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stack){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();

    }

}

package com.example.leetcode1.leetcodecopy1;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-08 14:56
 */
public class 简化路径 {

    public static void main(String[] args) {
        String res = new 简化路径().simplifyPath("/home/");
        System.out.println(res);
    }

    /**
     *
     "/a/../../b/../c//.//"
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        if(path == null || "".equals(path)){
            return "/";
        }

        String[] strings = path.split("/");

        Stack<String> stack = new Stack<>();

        for (int i = 0;i < strings.length;i++){
            if(".".equals(strings[i])){
                continue;
            }else if("..".equals(strings[i])){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                if(!"".equals(strings[i])){
                    stack.push(strings[i]);
                }
            }
        }


        String sb ="/";

        int len = stack.size();

        int count =0;

        Stack<String> tmp = new Stack<>();

        while (!stack.isEmpty()){
            tmp.push(stack.pop());
        }

        while (!tmp.isEmpty()){
            count++;
            if(count == len){
                sb = sb + tmp.pop();

            }else {
                sb = sb + tmp.pop() +'/';
            }
        }
        return sb;

    }

}

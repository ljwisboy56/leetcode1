package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-21 16:16
 */
public class ZPrint {


    private static int count = 0;

    static ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if(pRoot == null){
            return null;
        }


        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);

        Stack<TreeNode> nextStack = new Stack<>();

        stack.add(pRoot);

        while (!stack.isEmpty() || !nextStack.isEmpty()){
            //奇数行
            if(count%2==1){
                ArrayList list = new ArrayList();
                while (!stack.isEmpty()){
                    TreeNode tmp = stack.pop();
                    list.add(tmp);
                    if(pRoot.left != null){

                        nextStack.add(pRoot.left);
                    }
                    if(pRoot.right != null){
                        stack.add(pRoot.left);
                    }
                }
                arrayListArrayList.add(list);
            }else {
                ArrayList list = new ArrayList();
                while (!nextStack.isEmpty()){
                    TreeNode tmp = stack.pop();
                    list.add(tmp);
                    if(pRoot.right != null){

                        nextStack.add(pRoot.right);
                    }
                    if(pRoot.left != null){
                        stack.add(pRoot.left);
                    }
                }
                arrayListArrayList.add(list);
            }
            count++;
        }
        return arrayListArrayList;
    }
}

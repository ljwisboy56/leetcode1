package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-25 15:24
 */
public class 第129题求根到叶子节点数字之和 {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        int sum =  new 第129题求根到叶子节点数字之和().sumNumbers(t1);
        System.out.println(sum);


    }

    List<String> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfs(root);
        int sum = 0;
        for(String str : allList){
            sum += Integer.valueOf(str);
        }

        return sum;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : list){
                stringBuilder.append(integer);
            }
            allList.add(stringBuilder.toString());
            return;
        }else {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
            list.remove(list.size()-1);
        }
    }

}

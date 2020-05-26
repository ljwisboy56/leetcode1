package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-21 14:17
 */
public class 求根到叶子节点数字之和 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;

        int res = new 求根到叶子节点数字之和().sumNumbers(root);
        System.out.println(res);


    }

    List<Integer> list= new LinkedList<>();

    int max = 0;

    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }

        dfs(root);

        return max;

    }


    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }else if(root.right == null && root.left == null){
            list.add(root.val);
            StringBuilder stringBuilder = new StringBuilder();
            for (int tmp : list){
                stringBuilder.append(tmp);
            }
            max += Integer.valueOf(stringBuilder.toString());
            list.remove(list.size()-1);
            return;
        }else {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
            list.remove(list.size()-1);

        }
    }
}

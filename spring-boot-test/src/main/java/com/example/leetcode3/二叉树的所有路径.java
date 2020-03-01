package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-29 16:43
 */
public class 二叉树的所有路径 {

    List<Integer> list = new ArrayList<>();

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root);

        return res;

    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            list.add(root.val);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if(i == list.size()-1){
                    stringBuilder.append(list.get(i));
                }else {
                    stringBuilder.append(list.get(i)).append("->");
                }
            }
            res.add(stringBuilder.toString());
            list.remove(list.size()-1);
        }else {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
            list.remove(list.size()-1);
        }
    }

}

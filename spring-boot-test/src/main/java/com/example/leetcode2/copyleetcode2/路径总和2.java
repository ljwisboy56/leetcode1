package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-19 22:42
 */
public class 路径总和2 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        List<List<Integer>> res = new 路径总和2().pathSum(t1,7);
        System.out.println(res);
    }

    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> allList = new LinkedList<>();
        if(root == null){
            return allList;
        }

        List<Integer> list = new ArrayList<>();
        this.target = sum;
        return dfs(root,0,allList,list);
    }

    private List<List<Integer>> dfs(TreeNode root, int sum, List<List<Integer>> allList,List<Integer> list) {
        if(root == null){
            return allList;
        }else if(root.left == null && root.right == null){
            sum += root.val;
            list.add(root.val);
            if(sum == target){
                allList.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
        }else{
            sum += root.val;
            list.add(root.val);
            dfs(root.left,sum,allList,list);
            dfs(root.right,sum,allList,list);
            list.remove(list.size()-1);
        }
        return allList;
    }

}

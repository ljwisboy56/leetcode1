package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-12 20:35
 */
public class 路径总和2 {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(3);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l3.left = l5;
        l3.right = l6;


        List<List<Integer>> allList = new 路径总和2().pathSum(l1,7);
        System.out.println(allList);
    }

    int target = 0;

    List<List<Integer>> allList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root == null){
            return allList;
        }

        target = sum;

        this.doFindPath(root,0);

        return allList;

    }

    private void doFindPath(TreeNode root, int sum) {
        if(root != null && root.left == null && root.right == null){
            sum += root.val;
            list.add(root.val);
            if(sum == target){
                allList.add(new ArrayList<>(list));
            }
        }else {
            sum += root.val;
            list.add(root.val);
            if(root.left != null){
                doFindPath(root.left,sum);
                list.remove(list.size()-1);
            }

            if(root.right != null){
                doFindPath(root.right,sum);
                list.remove(list.size()-1);
            }
        }
    }

}
